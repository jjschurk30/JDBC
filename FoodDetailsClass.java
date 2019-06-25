

import java.util.*;
import java.sql.*;

class FoodDetails
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            int id,calories;
            String name;




            Connection con=DriverManager.getConnection("jdbc:ucanaccess://D:/food.accdb");
            Statement smt=con.createStatement();
            smt.executeUpdate("create table FoodItem (ID number,Name varchar(30),Calories number)");
            System.out.println("Table created Successfully!!");

            System.out.print("Enter ID : ");
            id=sc.nextInt();
            System.out.print("Enter Name : ");
            name=sc.next();
            System.out.print("Enter Calories : ");
            calories=sc.nextInt();

            smt.executeUpdate("insert into FoodItem values('"+id+"','"+name+"'),'"+calories+"'");
            System.out.println("Record Inserted successfully!!");

            ResultSet rs=smt.executeQuery("select * from FoodItem");

            while(rs.next())
            {
                System.out.println("ID : "+rs.getInt("ID"));
                System.out.println("Name : "+rs.getString("Name"));
                System.out.println("Calories : "+rs.getInt("Calories"));
            }
            rs.close();
            smt.close();
            con.close();
        }
        catch(Exception e1)
        {
            System.out.println("Exception is "+e1);
        }
    }
}
