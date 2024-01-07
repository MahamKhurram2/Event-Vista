use eventvista
CREATE TABLE attendee (
    attendee_id INT AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(15)
);

CREATE TABLE eventorganizer (
    organizer_id INT AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255),
    email VARCHAR(255),
    phone_number VARCHAR(15)
);



CREATE TABLE feedback (
    feedback_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(255),
    rating VARCHAR(255),
    comments TEXT,
    suggestions TEXT
);
CREATE TABLE ticket_purchase (
    purchase_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(255) NOT NULL,
    attendee_name VARCHAR(255) NOT NULL,
    contact VARCHAR(20) NOT NULL,
    email VARCHAR(255) NOT NULL,
    ticket_type VARCHAR(50) NOT NULL,
    
    total_cost DOUBLE NOT NULL,
      quantity INT
);



CREATE TABLE events (
    event_name VARCHAR(255) PRIMARY KEY,
    date VARCHAR(255),
    location VARCHAR(255),
    description TEXT
);
SELECT * FROM events;
-- Create the tickets table
CREATE TABLE tickets (
    ticket_id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(255),
    ticket_type VARCHAR(255),
    price DOUBLE,
    quantity INT,
    FOREIGN KEY (event_name) REFERENCES events(event_name)
);
SELECT * FROM tickets;


   
   CREATE TABLE EventTheme (
    id INT AUTO_INCREMENT PRIMARY KEY,
    theme VARCHAR(255) NOT NULL,
    color_scheme VARCHAR(255) NOT NULL,
    music VARCHAR(255) NOT NULL,
    description TEXT
);
CREATE TABLE Venue (
    id INT PRIMARY KEY AUTO_INCREMENT,
    venue_name VARCHAR(255) NOT NULL,
    selected_date VARCHAR(255) NOT NULL,
    selected_time VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);
CREATE TABLE event_updates (
    update_id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(255),
    update_message TEXT,
    target_audience VARCHAR(255)
);
SELECT * FROM eventorganizer;