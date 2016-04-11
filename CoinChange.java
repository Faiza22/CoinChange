/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

import static java.sql.Types.NULL;
import java.util.Scanner;

/**
 *
 * @author ELEGANT
 */
public class CoinChange {

    /**
     * @param args the command line arguments
     */
    static int count=0;
    
    public static void main(String[] args) {
        int amount=0, no_of_coins, no_of_coins2;
        int d[] = {1, 5, 10, 25};   //array of denominations
        
        System.out.println("Enter the amount for which change is required: ");
        Scanner s = new Scanner(System.in);
        amount = s.nextInt();
        if(amount<1)    //amount should be greater than 0
            System.out.println("Enter a valid amount greater than 0");
        else
        {
            no_of_coins = greedy(amount);   //get no. of coins from greedy algorithm
            System.out.println("No. of coins used by greedy algorithm: " + no_of_coins);
            
            no_of_coins2 = dynamic(amount, d);    //get no. of coins from dynamic programming
            System.out.println("No. of coins used by dynamic programming: " + no_of_coins2);
        }
    }
    
    public static int greedy(int amount)
    {
        if(amount==0)   //base case
            return count;
        else
        {
            //pick up the largest coin available for the given amount
            if(amount>=25){
                amount-=25;
                count++;
            }
            else if(amount>=10){
                amount-=10;
                count++;
            }
            else if(amount>=5){
                amount-=5;
                count++;
            }
            else if(amount>=1){
                amount-=1;
                count++;
            }
            greedy(amount);     //recursively call the function on the decreased amount
            return count;
        }
    }
    
    public static int dynamic(int n, int[] C)
    {
        int M[]=new int[n+1];   //using array for memoization
        int min;
        if(n==0)    //base case
            return 0;
        else if (M[n]==NULL)    
        {
            min=Integer.MAX_VALUE;  //initially set min to infinity
            for(int i=0; i<=3; i++)
                if(C[i]<=n && 1+dynamic(n-C[i],C)<min)
                    min = 1+dynamic(n-C[i],C);  //recursive call

            M[n]=min; 
        }
        return M[n];
    }
}
