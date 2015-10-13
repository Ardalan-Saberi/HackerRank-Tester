package hr.challenges.java1darray2;


import java.util.Scanner;

public class Solution {

	private static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T;
        
        if (sc.hasNextInt()){
        	T = sc.nextInt();
        	
        	for (int i=0; i< T; i++){
        		int trailLength = sc.nextInt();
        		m = sc.nextInt();
        		int[] trail = new int [trailLength];
        		
        		//trail[0]=0;
        		
        		for (int j=0; j< trailLength; j++){
        			trail[j] = sc.nextInt();
        		}
        		boolean b = hop(0, trail);
        		System.out.println(( b ? "YES": "NO"));
        	}
        }
        	
	}
	
	public static boolean hop(int i, int[] t){
		if (i >= t.length)
			return true;
		
		if(i<0)
			return false;
		
		if (t[i] != 0)
			return false;
		
		t[i] = 2;
		
		return (hop(i + 1 , t.clone()) || hop(i + m , t.clone()) || hop(i - 1 , t.clone())); 
		
	}
}
