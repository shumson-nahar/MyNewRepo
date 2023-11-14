package oop;

public class Child extends Parent {
	public void sportsCar() {
		System.out.println("Child's sports car");
	}
	public void Bike() {
		System.out.println("Child's bike");
	}

	public static void main(String[] args) {
		Child child = new Child();
		child.apartment();
		child.bankBalance();
		child.Bike();
		child.sportsCar();
		
		Parent parent = new Parent();
		parent.apartment();
		parent.bankBalance();
		
	}

}
