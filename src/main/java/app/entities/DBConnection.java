package app.entities;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBConnection
{
    private Connection conn;
    public DBConnection()
    {
        try {
            Context ctx = new InitialContext();
            Context envctx = (Context) ctx.lookup("java:comp/env");
            DataSource ds = (DataSource) envctx.lookup("msadworks");
            conn = ds.getConnection();
        } catch (Exception e) { e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
