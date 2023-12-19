# Setup & run

## Setup

Import the project into Eclipse.
The only thing needed is an empty database.
Can be configured here: persistence.xml, hibernate.cfg.xml

## Run

Right click on `main()` of `App.java` and "Run as Java application"

# Notes

## Note #1

Eclipse has a bug and displays an error about User class:

> Class "net.horvoje.querydsl.bugs.contains.entity.User" is listed in the persistence.xml file, but is not annotated

This can be ignored meaning project will run no matter this error displayed.

## Note #2

Created to support bug report @ https://github.com/querydsl/querydsl/issues/3618