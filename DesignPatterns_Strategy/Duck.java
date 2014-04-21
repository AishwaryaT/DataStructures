package DesignPatterns_Strategy;

public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
	
	public void doSwim(){
		System.out.println("All ducks float");
	}

	public void doFly(){
		flyBehavior.fly();
	}
	
	public void doQuack(){
		quackBehavior.speak();
	}
	
	public abstract void doDisplay();
}


