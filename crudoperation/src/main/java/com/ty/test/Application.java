package com.ty.test;

import java.util.Scanner;

import com.ty.Dao.EmployeeDao;
import com.ty.entity.Employee;

public class Application {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		a:while (true) {
			System.out.println("----Welcome to Employee Management App----");
			System.out.println("Press 1:Insert Employeee Data");
			System.out.println("Press 2:Update Employeee Data");
			System.out.println("Press 3:Delete Employeee Data");
			System.out.println("Press 4:Read Employeee Data");
			System.out.println("Press 5: Exit");
			System.out.println("Enter Your Choice ");
			
			int n = sc.nextInt();

			switch (n) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				read();
				break;
			case 5:
				System.out.println("Thank You Have A Good Day ");
				break a;
			default:
				System.out.println("Invalid Input Please Try Again");
			}
		}
	}

	public static void read() {
		Employee e3=new Employee();
		EmployeeDao.readData(e3);
		
	}

	public static void delete() {
        Employee e2=new Employee();
		
		EmployeeDao.deleteData(e2);
	}

	public static void update() {
    Employee e4=new Employee();
    EmployeeDao.updateData(e4);
		
		
	}

	public static void insert() {
		sc.nextLine();
		Employee e=new Employee();
		System.out.println("Enter your name ");
//String name=sc.nextLine();
		e.setName(sc.nextLine());
		System.out.println("Enter your Salary");
		//double salary=sc.nextDouble();
		e.setSalary(sc.nextDouble());
		System.out.println("Enter your Designation ");
		e.setDesignation(sc.next());
		System.out.println("Enter your Department Number");
		e.setDept_no(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter your email address");
		e.setEmail(sc.nextLine());
		System.out.println("Enter your Mobile No ");
		e.setMobile(sc.nextLong());
		EmployeeDao.insertData(e);
		
	}
}
