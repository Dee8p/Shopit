INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('aryan@aryan.com', '$2a$10$5TzIcm6VydfjgGZINh8vGOK0ekO/XP64YO2oHIqlX9S3q0ylLAci2', 1);
-- 1234

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('guest@guest.com', '$2a$10$5TzIcm6VydfjgGZINh8vGOK0ekO/XP64YO2oHIqlX9S3q0ylLAci2', 1);
--123 

INSERT INTO sec_user (email, encryptedPassword, enabled)
VALUES ('deep@deep.com', '$2a$10$5TzIcm6VydfjgGZINh8vGOK0ekO/XP64YO2oHIqlX9S3q0ylLAci2', 1);
--123

-- for the roles table
INSERT INTO sec_role (roleName)
VALUES ('ADMIN');

INSERT INTO sec_role (roleName)
VALUES ('USER');

INSERT INTO sec_role (roleName)
VALUES ('GUEST');





INSERT INTO user_role (userId, roleId)
VALUES (1, 1);

INSERT INTO user_role (userId, roleId)
VALUES (2, 3);

INSERT INTO user_role (userId, roleId)
VALUES (3, 2);

-- for the sjhop

INSERT INTO product (name, description, price, stock, images) VALUES
('Laptop', 'A high-performance laptop', 999.99, 50, 'https://imgs.search.brave.com/s7h4GwPFE3nOh8I-uZHXR22kIbzwafCF_Bye8A6B0io/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/aXN0b2NrcGhvdG8u/Y29tL3Jlc291cmNl/cy9pbWFnZXMvUGhv/dG9GVExQL0xpZmVz/dHlsZS0xMDMzNDU3/MjUwLmpwZw'),
('Smartphone', 'Latest model smartphone', 499.99, 150, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Headphones', 'Noise-cancelling headphones', 199.99, 75, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Tablet', 'Lightweight tablet with high-resolution screen', 299.99, 120, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Smartwatch', 'Wearable smart technology', 129.99, 200, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Leather Jacket', 'Stylish black leather jacket', 149.99, 30, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Cotton T-shirt', 'Comfortable cotton T-shirt', 19.99, 100, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Sneakers', 'Comfortable running sneakers', 59.99, 80, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Denim Jeans', 'Classic fit denim jeans', 39.99, 70, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Wristwatch', 'Elegant wristwatch', 89.99, 40, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Backpack', 'Durable travel backpack', 49.99, 60, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Sunglasses', 'Stylish UV protection sunglasses', 29.99, 90, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Tote Bag', 'Eco-friendly tote bag', 15.99, 110, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0'),
('Scarf', 'Warm and stylish scarf', 25.99, 65, 'https://imgs.search.brave.com/p3EuDGCoEomIF1qfXco8ZkK1Tmy5-zBOdwYUgAZgX9k/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tZWRp/YS5nZXR0eWltYWdl/cy5jb20vaWQvMTg1/MjIzNzEwL3Bob3Rv/L2xhcHRvcC1mbG9h/dGluZy1hbmdsZWQt/b3Blbi5qcGc_cz02/MTJ4NjEyJnc9MCZr/PTIwJmM9Z1VpZkph/cDRkRmtHeW5MQkFz/Q0NCdFR4eWpNNTEx/eTAtODVGLW50R092/VT0');


