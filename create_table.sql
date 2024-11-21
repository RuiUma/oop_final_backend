
CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    UserType ENUM('Professional', 'Institution') NOT NULL,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    CurrentPosition VARCHAR(255),
    Institution VARCHAR(255)
);

CREATE TABLE Institutions (
    InstitutionID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) UNIQUE NOT NULL,
    Address TEXT,
    CoursesOffered TEXT
);

CREATE TABLE Courses (
    CourseID INT AUTO_INCREMENT PRIMARY KEY,
    InstitutionID INT NOT NULL,
    Title VARCHAR(255) NOT NULL,
    Code VARCHAR(50) NOT NULL,
    Term VARCHAR(50) NOT NULL,
    Schedule VARCHAR(50) NOT NULL,
    DeliveryMethod ENUM('In-Person', 'Remote', 'Hybrid') NOT NULL,
    Outline TEXT,
    PreferredQualifications TEXT,
    Compensation DECIMAL(10, 2),
    FOREIGN KEY (InstitutionID) REFERENCES Institutions(InstitutionID)
        ON DELETE CASCADE
);

CREATE TABLE Applications (
    ApplicationID INT AUTO_INCREMENT PRIMARY KEY,
    CourseID INT NOT NULL,
    ProfessionalID INT NOT NULL,
    Status ENUM('Pending', 'Accepted', 'Rejected') DEFAULT 'Pending',
    SubmissionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
        ON DELETE CASCADE,
    FOREIGN KEY (ProfessionalID) REFERENCES Users(UserID)
        ON DELETE CASCADE
);

CREATE TABLE Notifications (
    NotificationID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    Message TEXT NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ReadStatus BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
        ON DELETE CASCADE
);

