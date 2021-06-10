//Java Exception Handling- 1 Problem
//Question Link:https://www.hackerrank.com/challenges/java-exception-handling-try-catch/problem

import java.util.*;


public class tryCatchDemo {

    public static void main(String[] args) {
        try
        {
            Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=a/b;
            System.out.println(c);
        }
        catch (InputMismatchException e)
        {
            System.out.println("java.util.InputMismatchException"); 
        }
        catch(ArithmeticException e)
        {
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
