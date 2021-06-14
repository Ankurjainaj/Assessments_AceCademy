//ArrayList Problem
//Question Link: https://www.hackerrank.com/challenges/java-arraylist/problem

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n,d,q,x,y;
        n=sc.nextInt();
        ArrayList[] arr=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            d=sc.nextInt();
            arr[i]=new ArrayList();
            for(int j=0;j<d;j++)
            {
                arr[i].add(sc.nextInt());
            }
        }
        q=sc.nextInt();
        for(int i=0;i<q;i++)
        {
            x=sc.nextInt();
            y=sc.nextInt();
            try{
                System.out.println(arr[x-1].get(y-1));
            }
            catch(Exception e)
            {
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}
