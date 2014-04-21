package Sorting;
import java.io.*;
import java.util.*;

public class QuickSort
{
   public static void swap (int A[], int x, int y)
   {
      int temp = A[x];
      A[x] = A[y];
      A[y] = temp;
   }

   // Reorganizes the given list so all elements less than the first are 
   // before it and all greater elements are after it.                   
   public static int partition(int A[], int f, int l)
   {  int pIndex = f;
      int pivot = A[pIndex];
      while (f < l)
      {
         while (A[f] < pivot) f++;
         while (A[l] > pivot) l--;
         if(f<l){
        	 swap (A, f, l);
        	 //f++;
        	 //l--;
         }
        	 
      }
     // swap(A,l,pIndex);
      return f;
   }

   public static void Quicksort(int A[], int f, int l)
   {
      if (f >= l) return;
      int split_index = partition(A, f, l);
      Quicksort(A, f, split_index-1);
      Quicksort(A, split_index+1, l);
   }

   // All integers must be distinct
   public static void main(String args[])
   {
	   int A[] = {81,1,9,6,62,74,0,88,96,69};
     
      Quicksort(A, 0, A.length-1);

      for (int i=0 ; i < A.length ; i++) System.out.print(A[i] + " ");
      System.out.println();
   }
}

