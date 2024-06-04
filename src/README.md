Online Shopping System

Overview

A Java programme called the Online Shopping System replicates the online shopping environment. Customers may explore products, add items to a shopping basket, register, log in, and place orders. For user interaction, the application has a graphical user interface (GUI).

Features

- User Registration and Login: To register, users need to provide their email address, name, and password. Users with login credentials can access the system.
- Product Catalog: A product catalog is available for users to peruse.
- Shopping Cart: Customers are able to see, add, and delete items from their shopping cart.
- Order Placement: Customers are able to place orders for the items that are in their shopping basket. Payment processing is simulated by the system.

Prerequisites

- Java Development Kit (JDK) 8 or later
- Apache Maven (for dependency management and building the project)

Project Structure

finalproject/
Catalog.java
Clothingproduct.java
ElectronicProduct
MainClass.java
MainClassGUI.java
Order.java
PaymentProcessor.java
Product.java
ProductLoader.java
ShoppingCart.java
User.java
UserAuthSystem.java
logger/
Logger.java
test/
PaymentProcessorTest.java
ShoppingCartTest.java
Catalogtest.java


Usage

1. Clone the Repository

git clone https://github.com/srinivasbakkashetti/OOPS-final-project.git
cd OOPS-final-project


2. Compile and Run the Application


javac finalproject/*.java
java finalproject.MainClassGUI


3. User Interaction

Register: Click the "Register" button to create a new user account.
Login: Click the "Login" button to log in to the system.
Browse Products: Click the "Browse Products" button to view available products.
Add to Cart: Click the "Add to Cart" button to add products to the shopping cart.
View Cart: Click the "View Cart" button to view the contents of the shopping cart.
Remove from Cart: Click the "Remove from Cart" button to remove products from the shopping cart.
Place Order: Click the "Place Order" button to place an order for the products in the cart.

Running Tests

The project includes unit tests for the payment processor and shopping cart functionality.

1. Compile the Tests

javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar finalproject/test/*.java


2. Run the Tests

java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore finalproject.test.PaymentProcessorTest
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore finalproject.test.ShoppingCartTest
java -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore finalproject.test.CatalogTest



Class Descriptions

Catalog.java
This is the class to hold a catalog of products. It contains methods to add products, to get them by name, and to retrieve all.

CatalogTest.java
This class contains unit test cases for the class Catalog. It tests the addition of the products, retrieval of products by name, and fetching all the products.

ClothingProduct.java
This class implements the Product interface and represents a clothing product with its details.

ElectronicProduct.java
This class implements the Product interface and represents an electronic product with its details.

MainClass.java
This class provides the CLI interface of the application. It interacts with the user by presenting registration, logging in, product browsing, adding products to the cart, viewing cart, and placing orders.

MainClassGUI.java
Main entry point of application: It is a GUI class that creates the GUI elements, interacts with the users, and performs registration, login, product browsing, adding products to cart, viewing cart, and placing orders.

Order.java
The Order class represents an order made by a user. It holds details of the user who has placed the order, the shopping cart, and the current status of the order. It also has methods to place an order and get order details.

PaymentProcessor.java
The main class for simulating processing payments. It has method implementations for processing and validating payment methods.

PaymentProcessorTest.java
A class implementing unit tests for the PaymentProcessor class, with positive and negative scenarios for the validatePayment method.

Product.java
This interface defines product requirements and methods to retrieve product details like name, price, description, and quantity in stock.

ProductLoader.java
This class loads sample products into a catalog and allows for adding and getting all products in the catalog.

ShoppingCart.java
The class represents a shopping cart, which has features to add and remove items and calculate the total amount for items in the cart.

ShoppingCartTest.java
A class for implementing unit tests for the ShoppingCart class, including adding and removing items from the cart and calculating the total amount.

User.java
This class represents a user of the system. It includes user details like username, password, name, email, and methods to get and set this info.

UserAuthSystem.java
A class to implement user registration and login management, with features for user registration, logging in, and username and password validation.
This class is a catalogue of products. It provides methods to add products, get products by name, and fetch all products.


