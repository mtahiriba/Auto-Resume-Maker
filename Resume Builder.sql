Create database ResumeBuilder;
use ResumeBuilder;

Create table Registration (
	FirstName varchar(30) Not null,
	LastName Varchar(30) Not null,
	Email varchar(30) Not null,
    Password varchar(30) Not Null,
    Phone varchar(30),
    primary key (Email)
    );
    
    
    Create Table PeresonalInfo (
	FirstName varchar(30) Not null,
    LastName Varchar(30) Not null,
	Profession varchar(30) Not null,
    City varchar(30) Not null,
    State varchar(30) Not null,
    PhoneNumber int Not null,
    Email varchar(30) Not null,
    accountEmail varchar(30) Not null,
    discription varchar(500),
    primary key (Email),
    FOREIGN KEY (accountEmail) REFERENCES Registration (Email)
    );

    
    Create Table Education (
	SchoolName varchar(40),
	SchoolLocation varchar(40),
    Degree varchar(20),
    FieldOfStudy varchar(30),
    StartDate varchar(30),
    EndDate varchar(30),
    Email varchar (30),
    primary key (Email,StartDate),
	FOREIGN KEY (Email) REFERENCES Registration (Email)
    );
    
    Create Table Exprience (
		JobTitle varchar(30),
        Employer varchar(30),
        Location varchar(40),
        StateProvince varchar(30),
		StartDate varchar(30),
		EndDate varchar(30),
        Email varchar(30),
        discription varchar(500),
		primary key (Email,JobTitle),
		FOREIGN KEY (Email) REFERENCES Registration (Email)
        );
        
	    
	Create Table Skills (
		Skills varchar(200),
        Email varchar(30),
		accountEmail varchar(30),
		primary key (Email,Skills),
		FOREIGN KEY (accountEmail) REFERENCES Registration (Email),
		FOREIGN KEY (Email) REFERENCES Personalinfo (Email)
        );
        
                
	Create Table Languages (
		Languages varchar(200),
		Email varchar(30),
		accountEmail varchar(30),
		primary key (Email,Skills),
		FOREIGN KEY (accountEmail) REFERENCES Registration (Email),
		FOREIGN KEY (Email) REFERENCES Personalinfo (Email)
		);

	    
        Alter Table Registration
			ADD unique key (Email);
            
            
		
