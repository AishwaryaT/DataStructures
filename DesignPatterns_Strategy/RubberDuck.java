package DesignPatterns_Strategy;

public class RubberDuck extends Duck{

	RubberDuck(){
		flyBehavior = new NonLivingWithoutWings();
		quackBehavior = new Dumb();
	}
	
	public void doDisplay(){
		System.out.println("I am Rubber Duck!!");
	}
}
