# Application Setup Guide

This guide will help you to start up the application locally on your computer. The application consists of a backend built with Spring Boot and a frontend built with ReactJS.

## Backend Setup

- Download the entire project and save it on your local computer.
- Set up your PostgreSQL database with the included database file. You can use Navicat to manage the PostgreSQL database.
- Open the Spring Boot backend in IntelliJ IDEA and click the run button, or open the terminal and type the command `mvn spring-boot:run`. Make sure that JDK and Maven are already installed on your computer.
- To get a random country, use the following API: `http://localhost:8080/getRandomCountry`.
- To get the top 3 books with the borrower, use the following API: `http://localhost:8080/getTop3ReadBooks`.

## Frontend Setup

- Download the entire project and save it on your local computer.
- Open the project in VS Code.
- Open the terminal and change the directory to the frontend folder.
- Enter the command `npm start` in the terminal.
- The frontend can be accessed at `http://localhost:3000/`.

## PostgreSQL

The PostgreSQL host port is 5432.