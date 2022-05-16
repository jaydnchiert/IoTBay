/*
 * A SQL File to store all the commands needed to create the database in case anything goes wrong.
 *
*/
CREATE TABLE IoTUser (
    UserID integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    FirstName varchar(15) NOT NULL,
    LastName varchar (15) NOT NULL,
    EmailAddress varchar(50) NOT NULL,
    PhoneNumber varchar(15) NOT NULL,
    Password varchar(32) NOT NULL,
    UserType char(1),

    CONSTRAINT UserID_PK PRIMARY KEY (UserID)
);

CREATE TABLE AccessHistory (
    AccessID integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    UserID integer NOT NULL,
    LoginTime timestamp,
    LogoutTime timestamp,

    CONSTRAINT AccessID_PK PRIMARY KEY (AccessID),
    CONSTRAINT UserID_FK FOREIGN KEY (UserID) REFERENCES IoTUser(UserID)
);

CREATE TABLE CustomerOrder (
    OrderID integer NOT NULL,
    ProductID integer NOT NULL,
    UserID integer NOT NULL,
    ShippingPrice integer NOT NULL,
    TotalPrice integer NOT NULL,
    Date varchar(15) NOT NULL,

    CONSTRAINT OrderID_PK PRIMARY KEY (OrderID)
    CONSTRAINT UserID_FK FOREIGN KEY (UserID) REFERENCES IoTUser(UserID)
    CONSTRAINT ProductID_FK FOREIGN KEY (ProductID)

);
