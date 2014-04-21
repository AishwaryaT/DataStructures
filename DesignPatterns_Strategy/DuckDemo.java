package DesignPatterns_Strategy;

public class DuckDemo {

	public static void main(String[] args) {
		Duck dd = new DonalDuck();
		dd.doDisplay();
		dd.doFly();
		dd.doQuack();
		
		Duck rd = new RubberDuck();
		rd.doDisplay();
		rd.doFly();
		rd.doQuack();

		DuckCallHunter h = new DuckCallHunter();
		h.mimic(new DonalDuck());
	}

}
