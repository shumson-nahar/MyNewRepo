package oop;

public class Employee {
	//Variable
	//Method
	int empid;
	String empname;
	int salary;
	int deptno;
	public void display() {
		System.out.println(empid);
		System.out.println(empname);
		System.out.println(salary);
		System.out.println(deptno);
		
	}

	public static void main(String[] args) {
		
		Employee emp1= new Employee();//First employee
		emp1.empid=101;
		emp1.empname="Raj";
		emp1.salary=2000;
		emp1.deptno=10;
		emp1.display();
		
		Employee emp2= new Employee();//Second employee
		emp2.empid=102;
		emp2.empname="Shumson";
		emp2.salary=3000;
		emp2.deptno=20;
		emp2.display();
		

	}

}
