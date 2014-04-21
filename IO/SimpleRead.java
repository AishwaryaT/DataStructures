package IO;


import java.io.*;  
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
class SimpleRead{  
public static void main(String args[]){  
 try{  
     
   FileInputStream fin=new FileInputStream("f1.txt");  
   BufferedInputStream bin=new BufferedInputStream(fin);  
   
   Scanner s = new Scanner(System.in);
   
   Hashtable H = new Hashtable();
   H.put(8, "Aishu");
   
   System.out.println("??"+H.get(8));
   
   
   int i;  
   while((i=bin.read())!=-1)  
    System.out.println((char)i);  
 
  // bin.close();  
 }catch(Exception e){System.out.println(e);}  
}  
} 
