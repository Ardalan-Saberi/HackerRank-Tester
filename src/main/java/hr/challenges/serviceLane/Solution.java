package hr.challenges.serviceLane;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t, n;
        
        n = in.nextInt();
        t = in.nextInt();
        
        int[] serviceLane = new int[n];
        
        for (int i=0;i<n;i++) {
            serviceLane[i] = in.nextInt();
        
        }
        
        for (int i=0;i<t;i++) {
            int entry = in.nextInt();
            int exit = in.nextInt();
            int maxCarWidth = 3;
            
            for (int j = entry; j <= exit; j++){
                if (serviceLane[j] < maxCarWidth){
                    maxCarWidth = serviceLane[j];
                }
            }
            
            System.out.println(maxCarWidth);
        }
    }
}