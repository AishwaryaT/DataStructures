package DesignPatterns_Strategy;

public class DuckCallHunter{

	void mimic(Duck duck){
		System.out.println("Call of " + duck.getClass().getName());
		 duck.doQuack();
	}

}

