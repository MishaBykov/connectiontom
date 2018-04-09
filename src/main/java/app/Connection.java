package app;
import app.entities.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

public class Connection extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       PrintWriter writer = resp.getWriter();
        writer.println("It's working!");
    try{
           DBConnection worker=new DBConnection();
           PreparedStatement statement=worker.getConn().prepareStatement("INSERT into Users values (?,?,?)");
           statement.setInt(1,1);
           statement.setString(2,"Ivan");
           statement.setString(3,"Ivanov");
           statement.execute();
           statement.close();
        }
        catch (Exception e){
           writer.println("Exception");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String pass=req.getParameter("pass");
        PrintWriter writer = resp.getWriter();
        writer.println("Post method!");
        try {
            DBConnection worker=new DBConnection();
            PreparedStatement statement=worker.getConn().prepareStatement("INSERT into Users values (?,?,?)");
            statement.setInt(1,1);
            statement.setString(2,name);
            statement.setString(3,pass);
            statement.execute();
            statement.close();
            writer.println("Post success!");
        }
        catch (Exception e){
        }
    }
}
