package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

public class StoredProcTestSuite {

    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbMenager dbManager = DbMenager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();

    }
    @Test
    void testUpdateBestsellers() throws SQLException {
        //Given
        DbMenager dbManager = DbMenager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();

        String sqlResetBestsellers = "UPDATE BOOKS SET BESTSELLER = 0";
        statement.executeUpdate(sqlResetBestsellers);

        String sqlInsertTestData = """
    INSERT INTO RENTS (BOOK_ID, READER_ID, RENT_DATE) VALUES
    (1, 1, CURDATE()), (1, 1, CURDATE() - INTERVAL 5 DAY), 
    (1, 1, CURDATE() - INTERVAL 10 DAY), 
    (2, 2, CURDATE()), (2, 2, CURDATE() - INTERVAL 5 DAY) 
""";
        statement.executeUpdate(sqlInsertTestData);

        String sqlCheckBefore = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = 1";
        ResultSet rsBefore = statement.executeQuery(sqlCheckBefore);

        int befUpdate = -1;
        if (rsBefore.next()) {
            befUpdate = rsBefore.getInt("HOW_MANY");
        }
        assertEquals(0, befUpdate);

        //When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement2.execute(sqlProcedureCall);

        //Then
        ResultSet rsAft = statement.executeQuery(sqlCheckBefore);
        int afterUpdate = -1;
        if (rsAft.next()) {
            afterUpdate = rsAft.getInt("HOW_MANY");
        }
        assertTrue(afterUpdate > 0);

        rsBefore.close();
        rsAft.close();
        statement.close();
        statement2.close();
    }
}
