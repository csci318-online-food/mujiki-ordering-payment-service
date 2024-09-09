CREATE TABLE IF NOT EXISTS payments (
  id UUID PRIMARY KEY,
  user_id UUID,
  bank_name VARCHAR(255),
  card_number VARCHAR(255),
  balance DOUBLE PRECISION
);