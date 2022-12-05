/* Default setup for Employee Reimbursement Ticket System
 * By Ray Arias, 0.9.0 for Project 1 of 221124 Java-React, Revature
 */

-- Delete old schema
drop schema if exists erts_schema cascade;

-- Delete old tables
drop table if exists users cascade;
drop table if exists reimbursements cascade;
drop table if exists user_roles cascade;
drop table if exists reimbursement_statuses cascade;
drop table if exists reimbursement_types cascade;


-- Create new schema and set it to current schema
create schema erts_schema authorization pg_database_owner;
comment on schema erts_schema is 'Schema for ERTS';
set schema 'erts_schema';


-- Create new tables

-- User Role Table
create table user_roles (
role_id varchar primary key not null unique,
role_text varchar not null default 'EMPLOYEE');

-- Reimbursement Statuses Table
create table reimbursement_statuses (
status_id varchar primary key not null unique,
status_text varchar not null);

-- Reimbursement Types
create table reimbursement_types (
type_id varchar primary key not null unique,
type_text varchar not null);

-- User Data
create table users (
id varchar primary key not null unique,
username varchar not null unique,
email varchar not null unique,
given_name varchar not null,
surname varchar not null,
role_id varchar not null references user_roles (role_id),
passwrd varchar not null,
role_promotion_approved_by varchar);

-- Reimbursement Tickets
create table reimbursements (
id varchar primary key not null unique,
amount money not null,
description varchar not null,
receipt bytea,
payment_id varchar, 
type_id varchar not null references reimbursement_types (type_id),
status_id varchar not null references reimbursement_statuses (status_id),
submitted timestamp not null,
submitter_id varchar not null references users (id),
resolved timestamp,
resolver_id varchar references users (id));

-- Insert User Role Data
insert into user_roles (role_id, role_text) values ('17083287-4167-4edb-abc0-ca8dec1c9152', 'EMPLOYEE');
insert into user_roles (role_id, role_text) values ('240eebc4-1bcb-49be-b816-96c8d19f76fd', 'MANAGER');
insert into user_roles (role_id, role_text) values ('3a89e958-6504-4cb6-ac83-14c0af1b732e', 'ADMIN');

-- Insert Reimbursement Type Data 
insert into reimbursement_types (type_id, type_text) values ('72b289fd-4899-496f-9329-27accb781525', 'LODGING');
insert into reimbursement_types (type_id, type_text) values ('5c7798a9-c3ee-4655-8841-afa43344161f', 'TRAVEL');
insert into reimbursement_types (type_id, type_text) values ('dee0f0d7-c3e5-4d33-8406-1c1cd6396b45', 'FOOD');
insert into reimbursement_types (type_id, type_text) values ('5bda58cb-1c32-46ed-b1fc-5a93d0270dc3', 'OTHER');

-- Insert Reimbursement Status Data
insert into reimbursement_statuses (status_id, status_text) values ('5d3d4eec-06cb-4979-a9fc-5d00300f422b', 'PENDING');
insert into reimbursement_statuses (status_id, status_text) values ('9be2a384-a18f-47a9-a190-9b4482e9f5b5', 'APPROVED');
insert into reimbursement_statuses (status_id, status_text) values ('1889b06d-9aea-42bd-9d8a-d29993e4ff16', 'DENIED');


-- Insert 3 Default Users
insert into users (id, username, email, given_name, surname, role_id, passwrd) values ('c26de9cb-cac3-401c-b324-3f7cd0b82845', 'erts-admin', 'admin@erts.net', 'System', 'Admin', '3a89e958-6504-4cb6-ac83-14c0af1b732e', 'pa55w0rd');
insert into users (id, username, email, given_name, surname, role_id, passwrd, role_promotion_approved_by) values ('fe4827cb-ee69-43bb-8f6c-ae90a240cc72', 'erts-mngr', 'manager1@finanace.erts.net', 'Finance', 'Manager',
			'240eebc4-1bcb-49be-b816-96c8d19f76fd', 'b1ah-b1aH', 'c26de9cb-cac3-401c-b324-3f7cd0b82845');





