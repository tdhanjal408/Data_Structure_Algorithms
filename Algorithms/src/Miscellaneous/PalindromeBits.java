package Miscellaneous;


import java.io.*;  
import java.util.*;  
  
  
class PalindromeBits {  
     /** A routine to define whether a given integer number is a palindrome in binary representation  
     * For example  
     *  0 = 0b - true  
     *  5 = 101b - true  
     *  4 = 100b - false  
     * @param input an integer, can assume it's non-negative  
     **/    
  // 5 - 101
  
    static boolean isPalindrome(int input) { 
      
      StringBuilder sb = new StringBuilder();
      
      while(input>0){
        sb.append(input%2);
        input=input/2;
      }

            
      int j = sb.toString().length()-1;
      for(int i =0;i<sb.toString().length()/2;i++){
          if(sb.toString().charAt(i)!=sb.toString().charAt(j)) return false;
          j--;
      }  
      
      return true; //put your implementation here
    }    
    
  
    static boolean isPalindromePrim(int input) { 
     
      int divisor=1;
      int modDivisor =1;   
      int digit=0;
      
      while(input>0){
        digit=divisor*(input%2) + digit;
        input=input/2;
        divisor = divisor*10;
      }
      
      divisor=divisor/10; 
      int val = digit;
      
      while(divisor>=modDivisor){
        if((val/divisor)%10!=(val/modDivisor)%10) return false;   
        divisor=divisor/10;
        modDivisor= modDivisor*10;
      }  
      
      //  11011  divisor=10000  ((11011)/divisor)%10 =1   modDivisor=1  ((11011)/modDivisor)%10 =1  
      //  11011  divisor=1000  ((11011)/divisor)%10 =1   modDivisor=10  ((11011)/modDivisor)%10 =1
      //  While condition fails and output will be true;
      
      return true; //put your implementation here
    }    
    
  public static void main(String[] args) { 
   // Solution s = new Solution();
    System.out.println(PalindromeBits.isPalindromePrim(5));
    //assert isPalindrome(5);
    //assert !isPalindrome(11);
    //assert !isPalindrome(4);  
  }  
}  
