Welcome to the JWT Authentication Project

What is JWT?

JWT stands for JSON Web Token. It's a method used to securely pass information (claims) between two parties. JWTs are like private keys, so be careful not to share them carelessly!

How to Set Up This Project:

-> Clone this project.

-> Checkout to the main branch.

-> Build the project.

-> Run the Spring Boot application.

Note: Access the APIs through Swagger at this link: http://localhost:8082/swagger-ui/index.html

Objective of This Project:

The main goal is to understand the complete flow of how JWT works from start to finish.

Technical Analysis Documentation (TAD)

How Does the Flow Work?

We’ve created a login API in the controller where you pass the username as a parameter. From the controller, we call the generateToken method, which creates a JWT for us.

Here’s how it works:

The generateToken method uses the JWT library to build the token.

First, it sets the subject (a unique identifier, usually the username).

Then it adds the issue date and expiration date for the token.

The token is signed using the HS256 algorithm with a 256-bit secret key (this is required for this algorithm, as you can’t use a smaller key).

After that, the JWT token is generated, and you can use this token to access protected APIs.

Here’s the process for securing the APIs:

Authorize: You need to provide the JWT token when calling the APIs.

Validate: The validateToken method checks if the token is real and valid.

It parses the token using the parserBuilder.

The signing key is set to verify the token’s authenticity.

Finally, the token is parsed and decoded to extract the subject (the user).

If the token is valid, the user is granted access to the resources for the time period specified in the token.