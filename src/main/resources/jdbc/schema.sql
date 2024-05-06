CREATE TABLE IF NOT EXISTS customer (
                          id INT PRIMARY KEY auto_increment,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          birth_date DATE,
                          nationality VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS room (
                      id INT PRIMARY KEY auto_increment,
                      number VARCHAR(50),
                      max_people INT,
                      price_per_person DECIMAL(10, 2)
);

CREATE TABLE IF NOT EXISTS reservation (
                             id INT PRIMARY KEY auto_increment,
                             fk_customer INT,
                             fk_room INT,
                             number_of_people INT,
                             check_in DATE,
                             check_out DATE,
                             FOREIGN KEY (fk_customer) REFERENCES CUSTOMER(id),
                             FOREIGN KEY (fk_room) REFERENCES ROOM(id)
);