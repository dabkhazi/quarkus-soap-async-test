# Quarkus CXF Async SOAP Client Test

This project demonstrates the use of Quarkus and Apache CXF to create an asynchronous SOAP client. It includes a server module with a SOAP service and a client module with a REST interface for testing asynchronous SOAP calls.

## Installation and Run

Follow the steps below to install and run the project.

### Installation Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/dabkhazi/quarkus-soap-async-test.git
   cd <project_folder>
   ```

2. Start the SOAP server:

    ```bash
    mvn quarkus:dev -pl server
    ```

3. In another terminal, start the REST client:

    ```bash
    mvn quarkus -Dcalculator.baseUri=http://localhost:8080 -pl client
    ```

### Testing

To test the REST service, run the following `curl` command:

```bash
curl -i http://localhost:8082/calculator/add-async?a=1&b=2
```

### Project Structure

- server - Module containing the SOAP server.
- client - Module containing the REST client for making asynchronous SOAP calls.