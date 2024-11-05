package io.github.dabkhazi.wscalculator.boundary;

import java.util.concurrent.Future;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import io.github.dabkhazi.wscalculator.calculator.AddResponse;
import io.github.dabkhazi.wscalculator.calculator.CalculatorService;
import jakarta.jws.WebService;
import jakarta.xml.ws.AsyncHandler;
import jakarta.xml.ws.Response;

import io.quarkus.logging.Log;

@WebService
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    @UseAsyncMethod
    public int add(int arg0, int arg1) {
        Log.info("Calling sync add ...");
        return arg0 + arg1;
    }

    @Override
    public Response<AddResponse> addAsync(int arg0, int arg1) {
        return null;
    }

    @Override
    public Future<?> addAsync(int arg0, int arg1, AsyncHandler<AddResponse> asyncHandler) {
        Log.info("Calling async add ...");
        ServerAsyncResponse<AddResponse> response = new ServerAsyncResponse<>();
        AddResponse addResult = new AddResponse(){{setReturn(arg0 + arg1);}};
        response.set(addResult);
        asyncHandler.handleResponse(response);
        return response;
    }
    
}
