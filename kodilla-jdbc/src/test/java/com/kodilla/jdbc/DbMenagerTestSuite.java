package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DbMenagerTestSuite {
    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbMenager dbManager = DbMenager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbMenager dbManager = DbMenager.getInstance();
        Statement setupStatement = dbManager.getConnection().createStatement();

        //When
        Statement statement = dbManager.getConnection().createStatement();
        setupStatement.executeUpdate("INSERT INTO USERS (FIRSTNAME, LASTNAME) VALUES ('John', 'Doe')");
        setupStatement.executeUpdate("INSERT INTO USERS (FIRSTNAME, LASTNAME) VALUES ('Jane', 'Doe')");
        setupStatement.executeUpdate("INSERT INTO USERS (FIRSTNAME, LASTNAME) VALUES ('Junior', 'Doe')");
        setupStatement.executeUpdate("INSERT INTO USERS (FIRSTNAME, LASTNAME) VALUES ('Johnny', 'Doe')");
        setupStatement.executeUpdate("INSERT INTO USERS (FIRSTNAME, LASTNAME) VALUES ('Johnt', 'Doe')");
        String sqlQuery = "select * from users";
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("firstname")
                    + " " + resultSet.getString("lastname"));
            counter++;
        }
        Statement cleanupStatement = dbManager.getConnection().createStatement();
        cleanupStatement.executeUpdate("DELETE FROM USERS");
        resultSet.close();
        statement.close();
        assertEquals(5, counter);
    }

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbMenager dbManager = DbMenager.getInstance();
        Statement cleanupStatement = dbManager.getConnection().createStatement();
        cleanupStatement.executeUpdate("DELETE FROM POSTS");
        cleanupStatement.executeUpdate("DELETE FROM USERS");
        cleanupStatement.close();
        Statement setupStatement = dbManager.getConnection().createStatement();
        setupStatement.executeUpdate("INSERT INTO USERS (ID, FIRSTNAME, LASTNAME) VALUES (1, 'John', 'Doe')");
        setupStatement.executeUpdate("INSERT INTO POSTS (ID, USER_ID) VALUES (1, 1), (2, 1)");
        setupStatement.executeUpdate("INSERT INTO USERS (ID, FIRSTNAME, LASTNAME) VALUES (2, 'Jane', 'Smith')");
        setupStatement.executeUpdate("INSERT INTO POSTS (ID, USER_ID) VALUES (3, 2), (4, 2), (5, 2)");
        setupStatement.close();

        //When
        String sqlQuery = """
                SELECT U.FIRSTNAME, U.LASTNAME,  COUNT(*) AS POSTS_NUMBER
                FROM posts P JOIN USERS U ON USER_ID = U.ID
                group by U.FIRSTNAME, U.LASTNAME
                having COUNT(*) > 1;
                """;
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        int userCounter = 0;
        while (resultSet.next()) {
            String firstName = resultSet.getString("FIRSTNAME");
            String lastName = resultSet.getString("LASTNAME");
            int postsNumber = resultSet.getInt("POSTS_NUMBER");
            System.out.println("User: " + firstName + " " + lastName + ", Posts: " + postsNumber);
            assertTrue(postsNumber > 1, "User has less than 2 posts");
            userCounter++;
        }
        //Then
        assertEquals(2, userCounter);
        cleanupStatement = dbManager.getConnection().createStatement();
        cleanupStatement.executeUpdate("DELETE FROM POSTS");
        cleanupStatement.executeUpdate("DELETE FROM USERS");
        cleanupStatement.close();
    }
}