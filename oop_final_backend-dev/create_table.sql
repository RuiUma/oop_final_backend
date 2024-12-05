

CREATE TABLE Terms (
    TermID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL
);

CREATE TABLE Users (
    UserID INT AUTO_INCREMENT PRIMARY KEY,
    UserType ENUM('Professional', 'Institution') NOT NULL,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL,
    ProfileCreated bool default false,
    -- for Professionals only:
    CurrentPosition VARCHAR(255),
    InstitutionID INT,
    EducationBackground TEXT,
    AreaOfExpertise TEXT,
    -- for Institutions only:
    Address TEXT
);

CREATE TABLE Courses (
    CourseID INT AUTO_INCREMENT PRIMARY KEY,
    InstitutionID INT NOT NULL,
    TermID INT NOT NULL,
    Title VARCHAR(255) NOT NULL,
    Code VARCHAR(50) NOT NULL,
    Schedule ENUM('Morning', 'Afternoon', 'Evening') NOT NULL,
    DeliveryMethod ENUM('In-Person', 'Remote', 'Hybrid') NOT NULL,
    Outline TEXT,
    PreferredQualifications TEXT,
    Compensation DECIMAL(10, 2)
);



CREATE TABLE Applications (
    ApplicationID INT AUTO_INCREMENT PRIMARY KEY,
    CourseID INT NOT NULL,
    -- professional user id
    ProfessionalID INT NOT NULL,
    Status ENUM('Pending', 'Accepted', 'Rejected') DEFAULT 'Pending',
    SubmissionDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ReviewDate TIMESTAMP NULL,
    -- reviewed by userid
    ReviewedBy INT,
    Reason TEXT
);

CREATE TABLE Notifications (
    NotificationID INT AUTO_INCREMENT PRIMARY KEY,
    UserID INT NOT NULL,
    Type ENUM('ApplicationUpdate', 'General', 'System') NOT NULL,
    Message TEXT NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ReadStatus BOOLEAN DEFAULT FALSE,
    ExpiresAt TIMESTAMP NULL
);

CREATE TABLE teaching_requests (
    request_id INT AUTO_INCREMENT PRIMARY KEY,
    course_id INT NOT NULL,
    professional_id INT NOT NULL,
    status ENUM('Pending', 'Accepted', 'Rejected') DEFAULT 'Pending',
    expertise TEXT,
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (professional_id) REFERENCES users(user_id)
);
