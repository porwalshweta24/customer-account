# customer account
Backend API to be used for opening a new “current account” of already existing
customers.

## Getting Started
### Summary
An API to be used for opening a new “current account” of already existing
customers.

#### Requirements

• The API will expose an endpoint which accepts the user information (customerID,
initialCredit).

• Once the endpoint is called, a new account will be opened connected to the user whose ID is
customerID.

• Also, if initialCredit is not 0, a transaction will be sent to the new account.

• Another Endpoint will output the user information showing Name, Surname, balance, and
transactions of the accounts.


### Main technologies used
- JDK 11
- Maven
- Spring Boot
- H2 DB
- JUnit/Mockito
- Lombok

### CI/CD Tools
- GitHub Actions
- Maven
- Docker
- Docker Hub

