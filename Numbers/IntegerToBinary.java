package Numbers;

import java.util.Scanner;

public class IntegerToBinary {
    public static void main(String[] args) {
        int number; 

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integer");
        number=in.nextInt();

        if (number <0)
            System.out.println("Error: Not a positive integer");
        else { 

            System.out.print("Convert to binary Method 1:");
            binaryform(number);
            System.out.println("\n Convert to binary Method 2:");
            int array[]  = decToBin(12, getBinArray(12));
            for (int i : array)
            	System.out.print(i);
        }
    }
  //Method 1:
    private static void binaryform(int number) {
        int remainder;

        if (number <=1) {
            System.out.print(number);
            return;   // KICK OUT OF THE RECURSION
        }

        remainder= number %2; 
        binaryform(number >>1);
        System.out.print(remainder);
               
        }
    //Method 2: 
    public static int[] getBinArray(int number){
        int res = number, length = 0;
        while(res != 0){        
            res /= 2;
                    length++;
        }
        return new int[length];
    }

    public static int[] decToBin(int number, int[] array){
        int res = number, k = array.length-1;
        while(res != 0){
            if(res%2 == 0){
                array[k] = 0;
            }else{
                array[k] = 1;
            }
            k--;
            res /= 2;
        }
        return array;
    }
}
