//Binary Insertion Sort O(logn)
//using array lib:: https://www.geeksforgeeks.org/binary-insertion-sort/



import java.util.Scanner;

public class Solution_BinaryInsertionSort
{

 public static void main(String [] args)
 {
   Scanner sc = new Scanner(System.in);
   int size = sc.nextInt();
   int [] ar = new int[size];
   
   for(int i = 0 ; i< size; i++)
       ar[i] = sc.nextInt();
       
   Sort(ar);
   print(ar);
 } 
 
 public static void print(int [] ar)
 {
    System.out.println("Sorted Array");
    for(int i = 0; i< ar.length ; i++)
        System.out.print(ar[i] + " ");
 }
 
 public static void Sort(int [] ar)
 {
   for(int i =1; i< ar.length; ++i)
   {
     int j = i -1;
     int elem = ar[i];
     int index = binarySearch( ar, elem, 0 ,j);
     while (j >= index)
     {
         ar[j+1] = ar[j];
         j--;
     }
     ar[j+1] = elem;
   }
  }
  
  public static int binarySearch(int [] ar, int elem, int low, int high)
  {
    if(high <= low)
       return ( elem > ar[low])? (low+1):low;
       
    int mid  = (low+high)/2;
    
    if(elem == ar[mid])
      return mid+1;
      
    if(elem > ar[mid])
      return binarySearch(ar,elem, mid+1, high);
      
    return binarySearch(ar, elem, low, mid-1);
  }
}
    
     
   


   
