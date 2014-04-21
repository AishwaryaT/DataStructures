package DesignPatterns_Strategy;

public class Dumb implements QuackBehavior{

	public void speak(){
		System.out.println("I can't quack");
	}

}
