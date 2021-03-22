#FRONTEND &nbsp;

The frontend is a react application generated (bootstrapped) with: &nbsp;

> npx create-react-app appsName &nbsp;

Dependencies need to be installed from `package.js` while within the project's directory by running this line of code in the terminal: &nbsp;

> npm init &nbsp;

The project can be tested in the browser by running the following line of code: &nbsp;

> npm start &nbsp;

Then paste this url in to the browser, 3000 is the default port for a React app: &nbsp;

> http://localhost:3000 &nbsp;

Check the browser's console for any issues, right click on the current page > select `Inspect` > console or press `F12` on the keyboard


#BACKEND &nbsp;
As in the `Frontend` dependencies ought to be installed, in this case from the pom.xml file.

To run the `Backend`: &nbsp;
right click on the `Application.java` > Run As > Spring Boot App.
Subsequently navigate to: &nbsp;

> http://localhost:8080 &nbsp;

In order to visualise the project in the browser both front and backend must be running from their respective ports.

This project was developed with JDK 8 and Maven.

The Application contains the following:
- An SQL Database
- An Application Properties
- An Entity Model Class
- An Dao Interface
- A Service Class
- A Spring MVC Controller Class
- An Application Class
- Handling exceptions

End Points:

- Retrieve a list of all products
- Add a new product
- Edit an existing product
- Remove an exiting product


## Create a table, insert and query it
USE products_DB;
CREATE TABLE monitor (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`brand` VARCHAR(45) NOT NULL,
`resolution` INT(4) NOT NULL,
`model` VARCHAR(8) NOT NULL,
`price` FLOAT(6) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

USE products_DB;
INSERT INTO monitor VALUES (1000, 'Dell', 1080, 'SE2216H', 89.99);
INSERT INTO monitor VALUES (1001, 'Samsung', 1280, 'S2721HGF', 328.49);

mysql> desc monitor;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| id         | int         | NO   | PRI | NULL    | auto_increment |
| brand      | varchar(45) | NO   |     | NULL    |                |
| resolution | int         | NO   |     | NULL    |                |
| model      | varchar(8)  | NO   |     | NULL    |                |
| price      | float       | NO   |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+

mysql> SELECT * FROM monitor;
+------+---------+------------+----------+--------+
| id   | brand   | resolution | model    | price  |
+------+---------+------------+----------+--------+
| 1000 | Dell    |       1080 | SE2216H  |  89.99 |
| 1001 | Samsung |       1280 | S2721HGF | 328.49 |
+------+---------+------------+----------+--------+


