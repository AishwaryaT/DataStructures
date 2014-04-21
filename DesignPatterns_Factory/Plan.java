package DesignPatterns_Factory;

abstract public class Plan {

	protected double rate;
	
	public void getBill(int units){
		System.out.print( units*rate);
	}
		
	abstract void getRate();
	
}
