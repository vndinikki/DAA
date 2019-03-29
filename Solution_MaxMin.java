//The Max-Min Problem in algorithm analysis is finding the maximum and minimum value in an array
//Divide and Conquer approach

import java.util.*;
import java.io.*;

class MaxMin
{
  int max;
  int min;
  MaxMin(){}
}

public class Solution_MaxMin
{
 
 public static void main(String [] args)
 {
   Scanner sc = new Scanner(System.in);
   int size = sc.nextInt();
   int [] numbers = new int[size];
   for (int i = 0; i< size; i++)
   {
     numbers[i] = sc.nextInt();
   }
   MaxMin ans = new MaxMin();
   ans = find(0, size-1, numbers);
   System.out.println("MAX: " + ans.max);
   System.out.println("MIN: " + ans.min);
 }
 
 //Divide and Conquer to find max_min
 public static MaxMin find(int low,int high, int [] numbers)
 {
   MaxMin sol = new MaxMin();
   MaxMin sol1 = new MaxMin();
   MaxMin sol2 = new MaxMin();
   if ( (high - low) <= 1){
      sol.max = find_max(numbers[low], numbers[high]);
      sol.min = find_min(numbers[low], numbers[high]);
      return sol;
    }
   else{
      sol1 = find(low, (low+high)/2 , numbers);
      sol2 = find((low+high)/2 , high , numbers);
    }
   sol.max = find_max(sol1.max, sol2.max);
   sol.min = find_min(sol1.min, sol2.min);
   return sol;
 }
 
 //MAX function
 public static int find_max(int a, int b)
 {
   if(a>=b)
     return a;
   else
     return b;
 }
 
 //Min function
 public static int find_min(int a , int b)
 {
   if(a>=b)
     return b;
   else
     return a;
 }
 
}
