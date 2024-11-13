package com.ty.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ty.entity.Employee;

public class EmployeeDao {
	static String url = "jdbc:postgresql://localhost:5432/m3_jdbc?user=postgres&password=root";
	static Scanner sc = new Scanner(System.in);

	public static void insertData(Employee e) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			String sql = "insert into employee_1 values(NEXTVAL('employee_id_seq'),?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setDouble(2, e.getSalary());
			ps.setString(3, e.getDesignation());
			ps.setInt(4, e.getDept_no());
			ps.setString(5, e.getEmail());
			ps.setLong(6, e.getMobile());
			ps.execute();
			System.out.println("Data saved successfully....");
			// ps.close();
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void deleteData(Employee e2) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);

			String sql = "delete from employee_1 where emp_id= ?";
//		Connection connection = DriverManager.getConnection(url, properties);
			System.out.println("Enter the id of the row to be deleted ");
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, sc.nextInt());
			statement.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readData(Employee e3) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			Statement statement = con.createStatement();
			String sql = "select * from employee_1";
			ResultSet rs = statement.executeQuery(sql);
			System.out.println("emp_id emp_name emp_salary emp_designation emp_deptno emp_email emp_mobile");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3) + " " + rs.getString(4)
						+ " " + rs.getInt(5) + " " + rs.getString(6) + " " + rs.getLong(7));
			}
			System.out.println("Data received successfully");
			statement.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateData(Employee e4) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url);
			System.out.println("Please Select Choice");
			System.out.println("1.For Updating data using mobile No");
			System.out.println("2.For Updating data using email address");
			System.out.println("Enter Your Choice ");
			int n = sc.nextInt();
			switch (n) {
			case 1: {
				String sql = "update employee_1 set emp_name = ?,emp_salary=?, emp_designation=?, emp_dept_no=?, emp_email=? where emp_mob_no=?";
				PreparedStatement ps = con.prepareStatement(sql);
				System.out.println("Enter ur mobile no ");
				Long mobile = sc.nextLong();
				ps.setLong(6, mobile);
				System.out.println("Enter new name");
				sc.nextLine();
				String name = sc.nextLine();
				ps.setString(1, name);

				System.out.println("Enter new salary");
				double salary = sc.nextDouble();
				ps.setDouble(2, salary);

				System.out.println("Enter new Designation");
				sc.nextLine();
				String designation = sc.nextLine();
				ps.setString(3, designation);

				System.out.println("Enter new department number");
				int deptno = sc.nextInt();
				ps.setInt(4, deptno);

				System.out.println("Enter Your email ID");
				sc.nextLine();
				String email = sc.nextLine();
				ps.setString(5, email);
			
			int upd = ps.executeUpdate();
			if (upd > 0) {
	                System.out.println("update successfully.");
	            } else {
	                System.out.println("No record found");
	            }
			ps.close();
			break;
			}
			case 2:{
				String sql1="update employee_1 set emp_name = ?,emp_salary=?, emp_designation=?,emp_dept_no=?, emp_mob_no=? where emp_email=?";
	    		PreparedStatement ps1 = con.prepareStatement(sql1);
	    		
	    		System.out.println("Enter new email");
	    		sc.nextLine();
	    		String email1=sc.nextLine();
	    		ps1.setString(6, email1);
	    		
	    
	    		System.out.println("Enter new name");
	    		sc.nextLine();
	    		String name1=sc.nextLine();
	    		ps1.setString(1, name1);
	    		
	    		System.out.println("Enter new salary");
	    		double salary1=sc.nextDouble();
	    		ps1.setDouble(2, salary1);
	    		
	    		System.out.println("Enter new Designation");
	    		sc.nextLine();
	    		String designation1=sc.nextLine();
	    		ps1.setString(3, designation1);
	    		
	    		System.out.println("Enter new department number");
	    		int deptno1=sc.nextInt();
	    		ps1.setInt(4, deptno1);
	    		
	    		System.out.println("Enter Your Mobile number");
	    		Long mobile1=sc.nextLong();
	    		ps1.setLong(5, mobile1);
	    		
	    		
	    		int upd1 = ps1.executeUpdate();
				if (upd1 > 0) {
		                System.out.println("update successfully.");
		            } else {
		                System.out.println("No record found");
		            }
				ps1.close();
				break;		
			}
			default:System.out.println("Invalid Choice");
		  }
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
