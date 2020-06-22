package by;


import by.util.ConnectorDB;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorDBTest {

    @Test
    public void testGetConnection() {

        Connection conn=null;

        try {
            conn = ConnectorDB.getConnection();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        Assert.assertNotNull(conn);
    }

}
