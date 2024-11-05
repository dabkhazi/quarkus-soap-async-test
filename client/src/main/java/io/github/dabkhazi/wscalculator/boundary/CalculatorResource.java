package io.github.dabkhazi.wscalculator.boundary;

import io.github.dabkhazi.wscalculator.calculator.CalculatorService;
import io.github.dabkhazi.wscalculator.calculator.AddResponse;
import io.netty.util.concurrent.Future;
import io.quarkiverse.cxf.annotation.CXFClient;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {
  
    @Inject
    @CXFClient("myCalculator") 
    CalculatorService calculator;

    @SuppressWarnings("unchecked")
    @Path("/add-async")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<Integer> addAsync(@QueryParam("a") int a, @QueryParam("b") int b) {
        return Uni.createFrom()
                .future(
                        (Future<AddResponse>) calculator
                                .addAsync(a, b, res -> {
                                }))
                .map(addResponse -> addResponse.getReturn());
    }

    @Path("/add-sync")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int addSync(@QueryParam("a") int a, @QueryParam("b") int b) {
        return calculator.add(a, b);
    }

}
