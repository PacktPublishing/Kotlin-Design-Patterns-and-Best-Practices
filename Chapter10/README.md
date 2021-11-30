# Cats Hostel - Ktor

This is an example application for managing cats written in Ktor framework

## Setup
You need PostgreSQL installed.

After you have PostgreSQL, run the following commands to set up your database:
```
createuser cats_admin -W -d
createdb cats_db -U cats_admin
psql -U cats_admin -c "create table if not exists cats(id bigserial primary key, name varchar(20) not null unique, age integer)" cats_db
```