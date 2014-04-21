package Collections;
import java.util.*;
public class Simple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al = new ArrayList<String>();
		al.add("Arun");
		al.add("aishu");
		
		Iterator it = al.iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		for(Object obj : al){
			System.out.println(obj);
		}
		
		//=======================================================================
		   Student s1=new Student(101,"Sonoo",23);  
		  Student s2=new Student(102,"Ravi",21);  
		//  Student s2=new Student(103,"Hanumat",25);  
		      
		  ArrayList al1=new ArrayList();  
		  al1.add(s1);  
		  al1.add(s2);  
		//  al.add(s3);  
		    
		  Iterator itr=al1.iterator();  
		  while(itr.hasNext()){  
		    Student st=(Student) itr.next();  
		    System.out.println(st.rollno+" "+st.name+" "+st.age);  
		  }  
				}	
}

class Student{  
	  int rollno;  
	  String name;  
	  int age;  
	  Student(int rollno,String name,int age){  
	   this.rollno=rollno;  
	   this.name=name;  
	   this.age=age;  
	  }  
	}  
