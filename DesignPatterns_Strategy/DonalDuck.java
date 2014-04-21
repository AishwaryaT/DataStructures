package DesignPatterns_Strategy;

public class DonalDuck extends Duck{
	
	public DonalDuck(){
		flyBehavior = new LivingWithWings();
		quackBehavior = new Quack();
	}

	public void doDisplay(){
		System.out.println("I am Donald Duck!!");
	}

}
