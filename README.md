# E-Commerce Web Application

## Overview
This project is a web-based E-commerce store that provides a platform for customers to browse and shop for products. The application features a dashboard that allows an admin user to manage products and categories. Customers can filter products by categories, view details, and make purchases.

### Features
- **Admin Dashboard**: Admin users have access to a dashboard where they can manage products and categories, including the ability to create, update, delete, and read product information.
- **Product Browsing**: Customers can browse all available products, view details, and filter them based on various categories.
- **Shopping Functionality**: Customers can add items to their cart and proceed to checkout.

## Technologies Used
- **Java 17**: Backend language.
- **Spring Boot 3.4.0**: Framework for building the REST APIs.
- **Spring Security**: Used to secure endpoints and manage authentication and authorization for admin and customer roles.
- **JPA (Java Persistence API)**: For database operations.
- **MySQL**: Database to store user, product, and order information.
- **JWT (JSON Web Tokens)**: Used for authentication and generating secure tokens.
- **Lombok**: To reduce boilerplate code.

## Installation

### Prerequisites
- Java 17
- Maven
- MySQL

### Setup Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/MohammedSamerr/e-commerce-webapp.git
   cd e-commerce-webapp
   ```
2. Update the database configuration:
   - Modify the `application.properties` file in the `src/main/resources` directory to set your MySQL database connection details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     ```
3. Build the application:
   ```sh
   mvn clean install
   ```
4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Usage
- **Admin User**:
  - Can log in and access the dashboard to manage products and categories.
  - Admin actions include: Create, Update, Delete, and Read products and categories.
- **Customer User**:
  - Can view available products, filter by category, and add items to the shopping cart.
  - Can proceed to checkout and complete the purchase.

## API Endpoints
### Authentication
- `POST /signup` - Register a new user.
- `POST /login` - Login and receive a JWT token.

### Products
- `GET /products` - Get a list of all products (accessible by all users).
- `GET /products/{id}` - Get product details by ID.
- `POST /products` - Add a new product (admin only).
- `PUT /products/{id}` - Update a product (admin only).
- `DELETE /products/{id}` - Delete a product (admin only).

### Categories
- `GET /categories` - Get a list of all categories (accessible by all users).
- `POST /categories` - Add a new category (admin only).
- `PUT /categories/{id}` - Update a category (admin only).
- `DELETE /categories/{id}` - Delete a category (admin only).

## Roles and Permissions
- **Admin**: Has access to all product and category management operations.
- **Customer**: Can view products, filter by category, and make purchases.

## Security
- **JWT Authentication** is used for securing the API endpoints.
- **Spring Security** is used to manage role-based access control.

## Future Enhancements
- Add support for customer reviews and ratings.
- Integrate a payment gateway for real transactions.
- Add order history and tracking for customers.


