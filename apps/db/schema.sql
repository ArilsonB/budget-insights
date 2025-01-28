-- Create tables
CREATE TABLE preferences (
    key VARCHAR(50) PRIMARY KEY,
    value VARCHAR(50) NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP,
    currency_preference VARCHAR(3) NOT NULL
);

CREATE TABLE accounts (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    account_type VARCHAR(50) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    user_id INTEGER REFERENCES users(id),
    currency VARCHAR(3) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category_type VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    account_id INTEGER REFERENCES accounts(id),
    description TEXT,
    transaction_type VARCHAR(50) NOT NULL,
    category_id INTEGER REFERENCES categories(id),
    amount DECIMAL(15, 2) NOT NULL,
    payment_method VARCHAR(50),
    is_recurring BOOLEAN NOT NULL,
    installments INTEGER NOT NULL,
    recurring_interval VARCHAR(50),
    transaction_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    deleted_at TIMESTAMP
);

CREATE TABLE budgets (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    category_id INTEGER REFERENCES categories(id),
    amount DECIMAL(15, 2) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    frequency VARCHAR(50) NOT NULL
);

CREATE TABLE goals (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    goal_name VARCHAR(255) NOT NULL,
    target_amount DECIMAL(15, 2) NOT NULL,
    current_amount DECIMAL(15, 2) NOT NULL,
    deadline TIMESTAMP NOT NULL,
    priority VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE reminders (
    reminder_id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    description TEXT NOT NULL,
    reminder_date TIMESTAMP NOT NULL,
    repeat VARCHAR(50) NOT NULL
);

-- Insert data
INSERT INTO preferences (key, value) VALUES
    ('currency', 'BRL'),
    ('language', 'en'),
    ('date_format', 'dd/MM/yyyy');

INSERT INTO users (id, name, email, password, created_at, updated_at, deleted_at, currency_preference) VALUES
    (1, 'John', '7tQ9f@example.com', 'password', '2020-01-01T00:00:00Z', '2020-01-01T00:00:00Z', NULL, 'BRL');

INSERT INTO accounts (id, name, description, account_type, balance, user_id, currency, created_at, updated_at, deleted_at) VALUES
    (1, 'Checking', 'Checking account', 'checking', 100, 1, 'BRL', '2020-01-01T00:00:00Z', '2020-01-01T00:00:00Z', NULL);

INSERT INTO categories (id, name, category_type, description, created_at, updated_at, deleted_at) VALUES
    (1, 'test', 'expense', 'test', '2020-01-01T00:00:00Z', '2020-01-01T00:00:00Z', NULL);

INSERT INTO transactions (id, account_id, description, transaction_type, category_id, amount, payment_method, is_recurring, installments, recurring_interval, transaction_at, created_at, updated_at, deleted_at) VALUES
    (1, 1, 'test', 'credit', 1, 1000, NULL, false, 0, NULL, '2020-01-01T00:00:00Z', '2020-01-01T00:00:00Z', '2020-01-01T00:00:00Z', NULL);

INSERT INTO budgets (id, user_id, category_id, amount, start_date, end_date, frequency) VALUES
    (1, 1, 1, 500.00, '2023-01-01T00:00:00Z', '2023-01-31T23:59:59Z', 'monthly');

INSERT INTO goals (id, user_id, goal_name, target_amount, current_amount, deadline, priority, created_at) VALUES
    (1, 1, 'Viagem para Europa', 10000.00, 1500.00, '2024-06-01T00:00:00Z', 'high', '2023-01-10T12:00:00Z');

INSERT INTO reminders (reminder_id, user_id, description, reminder_date, repeat) VALUES
    (1, 1, 'Pagar fatura do cartão', '2023-01-15T10:00:00Z', 'monthly');