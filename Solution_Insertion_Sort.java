//Binary Insertion Sort
//Uses binary search to find the proper location to insert the selected item at each iteration

import java.util.*;
import java.io.*;

public class Solution_Insertion_Sort
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] numbers = new int [size];
    
    for(int i = 0; i< size ; i++)
      numbers[i] = sc.nextInt();
    sort(numbers);
    print(numbers);
  }
  
  public static void print( int [] numbers)
  { 
    System.out.println("Sorted Array");
    for(int i = 0; i< numbers.length; i++)
      System.out.print(numbers[i]+ " ");
    System.out.println();
  }
  
  public static int find_loc(int [] numbers , int temp, int low, int high)
  {
     if (high <= low)
      return ( temp > numbers[low])? (low +1) : low;
      
     int mid = (low + high)/2;
     
     if(temp == numbers[mid])
       return mid+1;
     
     if(temp > numbers[mid])
       return find_loc(numbers, temp, mid+1, high);
     
     return find_loc(numbers, temp, low, mid-1);
     
  }
  
  public static void sort(int numbers[])
  {
    for(int i  = 1; i< numbers.length; i++)
    {
       int index = i -1;
       int temp = numbers[i];
       
       //Function to find location to insert the elem 
       //int j = Math.abs(Arrays.binarySearch(numbers,0, i, x)+ 1);
       
       int place_index = find_loc(numbers, temp, 0, index);
       
       //Shifting array to on location right
       //System.arraycopy(numbers, j , numbers, j+1, i-j);
       
       while(index >= place_index){
         numbers[index+1] = numbers[index];
         index--;
       }
       numbers[index+1] = temp;
    }
  }
}
       
