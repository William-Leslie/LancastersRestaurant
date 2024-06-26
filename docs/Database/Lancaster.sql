-- Create the Ingredient table
CREATE TABLE Ingredient (
    IngredientID INTEGER PRIMARY KEY,
    IngredientName CHAR,
    Quantity INTEGER,
    StockLevel INTEGER,
    LowStockThreshold INTEGER,
    Price DECIMAL(6,2),
    AllergenID INTEGER,
    FOREIGN KEY (AllergenID) REFERENCES Allergen (AllergenID)
);

CREATE TABLE Orders
(
    OrderID integer primary key,
    OrderedDate date,
    ArrivalDate date
    );

CREATE TABLE Wine
(
    WineID integer primary key,
    WineName char(25),
    WineYear char(25),
    Price decimal(6,2),
    StockLevel integer
    );
    
CREATE TABLE Dish
(
    DishID integer primary key,
    DishName char(25),
    Price decimal(6,2),
    Description char(255)
    );

Create TABLE Booking
(
   	BookingID integer primary key,
    BookingName char(25),
    Contact varchar(40),
    Type char(25),
    noOfCovers integer(10)    
);

CREATE TABLE BookingCapacity
(
    CapacityDay DATE PRIMARY KEY,
    HalfHourLimit INTEGER(10),
    PreBookLimit INTEGER(10),
    MaxDiningLimit INTEGER(10),
    PriceMultiplier INTEGER(10)
);

Create TABLE Staff
(
   	StaffID integer primary key,
    StaffName char(25),
    Address varchar(25),
    DateOfBirth date,
    Role char(10)
    );
    
    
Create TABLE Sale
(
   	SaleID integer primary key,
    NHSDiscount char(1),
    ArmyDiscount char(1),
    OptionalCharge integer(10),
    Total integer(10),
    PaymentMethod char(25)
    );
    
Create TABLE Menu
(
   	MenuID integer primary key,
    MenuDate date
    );
    
Create TABLE Course
(
   	CourseID integer primary key,
    ExpiryStatus char(25)
    );
    
CREATE TABLE Ingredient_Dish
(
    IngredientID integer,
    DishID integer,
    Quantity integer,
    FOREIGN KEY (IngredientID) REFERENCES Ingredient(IngredientID),
    FOREIGN KEY (DishID) REFERENCES Dish(DishID)
);
    
-- Create the Ingredient_Order table
CREATE TABLE Ingredient_Order (
    IngredientID INTEGER,
    OrderID INTEGER,
    Quantity INTEGER,
    FOREIGN KEY (IngredientID) REFERENCES Ingredient(IngredientID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
);

    
Create TABLE Dish_Wine
(
    DishID integer,
    WineID integer,
   	FOREIGN KEY (DishID) REFERENCES Dish(DishID),
    FOREIGN KEY (WineID) REFERENCES Wine(WineID)
    );

Create TABLE Dish_Course
(
    DishID integer,
    CourseID integer,
   	FOREIGN KEY (DishID) REFERENCES Dish(DishID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
    );
    
Create TABLE Course_Menu
(
    CourseID integer,
    MenuID integer,
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID),
    FOREIGN KEY (MenuID) REFERENCES Menu(MenuID)
    );
    
 
CREATE TABLE Allergen
(
    AllergenID INTEGER PRIMARY KEY,
    AllergenName CHAR(25),
    DishID INTEGER,
    FOREIGN KEY (DishID) REFERENCES Dish (DishID)
);

    
Create TABLE Supplier
(
    supplierID integer primary key ,
    contactInfo char(25),
    supplierName char(25)
    );
    
    
Create TABLE Product
(
    productID integer primary key ,
    productDesc char(25),
    productName char(25),
    supplierID integer,
    availabilityStatus tinyint(1),
    FOREIGN KEY (supplierID) REFERENCES Supplier (supplierID)
    );
    
    
-- Create the AuthUser table
CREATE TABLE AuthUser (
    UserID INTEGER PRIMARY KEY,
    Username CHAR(25) UNIQUE,
    Password CHAR(25),
    Role CHAR(10)
);


-- Create the Holiday table
CREATE TABLE Holiday (
    HolidayID INTEGER PRIMARY KEY,
    FromDate DATE,
    ToDate DATE
);
(Dummy Data)

    -- Insert data into Ingredient
INSERT INTO Ingredient (IngredientID, IngredientName, Quantity, StockLevel, LowStockThreshold, Price, AllergenID)
VALUES 
    (1, 'Chicken Breast', 50, 50, 10, 7.99, NULL),
    (2, 'Beef Steak', 30, 30, 8, 12.99, NULL),
    (3, 'Salmon Fillet', 40, 40, 12, 14.99, NULL),
    (4, 'Shrimp', 60, 60, 15, 18.99, 5),
    (5, 'Pasta', 100, 100, 20, 2.49, 1),
    (6, 'Rice', 80, 80, 18, 1.99, 1),
    (7, 'Potatoes', 70, 70, 15, 0.99, NULL),
    (8, 'Tomatoes', 90, 90, 25, 1.49, NULL),
    (9, 'Lettuce', 120, 120, 30, 0.79, NULL),
    (10, 'Cheese', 40, 40, 10, 6.49, 3);
    
INSERT INTO Wine (WineID, WineName, WineYear, Price, StockLevel)
VALUES 
    (1, 'Chardonnay', '2019', 25.99, 50),
    (2, 'Merlot', '2018', 19.99, 40),
    (3, 'Cabernet Sauvignon', '2017', 29.99, 30),
    (4, 'Pinot Noir', '2018', 32.99, 35),
    (5, 'Sauvignon Blanc', '2020', 21.99, 60),
    (6, 'Syrah', '2016', 27.99, 25),
    (7, 'Zinfandel', '2019', 23.99, 45),
    (8, 'Riesling', '2020', 18.99, 55),
    (9, 'Malbec', '2018', 26.99, 20),
    (10, 'Grenache', '2017', 22.99, 40);
    
INSERT INTO Dish (DishID, DishName, Price, Description)
VALUES 
    (1, 'Spaghetti Carbonara', 13.99, 'Classic Italian pasta dish with creamy sauce, bacon, and Parmesan cheese.'),
    (2, 'Grilled Salmon', 18.99, 'Fresh salmon fillet grilled to perfection, served with roasted vegetables and lemon butter sauce.'),
    (3, 'Beef Burger', 9.99, 'Juicy beef patty topped with cheese, lettuce, tomato, and pickles, served on a toasted bun with fries.'),
    (4, 'Vegetable Stir-Fry', 11.99, 'Assorted vegetables stir-fried with tofu in a savory sauce, served with steamed rice.'),
    (5, 'Chicken Caesar Salad', 14.99, 'Crisp romaine lettuce tossed with grilled chicken, Parmesan cheese, croutons, and Caesar dressing.'),
    (6, 'Margherita Pizza', 10.99, 'Classic Italian pizza topped with tomato sauce, mozzarella cheese, and fresh basil leaves.'),
    (7, 'Pad Thai Noodles', 13.99, 'Thai-style stir-fried rice noodles with shrimp, tofu, bean sprouts, peanuts, and tamarind sauce.'),
    (8, 'Beef Tacos', 11.99, 'Soft corn tortillas filled with seasoned ground beef, lettuce, cheese, salsa, and sour cream, served with rice and beans.'),
    (9, 'Mushroom Risotto', 15.99, 'Creamy Arborio rice cooked with mushrooms, onions, garlic, white wine, and Parmesan cheese.'),
    (10, 'BBQ Chicken Wings', 8.99, 'Crispy chicken wings smothered in tangy barbecue sauce, served with celery sticks and ranch dressing.');

INSERT INTO Booking (BookingID, BookingName, Contact, Type, NoOfCovers)
VALUES 
    (1, 'John Smith', '+44 7854 123456', 'Dinner', 4),
    (2, 'Jane Doe', 'JaneDoe02@gmail.com', 'Lunch', 2),
    (3, 'Michael Johnson', '+44 7766 234567', 'Dinner', 6),
    (4, 'Emily Brown', '+44 7890 876543', 'Dinner', 3),
    (5, 'Chris Wilson', 'ChrisWilson123@gmail.com', 'Lunch', 5);
    
INSERT INTO BookingCapacity (BookingCapacityID, CapacityDay, HalfHourLimit, PreBookLimit, MaxDiningLimit, PriceMultiplier)
VALUES 
    (1, '02/07/24', 20, 50, 100, 2),
    (2, '03/07/24', 25, 60, 120, 2),
    (3, '04/07/24', 30, 70, 150, 2),
    (4, '05/07/24', 20, 50, 100, 2),
    (5, '06/07/24', 25, 60, 120, 2),
    (6, '07/07/24', 22, 55, 110, 2),
    (7, '08/07/24', 28, 65, 130, 2),
    (8, '09/07/24', 32, 75, 160, 2),
    (9, '10/07/24', 26, 62, 125, 2),
    (10, '11/07/24', 24, 58, 115, 2);

INSERT INTO Staff (StaffID, StaffName, Address, DateOfBirth, Role)
VALUES 
    (1, 'John Smith', '123 Main St', '1990-05-15', 'FOH'),
    (2, 'Jane Doe', '456 Oak Ave', '1988-10-20', 'FOH'),
    (3, 'Michael Johnson', '789 Elm St', '1995-03-08', 'Kitchen'),
    (4, 'Emily Brown', '321 Pine St', '1992-07-12', 'Kitchen'),
    (5, 'Chris Wilson', '567 Maple Ave', '1998-12-30', 'Management');
    
INSERT INTO Sale (SaleID, NHSDiscount, ArmyDiscount, OptionalCharge, Total, PaymentMethod)
VALUES 
    (1, 'Y', 'N', 0, 50, 'Credit Card'),
    (2, 'N', 'Y', 5, 45, 'Cash'),
    (3, 'N', 'N', 0, 30, 'Debit Card'),
    (4, 'Y', 'Y', 10, 80, 'Cash'),
    (5, 'Y', 'N', 0, 60, 'Credit Card');

INSERT INTO Course (CourseID, ExpiryStatus)
VALUES 
    (1, 'Active'),
    (2, 'Expired'),
    (3, 'Active'),
    (4, 'Active'),
    (5, 'Expired');
    
INSERT INTO Menu (MenuID, MenuDate)
VALUES 
    (1, '2024/04/12'),
    (2, '2024/05/13'),
    (3, '2024/06/24'),
    (4, '2024/07/13'),
    (5, '2024/08/10');
    
INSERT INTO Allergen (AllergenID, AllergenName, AllergenDesc, DishID) VALUES 
(1, 'Gluten', 'Contains gluten', NULL),
(2, 'Moluscs', 'Contains moluscs', NULL),
(3, 'Milk', 'Contains milk', NULL),
(4, 'Peanuts', 'Contains peanuts', NULL),
(5, 'Crustaceans', 'Contains crustaceans', NULL),
(6, 'Sesame', 'Contains sesame', NULL);
    
INSERT INTO Supplier (supplierID, contactInfo, supplierName)
VALUES 
    (1, '+44 7456 123456', 'Fresh Produce Inc.'),
    (2, '+44 7598 654321', 'Meat Master Ltd.'),
    (3, 'fresh@produce.co.uk', 'Dairy Delights Co.'),
    (4, 'bakery@master.co.uk', 'Bakery Best'),
    (5, '+44 7987 987654', 'Seafood Supreme');

INSERT INTO Product (productID, productDesc, productName, supplierID, availabilityStatus)
VALUES 
    (1, 'Fresh apples', 'Apples', 1, 1),
    (2, 'Premium beef steak', 'Beef Steak', 2, 1),
    (3, 'Organic milk', 'Milk', 3, 1),
    (4, 'Artisan bread loaf', 'Bread', 4, 1),
    (5, 'Wild-caught salmon fillet', 'Salmon Fillet', 5, 1);

-- Insert data into Ingredient_Order
INSERT INTO Ingredient_Order (IngredientID, OrderID, Quantity)
VALUES 
   (1, 1, 10),
   (2, 1, 10),
   (3, 1, 10),
   (4, 2, 10),
   (5, 2, 10),
   (6, 3, 10),
   (7, 3, 10),
   (8, 3, 10),
   (9, 4, 10),
   (10, 4, 10),
   (5, 5, 10),
   (6, 5, 10),
   (10, 5, 10),
   (2, 7, 10),
   (6, 7, 10),
   (10, 8, 10),
   (2, 8, 10),
   (6, 9, 10),
   (1, 9, 10),
   (1, 10, 10),
   (6, 10, 10),
   (1, 10, 10),
   (1, 10, 10);

INSERT INTO Ingredient_Dish (IngredientID, DishID)
VALUES 
    (5, 1),
    (1, 1),
    (10, 1),
    (6, 2),
    (2, 2),
    (8, 2),
    (3, 3),
    (7, 3),
    (9, 3);

INSERT INTO Ingredient_Order (IngredientID, OrderID)
VALUES 
    (1, 1),
    (2, 1),
    (3, 1),
    (4, 2),
    (5, 2),
    (6, 3),
    (7, 3),
    (8, 3),
    (9, 4),
    (10, 4),
    (5, 5),
    (6, 5),
    (10, 5),
    (2, 5);
    
INSERT INTO Dish_Wine (DishID, WineID)
VALUES 
    (1, 1),  
	(2, 2),
    (3, 3),  
    (4, 4),  
    (5, 5);  

INSERT INTO Dish_Course (DishID, CourseID)
VALUES 
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 1),
    (6, 2),
    (7, 3),
    (7, 4),
    (8, 5),
    (9, 1),
    (9, 2),
    (10, 3),
    (10, 4);

INSERT INTO Course_Menu (CourseID, MenuID)
VALUES 
    (1, 1),  
    (2, 1),  
    (3, 1),  
    (4, 1),  
    (5, 1),  
    (1, 2),  
    (2, 2),  
    (3, 2),  
    (4, 2),  
    (5, 2),  
    (1, 3),  
    (2, 3),  
    (3, 3),  
    (4, 3),  
    (5, 3),  
    (1, 4),  
    (2, 4),  
    (3, 4),  
    (4, 4),  
    (5, 4),  
    (1, 5),  
    (2, 5),  
    (3, 5),  
    (4, 5),  
    (5, 5);
    
    
   -- Insert data into AuthUser
INSERT INTO AuthUser (Username, Password, Role) VALUES 
('lancaster', 'lancaster', 'admin'),
('staff', 'staff', 'user'); 


-- Insert data into Holiday
INSERT INTO Holiday (FromDate, ToDate) VALUES 
('2024-04-11', '2024-04-30'),
('2024-04-14', '2024-04-14'),
('2024-04-16', '2024-04-24'),
('2024-04-18', '2024-04-25'),
('2024-04-23', '2024-04-25'),
('2024-04-17', '2024-04-17'),
('2024-04-17', '2024-04-17'),
('2024-04-17', '2024-04-26'),
('2024-04-19', '2024-04-25'),
('2024-04-17', '2024-04-26');
