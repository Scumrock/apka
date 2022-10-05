-- Add PL/pgSQL extension
CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';

-- Create roles
CREATE USER apka WITH ENCRYPTED PASSWORD 'apka';

-- Create databases
CREATE DATABASE apka OWNER apka;
