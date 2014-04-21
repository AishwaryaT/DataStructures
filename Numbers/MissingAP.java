package Numbers;
import java.io.*;
public class MissingAP {
    public static void main(String args[] ) throws Exception {
        System.out.println("Enter N and N number of integers");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        String s = br.readLine();
        String temp[] = s.split(" ");
        
        for(int i =0; i <arr.length; i++){
        	arr[i] = Integer.parseInt(temp[i]);
        }
        
      /*  for(int i: arr)
        	System.out.println(i);*/
        findMissingAP(arr);
    }
    //my version
    public static int findMissing(int[] arr){
        int ap = arr[1] - arr[0];
        for(int i = 2; i < arr.length; i++){
           if(arr[i]- arr[i-1] == ap)
               continue;
           ap = (arr[i]-arr[i-1] == arr[i+1]-arr[i])? arr[i]-arr[i-1] : ap;
           if(ap == arr[i] - arr[i-1])
               return arr[i-1] - ap;
            else
               return arr[i-1] + ap;
        }
		return 0;
        
    }
    
    // optimized version for +ve and -ve increasing/decreasing series.
    public static void findMissing1(int [] arr){
    	int diff[]= new int[arr.length-1];
    	for(int i = 0; i<arr.length-1;i++){
    	    diff[i] = arr[i+1]-arr[i];
    	    //System.out.println(diff[i]);
    	    if(i!=0){
    	        if(diff[i]<diff[i-1]){
    	            if(diff[i]<0)
    	                System.out.println(arr[i]+diff[i-1]);
    	            else
    	                System.out.println(arr[i-1]+diff[i]);
    	            break;
    	        }
    	        if(diff[i]>diff[i-1]){
    	            if(diff[i]<0)
    	                System.out.println(arr[i-1]+diff[i]);
    	            else
    	                System.out.println(arr[i]+diff[i-1]);
    	            break;
    	        }
    	    }
    	}
    }
    
    //using arithmetic series formula
    public static void findMissingAP(int [] arr){
    	//sum of AP = n * (a[0]+a[n-1])/2
    	
    	int apSum = (arr.length+1)*(arr[0]+arr[arr.length-1])/2;
    	//System.out.println(apSum);
    	int calculatedSum =0;
    	for(int i : arr)
    		calculatedSum +=i;
    	int missing = apSum - calculatedSum;
    	System.out.println(missing);
      }


}