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
    LoginTime timestamp DEFAULT CURRENT_TIMESTAMP,
    LogoutTime timestamp DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT AccessID_PK PRIMARY KEY (AccessID),
    CONSTRAINT UserID_FK FOREIGN KEY (UserID) REFERENCES IoTUser(UserID)
);
