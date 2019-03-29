//Timsort ( Merge + Insertion)
/*Basic Idea
    For small values of n insertion sort runs faster than merge sort . Hence insertion sort can be used to Optimize merge sort
    Basic idea is apply insertion sort on sublists obtained in merge sort and merge the sorted (using insertion sort) lists 
Time Complexity:: https://cs.stackexchange.com/questions/68179/combining-merge-sort-and-insertion-sort */
  
import java.util.Scanner;
import java.io.*;

public class Solution_Timsort
{

  public static void main(String [] args)
  {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] numbers = new int [size];
    for(int i = 0; i< size; i++)
      numbers[i] = sc.nextInt();
    sort(numbers);
    print(numbers);
  }
  
  public static void print(int [] numbers)
  {
    System.out.println("Sorted Array");
    for(int i = 0; i< numbers.length; i++)
      System.out.print(numbers[i] + " ");
  }
  
  public static void sort( int [] numbers)
  {
     int RUN = 32;
     for(int i = 0; i< numbers.length; i+= RUN)
       insertionSort(numbers, i, Math.min((i+31),(numbers.length -1)));
     
     for(int len = RUN; len < numbers.length; len = 2*len)
     {
       for(int left = 0; left < numbers.length; left += 2*len)
       {
         int mid = left + len -1;
         int right = Math.min((left + 2*len -1), (numbers.length-1));
         merge( numbers, left, mid, right);
       }
     }
  }
    
  public static void insertionSort(int [] numbers, int start, int end)
  {
    for(int i = start+1; i<= end ; i++)
    {
       int temp = numbers[i];
       int j = i-1;
       while(j >= start)
       {
          if(numbers[j] > temp)
          { 
            numbers[j+1] = numbers[j];
            j--;
          }
          else
            break;
       }
       numbers[j+1] = temp;
    }
  }
  
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
