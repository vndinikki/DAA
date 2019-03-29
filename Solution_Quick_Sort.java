//Quick Sort Algorithm (Principle of Divide and Conquer)
//Time complexity: n(log n)

import java.util.*;
import java.io.*;

public class Solution_Quick_Sort
{
  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] numbers = new int [size];
    
    for(int i= 0; i< size; i++)
      numbers[i] = sc.nextInt();
    
    sort(numbers, 0, size-1);
    print(numbers);
  }
  
  public static void print(int [] numbers)
  {
    System.out.println("Sorted Array");
    for(int i = 0; i< numbers.length; i++)
      System.out.print(numbers[i]+ " ");
    System.out.println();
  }
  
  public static void sort(int [] numbers, int low, int high)
  {
    if(low < high)
    {
       int mid = divide(numbers, low, high);
       sort(numbers, low, mid-1);
       sort(numbers, mid+1, high);
    }
  }
  
  public static int divide(int [] numbers, int low, int high)
  {
    int temp = numbers[high];
    int i = low-1;
    for(int j = low; j< high; j++)
    {
       if(numbers[j] <= temp){
         i++;
         swap(numbers, i, j);
       }
     }
     swap(numbers, i+1, high);
     return i+1;
  }
  
  public static void swap(int [] numbers, int a, int b)
  {
    int temp = numbers[a];
    numbers[a] = numbers[b];
    numbers[b] = temp;
  }
}
         
      
      
       
