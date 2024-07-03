# How it works

### Installing
* Clone the repository
```
git clone git@github.com:porwalshweta24/customer-account.git
```

* Go to root project
```
cd customer-account
```

* Change folder mode
```
chmod +x mvnw
```

* Creating an executable JAR
  Execute this command from the root project:
```
./mvnw package
```

### Run the test
Execute this command from the root project:
```
./mvnw test
```

### Run the application
Execute this command from the root project:
```
java -jar target/*.jar
```

### Endpoints implemented
#### 1. Open customer account:
*endpoint:*
```
POST - api/v1/accounts
```

*request body:*
```
{
    "customer_id": 1,
    "initial_credit": 200
}
```

#### 2. Fetch customer information
*endpoint:*
```
GET - api/v1/customers/{customerId}
```
*path parameter:*
```
customerId = Id of the customer
```

### Frontend
**Show all customers:** http://localhost:8080/web/v1/customers/

**Show customer accounts:** http://localhost:8080/web/v1/customers/1

**Show account transactions:** http://localhost:8080/web/v1/customers/1/accounts/1


### Postman
A postman collection has been added to the root project. It can be imported and used in Postman to test the application:

```customer_account_API.postman_collection.json```


### Swagger Docs
```
http://localhost:8080/swagger-ui.html#/
```

### Initial Database setup
- SQL script:
```
INSERT INTO customers(name, surname) VALUES
  ('Marco', 'Basilico'),
  ('John', 'Smith'),
  ('Joy', 'Park');
```

- Result
```
-------------------------
| id | name  | surname  |
|-----------------------|
| 1  | Marco | Basilico |
|-----------------------|
| 2  | John  | Smith    |
|-----------------------|
| 3  | Joy   | Park     |
-------------------------
```
