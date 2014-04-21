package DesignPatterns_Factory;
import java.io.*;

public class GenerateBill {

	public static void main(String[] args) throws IOException {
	FactoryPlan fp = new FactoryPlan();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 	
	
	System.out.print("Enter the name of plan for which the bill will be generated: ");  
	String inputPlan = br.readLine();
	
	System.out.print("Enter the number of units for bill will be calculated: ");
	int units = Integer.parseInt(br.readLine());
	
	Plan p = fp.getPlan(inputPlan);
	
	System.out.print("Bill amount for "+inputPlan+" of  "+units+" units is: ");  
	p.getRate();
	p.getBill(units);
	}

}
