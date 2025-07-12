-- Email : pegazuls@ufersa.edu.br Password: pegstock
-- INSERT INTO tb_user (name, email, password) VALUES
--     ('PegAzuls', 'pegazuls@ufersa.edu.br', '$2a$10$Qut7kGdi9ZP6N6zpmekT9OcfnPEhJJIC1On1oUOhU8ClHdEMKgWyu');

CREATE TABLE tb_user (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
