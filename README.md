# Employee Reimbursement Ticket System (ERTS)

## Project Description

ERTS is a RESTful (REST is REpresentational State Transfer) Application Program Interface (API) that facilitates company management Employee Reimbursement Tickets (ERTs), or requests for reembursement. This API also observes Level 2 of the Richardson API Maturity Model because it has Multiple URIs (Universal Resource Identifiers, strings of characters user to identify resources on computer networks) and verbs of HTTP (Hypertext Transfer Protocol, a set of rules for transferring files over the Internet) verbs (these are commands that are sent by one Internet resource to tell another Internet resource what to do).

UserRole-s, ReimbursementType-s, and Status-es of reimbursements are enumerated (a sort of "custom" datatype) during processing, but these, along with each User and each Reimbursement is given its own UUID (Universal Unique IDentifier) so that each record and designation can be uniquely identified.

The project is accomplished by having users with one of three roles that access ERTS:
- EMPLOYEE (UUID: 17083287-4167-4edb-abc0-ca8dec1c9152): An EMPLOYEE can create ERTs, after which this EMPLOYEE can see and manage their own PENDING ERTs.


- MANAGER (UUID: 240eebc4-1bcb-49be-b816-96c8d19f76fd): A Finance Manager, known just as a MANAGER in the system, can access all ERTs and details on them and change their enumerated Status from PENDING (UUID: 5d3d4eec-06cb-4979-a9fc-5d00300f422b) to either APPROVED (UUID: 9be2a384-a18f-47a9-a190-9b4482e9f5b5) or DENIED (UUID: 1889b06d-9aea-42bd-9d8a-d29993e4ff16). However, they cannot alter details on the ERTs. A MANAGER can also filter ERTs by Status, usually the PENDING Status.


- ADMIN (UUID: 3a89e958-6504-4cb6-ac83-14c0af1b732e): An Administrator, or ADMIN, can access all EMPLOYEEs and help them manage their own user accounts by changing their user details. This enables the ADMIN to toggle access users as well as change each user's UserRole-s.
  - An ADMIN cannot actually delete users from the ERTS database, but rather they disable access to the accounts to everyone but themself and other ADMINs. This is necessary to allow a user's information to continue being associated with an ERT that was previously created.

##### System Use Case Diagrams
![System Use Case Diagrams](https://raw.githubusercontent.com/221114-Java-React/Raymond-Arias-P1-new/main/images/ERTSUseCaseDiagram.png)


### Project Design Specifications and Documents

The ERTS database conforms to the 3NF (3rd Normal Form) because the data contained is:
* 1NF atomic, has unique identifiers (UUIDs),
* 2NF no partial dependencies (no composite Keys)--all values have to be identified by a single column,
* 3NF and columns are not dependent on anything but Primary Keys (no transitive dependencies).

##### Relational Data Model
![Relational Model](https://raw.githubusercontent.com/221114-Java-React/Raymond-Arias-P1-new/main/images/ERTSRelationalModelDrawio.png)


![Diagram from DBeaver](https://raw.githubusercontent.com/221114-Java-React/Raymond-Arias-P1-new/main/images/DBeaver-postgres-erts_schema.png)


##### Reimbursment System Flow
![Reimbursment Status State Flow](https://raw.githubusercontent.com/221114-Java-React/Raymond-Arias-P1-new/main/images/ERTSStateFlowDiagram.png)

##### DEFAULT Endpoints

- http://localhost:8080/erts/users (POST/GET)
- http://localhost:8080/erts/users/update (PUT/GET)
- http://localhost:8080/erts/reimbursements (POST/GET)
- http://localhost:8080/erts/reimbursements/update (PUT/GET)
- http://localhost:8080/erts/auth (POST)

### Technologies

**Persistence Tier**
- PostGreSQL (running on Docker)

**Application Tier**
- **Java 8** - Main Programming Language
- **Apache Maven** - Dependency Manager
- **JDBC** - Database Connectivity API
- **Javalin** - Web Framework
- **JSON Web Tokens** - HTTP Payload Encryption
- **MessageDigest (SHA-256)** - Password Encryption
- **JUnit** - Java Unit Testing Framework
- **Mockito** - Java Class Mocking Framework
- **DBeaver** - SQL Editor and Database Manager
- **Postman** - Facilitates Communication of Commands and Data Using HTTP

**Process Flow**
- **HTTP Request** (Postman) &harr; **JDBC** &harr; **Javalin** &harr; **API** &harr; **PostgreSQL Database**

![Process Flow](https://raw.githubusercontent.com/221114-Java-React/Raymond-Arias-P1-new/main/images/Web_App_Flow-02-01-1024x385.png)


### Required Resources
- A 'resources' directory is created in the 'main' directory with a db.properties file. This holds properties (URL, username, and password) used to access the ERTS PostGreSQL database. 
- In addition to these, we also need a salt string property to enable the jwt (JSON Web Token, JSON is JavaScript Object Notation) to sign authorization tokens with a custom 'salt'.

### Instructions
- First create the PostGreSQL database and configure the database to the Relational Data Model shown above.
  - Everything in one script. 
  - Example password is passw0rd.
- After starting the database, configure the db.properties file described in Required Resources. The URL and Port must be the same as the created database's URL and Port. 
- At this point you may configure the main driver's 'port' value in the MainDriver.java in order to specify the port you would like you make requests to.
- Generate HTTP requests to the paths specified in the Router.java class under the util directory.
- Certain HTTP requests will require formatting. For example: POST to the /reimbursements endpoint will require an 'authorization' token in the header, as well as a body request.


### Example Request Formats:
- Add User POST http://localhost:8080/erts/users

```
{"username":"userzero",
"email":"user0@zero.net",
"givenName":"User",
"surname":"Zero",
"password1":"abcD?1234!",
"password2":"abcD?1234!"}
```

- Get All Tickets GET /reimbursementSystem/reimbursements
  - Place 'authorization' token in header
- Authenthicaton Request POST http://localhost:8080/erts/auth

```
{
    "username": "userzero",
    "password": "abcD?1234!"
}
```

### Thanks to Elias for providing a template for this presentation.

---

### Functional Requirements

- [ ] A new employee or new finance manager can request registration with the system
- [ ] An admin user can approve or deny new registration requests
- [ ] The system will register the user's information for payment processing
- [ ] A registered employee can authenticate with the system by providing valid credentials
- [ ] An authenticated employee can view and manage their pending reimbursement requests
- [ ] An authenticated employee can view their reimbursement request history (sortable and filterable)
- [ ] An authenticated employee can submit a new reimbursement request
- [ ] An authenticated finance manager can view a list of all pending reimbursement requests
- [ ] An authenticated finance manager can view a history of requests that they have approved/denied
- [ ] An authenticated finance manager can approve/deny reimbursement requests
- [ ] An admin user can deactivate user accounts, making them unable to log into the system
- [ ] An admin user can reset a registered user's password

### Non-Functional Requirements

- [ ] Basic validation is enforced to ensure that invalid/improper data is not persisted
- [ ] User passwords will be encrypted by the system before persisting them to the data source
- [ ] Users are unable to recall reimbursement requests once they have been processed (only pending allowed)
- [ ] Sensitive endpoints are protected from unauthenticated and unauthorized requesters using JWTs
- [ ] Errors and exceptions are handled properly and their details are obfuscated from the user
- [ ] The system conforms to RESTful architecture constraints
- [ ] The system's is tested with at least 80% line coverage in all service and utility classes
- [ ] The system keeps detailed logs on info, error, and fatal events that occur

