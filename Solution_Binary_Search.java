//Binary Search can be performed in a sorted array
//Divide and Conquer approach

import java.util.*;
import java.io.*;

public class Solution_Binary_Search
{
   public static void main(String [] args)
   {
     Scanner sc  = new Scanner(System.in);
     int size = sc.nextInt();
     int [] numbers = new int [size];
     for(int i = 0; i< size; i++)
       numbers[i] = sc.nextInt();
     System.out.println("Enter elem to search :");
     int elem  = sc.nextInt();
     int index = search(numbers, elem, 0, size-1);
     if( numbers[index++] == elem)
        System.out.println("Present at: " + index );
     else
        System.out.println("Not present in an array");
   }
   
   public static int search(int [] numbers, int elem, int left, int right)
   {
     if(left == right)
        return left;
     else{
        int mid = (left + right)/2;
        if( elem <= numbers[mid])
           return search(numbers, elem, left, mid);
        else
           return search(numbers, elem, mid+1, right);
     }
   }
}
    
   


