package BitOperations;

import java.util.*;
class binaryaddition{
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[10];
		int i,m,n,sum,carry=0;
		System.out.println ("enter 1st binary number");
		int n1 = sc.nextInt();
		System.out.println ("enter 2nd binary number");
		int n2 = sc.nextInt();
		for(i=arr.length-1;i>=0;i--){
			m=n1%10;
			n=n2%10;
			n1=n1/10;
			n2=n2/10;
			sum=m+n+carry;

			if(sum==1)
			{
				arr[i]=1;
				carry=0;
			}

			else	if(sum==2)
			{
				arr[i]=0;
				carry=1;
			}

			else	if(sum==3)
			{
				arr[i]=1;
				carry=1;
			}

			else{

				arr[i]=m+n+carry;
			}

		}
		for(i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}

	}

}
