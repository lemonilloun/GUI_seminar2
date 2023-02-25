package org.example;

public class Fibonachi {

    long n;

    public Fibonachi(long n) {
        this.n = n;
    }
    long fs = 0;
    long mid = 1;
    long ls = 1;

    public void fibs(){
        while (ls < n){
            fs = mid;
            mid = ls;
            ls += fs;
        }
        if(ls == n){
            System.out.println("Fibonacci numb");
        }else{
            System.out.println("No Fibonacci here");
        }
    }


}
