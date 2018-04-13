/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchrecord;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

/**
 *
 * @author Akshaya
 */
public class SearchRecord {

    public static Connection function()
        {
            Connection con = null;
             try
                {
                    Class.forName("com.mysql.jdbc.Driver");  
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Studentdb","root","");  
                            //here sonoo is database name, root is username and password  
                    //stmt=con.createStatement(); 
                 }catch(Exception e){}  
             return con;
        }
   public static void show(int rollno,String name,String gender,String dob,float m1,float m2,float m3,float total)
   {
        try
                {
                    System.out.println("RollNo     Name          Gender         DOB      Marks1    Marks2    marks3     Avg");
                    System.out.print(rollno+"      "+name+"  "+gender+"       "+dob);
                    System.out.print("    "+m1+"     "+m2+"     "+m3+"     "+total+"       "+total/3+"\n");
                }catch(Exception e){}
                finally{}
   }
    public static void main(String[] args)throws Exception {
        Connection con=function();
        CallableStatement cstmt=null;      
        Scanner sc = new Scanner(System.in);
        int n=0;
        while(true)
        {
            System.out.println("MAIN MENU");
            System.out.println("\t1)Search by name.");
            System.out.println("\t2)Search by rollno");
            System.out.println("\t3)Search by gender");
            System.out.println("\t4)Search by date of birth");
            System.out.println("\t7)EXIT");
            System.out.println("\tEnter Your Choice: ");
            int ch=sc.nextInt();
            if(ch == 1)
            {
                System.out.print("\tEneter name:  ");
                String name = sc.next();
                cstmt = con.prepareCall("{call Srach_name(?,?,?,?,?,?,?,?,?)}");
                cstmt.setString(1, name);
                cstmt.registerOutParameter(2,Types.INTEGER);
                cstmt.registerOutParameter(3,Types.VARCHAR);
                cstmt.registerOutParameter(4,Types.VARCHAR);
                cstmt.registerOutParameter(5,Types.VARCHAR);
                cstmt.registerOutParameter(6,Types.FLOAT);
                cstmt.registerOutParameter(7,Types.FLOAT);
                cstmt.registerOutParameter(8,Types.FLOAT);
                cstmt.registerOutParameter(9,Types.FLOAT);
                ResultSet rs = cstmt.executeQuery();
                while(rs.next())
                {
                    show(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getFloat(7),rs.getFloat(8),rs.getFloat(9));
                }
                
                
            }
        }
    }
    
}
