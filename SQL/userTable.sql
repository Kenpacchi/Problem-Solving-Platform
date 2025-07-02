CREATE TABLE leetUser(
id INT PRIMARY,
name VARCHAR(30),
phoneNumber VARCHAR(10) UNIQUE,
password VARCHAR(100),
email VARCHAR(100),
totalProblemSolved INT,
EasySolved INT,
mediumSolved INT,
hardSolved INT,
rating INT
);