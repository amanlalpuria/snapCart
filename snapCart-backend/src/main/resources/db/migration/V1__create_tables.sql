CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,                         -- Auto-generated ID, with SERIAL for auto-increment
    full_name VARCHAR(255) NOT NULL,                     -- Full name of the user
    email VARCHAR(100) NOT NULL UNIQUE,                  -- Email field with unique constraint
    mobile_number VARCHAR(10) NOT NULL UNIQUE,           -- Mobile number with unique constraint
    password VARCHAR(255) NOT NULL,                      -- Password field
    user_type VARCHAR(255) NOT NULL,                     -- Enum will be stored as a string, but you can adapt it for your DB
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, -- Created at field with timestamp
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP      -- Updated at field with timestamp
);
