//Knapsack problem
//Given a set of items with specific weights and values, the aim is to get as much value into the knapsack

import java.util.*;
import java.io.*;

class Knapsack 
{
  int profit;
  int wt;
  int ratio;
  Knapsack(){}
  Knapsack(int profit, int wt, int ratio)
  {
    this.profit = profit;
    this.wt = wt;
    this.ratio = ratio;
  }
}
public class Solution_Knapsack
{
 
  public static void main(String [] args)
  {
     Scanner sc = new Scanner(System.in);
     
     int num = sc.nextInt();
     
     int [] profits = new int[num];
     int [] wts = new int[num];
     int [] ratio = new int[num];
     Knapsack [] knap = new Knapsack[num];
     
     System.out.println("Profits");
     for(int i = 0; i< num; i++)
        profits[i] = sc.nextInt();
     System.out.println("Weights");
     for(int i = 0; i< num ;i++)
        wts[i] = sc.nextInt();
     
     for(int i = 0; i< num; i++){
        ratio[i] = profits[i]/wts[i];
        knap[i] = new Knapsack(profits[i], wts[i], ratio[i]);
     }
     sort(knap, 0, num-1);
     System.out.println("Capacity");
     int max_capacity = 
  }
  
  public static void sort(Knapsack [] knap, int low, int high)
  {
    if(low < high)
    {
       int mid = divide(knap, low, high);
       sort(knap, low, mid-1);
       sort(knap, mid+1, high);
    }
  }
  
  public static int divide(Knapsack [] knap, int low, int high)
  {
    int temp = knap[high].ratio;
    int i = low-1;
    for(int j = low; j< high; j++)
    {
       if(knap[j].ratio <= temp){
         i++;
         swap(knap, i, j);
       }
     }
     swap(knap, i+1, high);
     return i+1;
  }
  
  public static void swap(Knapsack [] knap, int a, int b)
  {
    Knapsack temp = knap[a];
    knap[a] = knap[b];
    knap[b] = temp;
  }
}
        
        
     
     
