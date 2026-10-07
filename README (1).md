# JDBC MySQL PreparedStatement

## Problem
This Java program:
1. Connects to the MySQL database `mydatabase`.
2. Creates the `users` table if it does not exist.
3. Inserts two records using `PreparedStatement`.
4. Displays a success message.
5. Handles `SQLException`.
6. Uses try-with-resources.

## Database
Make sure MySQL is running and the database exists:

```sql
CREATE DATABASE mydatabase;
```

## Important
Change these values in `src/Main.java` if your MySQL setup is different:

```java
private static final String USERNAME = "root";
private static final String PASSWORD = "root";
```

The MySQL JDBC driver (Connector/J) must be available in the Java classpath.

## Expected output

Data inserted successfully.
