Question Link 👇
  https://www.hackerrank.com/contests/algohunt/challenges/maxsubarray


// Solution 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        int T = myScan.nextInt();
        while(T--!=0){
            int N = myScan.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i]=myScan.nextInt();
            }
            int curr_sum=0;
            int best_sum=0;
            int non_cont_sum=0;
            for(int j=0; j<N; j++){
                curr_sum += arr[j];
                if(curr_sum>0){
                    if(curr_sum>best_sum){
                        best_sum=curr_sum;
                    }
                }else{
                    curr_sum=0;
                }
                if(arr[j]>0){
                    non_cont_sum +=arr[j];
                }
            }
            if(best_sum ==0 && non_cont_sum==0){
                int max = arr[0];
                for(int l=1; l<N; l++){
                    if(arr[l]>max){
                        max=arr[l];
                    }
                }
                best_sum=max;
                non_cont_sum=max;
            }
            System.out.print(best_sum+" "+non_cont_sum);
            System.out.println();
        }
    }
}


