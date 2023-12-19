CREATE TABLE IF NOT EXISTS products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  description_product TEXT,
  characteristic_product TEXT,
  price DOUBLE PRECISION,
  category VARCHAR(255),
  seller VARCHAR(255),
  number VARCHAR(255),
  create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);