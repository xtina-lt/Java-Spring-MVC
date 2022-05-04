********* MVC DESIGN PATTERN ********
MODEL
    - PERSISTANCE LAYER (Manage Data)
        - Repository: Interface
        - Model (db)
    - SERVICE LAYER (Business Logic)
        - Service.java
VIEW
    - JSP
    - CSS
    - JS

CONTROLLER
    - routing
**********************************

Books:
    - CRUD 
    - JSP templates and rendering views
    - path variables
    - render data from db
    - JPA quireies
    - lists and objects to JSP
    - forEach loop
    - c:out

SaveTravels:
    - CRUD
    - collect input and add to db
    - data binding
    - @ModelAttribute annotation
    - form:form data binding
    - validations
    - routes and POST rules

Dojos and Ninjas:
	- Implement a one-to-many and one-to-one relationship.
	- Manipulate lists to model one-to-many and one-to-one relationships in the database.
	- Implement a foreign-key relationship by assigning instances of a class as a member variable.

Book Club:
	- Add users to an application with Create and Read capabilities.
	- Implement a one-to-many relationship between User and another model.
	- Identify and implement routes for requests based on a wireframe.
	- Manage a user session (log in status) by storing and reading their ID in session.
	- Apply cumulative skills to build and de-bug a full-stack application.

LogReg:
	- Build an application that requires both user authentication and validations
	- Add server-side validations in addition to model-level validations
	- Implement authentication logic
	- Import and use BCrypt to create hashes and compare hashed strings against the database.
	- Use and manipulate transient member variables and non-entity classes
	- Handle user logout and active session status
	- Use session data to pull the current user's information.

Projects and Categories:
	- Implement a typical many-to-many relationship
	- Become more familiar with JPA methods as applied to n:m relationships.
	- Understand how to establish many-to-many relationships between models.
	- Learn how to create an instance of a many-to-many relationship
    	- Learn how to read an instance with its associated relationship data
