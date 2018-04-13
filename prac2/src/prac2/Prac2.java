
package prac2;
import java.sql.*;
import java.util.Scanner;

    
   class Student
    {
       Scanner s = new Scanner(System.in);

        public String name =null;
        public int id = 0;
        public int age = 0;
        public String address = null;
        public void getData()
        {
            System.out.println("Enter id");
            id = s.nextInt();
            System.out.println("Enter name");
            name = s.next();
            System.out.println("Enter age");
            age = s.nextInt();
            System.out.println("Enter address");
            address = s.next();
        }
    }
public class Prac2 {
    

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner s = new Scanner(System.in);
        Student std = new Student();
        Connection con = null;
        Statement stmt  = null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "");
        stmt = con.createStatement();
        while(true)
        {
            System.out.println("1.insert");
            System.out.println("2.update");
            System.out.println("3.delete");
            System.out.println("4.exit");
            System.out.println("Enter your choice: ");
            int ch = s.nextInt();
            if(ch == 1)
            {
                //stmt = con.createStatement();
                std.getData();
                String query = "insert into student values("+std.id+",'"+std.name+"',"+std.age+",'"+std.address+"')";         
                System.out.println(query);
                int c = stmt.executeUpdate(query);
                if(c==1)
                    System.out.println("inserted successfully");
                else
                    System.out.println("try again");
            }
            else if(ch ==3)
            {
                //stmt=con.createStatement();
                System.out.println("Enter id");
                int id = s.nextInt();
                String qery="delete from student where id = "+id;
                int i = stmt.executeUpdate(qery);
                System.out.println(i+" rows deleted");
            }
            else if(ch ==2)
            {
               // stmt = con.createStatement();
                System.out.println(" Enter Id");
                int id  = s.nextInt();
                std.getData();
                String query = "update student set  name = '"+std.name+"',age = "+std.age+",address = '"+std.address+"' where id = "+id;
                int i = stmt.executeUpdate(query);
                System.out.println(i+" rows updated");
            }
            else if(ch ==4)
                break;
        }
    }
    
}
