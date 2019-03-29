//The problem of sorting a list of numbers lends itself immediately to a divide-and-conquer strategy: split the list into 2 halves, recursively sort each half, and then merge the sorted sub lists
//Merge Sort

import java.util.*;
import java.io.*;

public class Solution_Merge_Sort
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] numbers = new int [size];
    for(int i = 0; i< size; i++)
      numbers[i] =sc.nextInt();
    divide(numbers, 0, size-1);
    print(numbers);
  }
  
  //print
  public static void print(int [] numbers)
  {
    System.out.println("Sorted Array");
    for(int i =0; i< numbers.length ; i++)
      System.out.print(numbers [i] + "  ");
    System.out.println();
  }
  
  //Partition algorithm
  public static void divide(int [] numbers, int start, int end)
  {
    if(  start < end)
    {
      int mid = (start + end)/2;
      divide(numbers, start, mid);
      divide(numbers, mid+1, end);
      merge(numbers, start, mid, end);
    }
  }
  
  //merge algorithm 
  public static void merge(int [] numbers, int start, int mid, int end)
  {
    
    int left = mid - start +1;
    int right = end - mid;
    
    int [] left_nums = new int [left];
    int [] right_nums = new int [right];
    
    for(int i = 0; i< left; i++)
      left_nums[i] = numbers[start + i];
    for(int j = 0; j< right; j++)
       right_nums[j] = numbers[mid+j+1];
       
    
    int i = 0;
    int j = 0;
    int k = start;
    
    while( i < left && j < right)
    {
      if(left_nums[i] <= right_nums[j]){
         numbers[k] = left_nums[i];
         i++;
      }
      else{
         numbers[k] = right_nums[j];
         j++;
       }
       k++;
    }
    
    while(i <left){
      numbers[k] = left_nums[i];
      i++;
      k++;
    }
    while(j < right){
      numbers[k] = right_nums[j];
      j++;
      k++;
    }

  }
}
    
       
       
