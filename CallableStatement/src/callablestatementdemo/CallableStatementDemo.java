/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callablestatementdemo;

/**
 *
 * @author Akshaya
 */
import java.io.*;
import java.sql.*;
import java.sql.Types;
import java.util.Scanner;
import jdk.internal.org.objectweb.asm.Type;
class Student
{
    int rollno;
    String fname,sname,gender,dob;
    Scanner sc=new Scanner(System.in);
    public void getData()
    {
        try
        {
            System.out.println("Enter Rollno: ");
            rollno=sc.nextInt();
            System.out.println("Enter First name: ");
            fname=sc.next();
            System.out.println("Enter Last name: ");
            sname=sc.next();
            System.out.println("Enter Gender(Male/Female): ");
            gender=sc.next();
            System.out.println("Enter Date Of Birth: (yyyy-mm-dd)");
            dob=sc.next();
        }
        catch(Exception e){System.out.println(e);}
    }  
}
class Mark
{
    float m1=0,m2=0,m3=0;
    Scanner sc=new Scanner(System.in);
    public void getData()
    {
        try{
        System.out.println("Enter marks1: ");
        m1=sc.nextFloat();
        System.out.println("Enter marks2: ");
        m2=sc.nextFloat();
        System.out.println("Enter marks3: ");
        m3=sc.nextFloat(); 
        }catch(Exception e){System.out.println(e);}
    }
}
public class CallableStatementDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        Connection con = null;
        CallableStatement  csmt = null;
        Scanner sc = new Scanner(System.in);
        try{
                //Class.forName("com.mysql.jdbc.Driver");  
                //con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root",""); 
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb2", "root", "");
                System.out.print("Sucess...");
                
        }catch(Exception e){System.out.print("Sucess in catch...");}
        while(true)
        {
            System.out.print("\nmain menu\n");
            System.out.print("\n1.add details\n");
            System.out.print("2.calculate result\n");
            System.out.print("3.fetch distintion\n");
            System.out.print("4.list failures\n");
            System.out.print("5.marit list\n");
            System.out.print("6.exit\n");
            System.out.print("\nEnter your choice");
            int choice = sc.nextInt();
            if(choice == 1)
            {
                while(true)
                {
                    System.out.print("\nmain menu\n");
                    System.out.print("\n1.add student details\n");
                    System.out.print("2.add marks\n");
                    System.out.print("3.return to mainmenu\n");
                    System.out.print("\nEnter your choice");
                    choice = sc.nextInt();
                    if(choice == 1)
                    {
                        
                        try{ 
                            Student s = new Student();
                            s.getData();
                            csmt=con.prepareCall("{call insert_student(?,?,?,?,?)}");
                            csmt.setInt(1,s.rollno);
                            csmt.setString(2,s.fname);
                            csmt.setString(3,s.sname);
                            csmt.setString(4,s.gender);
                            csmt.setString(5,s.dob);
                            csmt.execute();
                            System.out.println("Entered sucessfully....");
                        }catch(Exception e){System.out.println(e);}
                    }
                    else if(choice == 2)
                    {
                        try{ 
                            System.out.print("\nEnter rollno: ");
                            int rollno = sc.nextInt();
                            Mark m = new Mark();
                            m.getData();
                            csmt=con.prepareCall("{call insert_marks(?,?,?,?,?)}");
                            csmt.setInt(1,rollno);
                            csmt.setFloat(2,m.m1);
                            csmt.setFloat(3,m.m2);
                            csmt.setFloat(4,m.m3);
                            csmt.setFloat(5,m.m1+m.m2+m.m3);
                            csmt.execute();
                            System.out.println("Entered sucessfully....");
                        }catch(Exception e){System.out.println(e);}
                    }
                    else
                    {
                        csmt.close();
                        break;
                     }
                }
            }
            else if(choice == 2)
            {
                try{
                int rn = sc.nextInt();
                csmt = con.prepareCall("{call Calculate_result4(?,?,?)}");
                String query="select concat(fname,' ',lname)as name from student where rollno =?";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setInt(1, rn);
                ResultSet rs = psmt.executeQuery();
                if(rs.next())
                {
                csmt.setInt(1, rn);
                csmt.registerOutParameter(2,Types.FLOAT);
                csmt.registerOutParameter(3, Types.VARCHAR);
                csmt.execute();
                System.out.println("rollno      name        percentage      grade");
                System.out.println(rn+"      "+rs.getString(1)+"         "+csmt.getFloat(2)+"        "+csmt.getString(3));
                }
                
                }catch(Exception e){System.out.println(e);}
                
            }
            else if(choice == 3)
            {
                csmt = con.prepareCall("{call Distinction(?,?,?,?,?,?,?)}");
                csmt.registerOutParameter(1, Types.INTEGER);
                csmt.registerOutParameter(2, Types.VARCHAR);
                csmt.registerOutParameter(3, Types.FLOAT);
                csmt.registerOutParameter(4,Types.FLOAT);
                csmt.registerOutParameter(5,Types.FLOAT);
                csmt.registerOutParameter(6,Types.FLOAT);
                csmt.registerOutParameter(7,Types.FLOAT);
                ResultSet rs = csmt.executeQuery();
                int counter=0;
                while(rs.next())
                {
                    if(counter == 0)
                    {
                        System.out.println("  rollno              name                   marks1                marks2               marks3          tatalmarks         percentege      ");
                        counter=1;
                    }
                     System.out.println(rs.getInt(1)+"              "+rs.getString(2)+"                   "+rs.getFloat(3)+"             "+rs.getFloat(4)+"                   "+rs.getFloat(5)+"               "+rs.getFloat(6)+"              "+rs.getFloat(7)+"\n");
                }
                counter = 1;
            }
            else if(choice == 4)
            {
                try
                {
                csmt = con.prepareCall("{call failure(?,?,?)}");
                csmt.registerOutParameter(1,Types.INTEGER);
                csmt.registerOutParameter(2, Types.VARCHAR);
                csmt.registerOutParameter(3,Types.FLOAT);
                ResultSet rs = csmt.executeQuery();
                int counter = 0;
                while(rs.next())
                {
                    if(counter == 0)
                    {
                       System.out.println("rollno       name        totalmarks"); 
                    }
                    System.out.println(rs.getInt(1)+"          "+rs.getString(2)+"         "+rs.getFloat(3));
                }
                }catch(Exception e){ System.out.println(e);}
            }
            else if(choice == 5)
            {
                csmt = con.prepareCall("{call Marit_list(?,?,?,?,?,?,?)}");
                csmt.registerOutParameter(1, Types.INTEGER);
                csmt.registerOutParameter(2, Types.VARCHAR);
                csmt.registerOutParameter(3, Types.FLOAT);
                csmt.registerOutParameter(4,Types.FLOAT);
                csmt.registerOutParameter(5,Types.FLOAT);
                csmt.registerOutParameter(6,Types.FLOAT);
                csmt.registerOutParameter(7,Types.FLOAT);
                ResultSet rs = csmt.executeQuery();
                 int counter=0;
                while(rs.next())
                {
                    if(counter == 0)
                    {
                        System.out.println("  rollno              name                   marks1                marks2               marks3          tatalmarks         percentege      ");
                        counter=1;
                    }
                     System.out.println(rs.getInt(1)+"              "+rs.getString(2)+"                   "+rs.getFloat(3)+"             "+rs.getFloat(4)+"        33            "+rs.getFloat(5)+"               "+rs.getFloat(6)+"              "+rs.getFloat(7)+"\n");
                }
                counter = 1;
            }
            else if(choice == 6)
            {
                con.close();
                csmt.close();
                break;
            }
        }
        
    }
    
}
