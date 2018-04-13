
package prac.pkg1;

/**
 *
 * @author Akshaya
 */
import java.sql.*;
import java.util.Scanner;
public class Prac1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Connection con = null;
        //Statement stmt = null;
        Scanner s = new Scanner(System.in);
        Class.forName("com.mysql.jdbc.Driver");
        Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "");
        System.out.println("Enter Username: ");
        String un = s.next();
        System.out.println("Enter password: ");
        String pd = s.next();    
        String query = "select * from login where username = '"+un+"' and password  ='"+pd+"'";
        //System.out.println(query);
       Statement stmt = con.createStatement();
        ResultSet c = stmt.executeQuery(query);
        if(c.next())
            System.out.println("login sucess!!!!!!!!!!");
        else
            System.out.println("login failed!!!!!!!!!!");
       
    }
    
}
