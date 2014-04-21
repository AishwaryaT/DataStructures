package DesignPatterns_Factory;


public class FactoryPlan {

	public Plan getPlan(String input){
	
		if (input.equalsIgnoreCase("DomesticPlan"))
			return new DomesticPlan();
		
		else if (input.equalsIgnoreCase("CommercialPlan"))
			return new CommercialPlan();
		
		else if (input.equalsIgnoreCase("InstitutionalPlan"))
			return new DomesticPlan();
		else 
			return null;
		
	}

}
