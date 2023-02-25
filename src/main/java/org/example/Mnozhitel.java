package org.example;

import java.sql.SQLOutput;
import java.util.*;

public class Mnozhitel {
    private Set<Integer> multis = new LinkedHashSet<>();
    Scanner sc = new Scanner(System.in);
    private int i = 1;
    private int num;
    public void multipliers(){
        try {
            System.out.print("Ввести натуральное число: ");
            num = sc.nextInt();
            if (num <= 0){
                throw new RuntimeException("Natural integers only");
            } else if (num == 1) {
                multis.add(1);
            }else{
                while (num > 0){
                    if(num % i == 0){
                        multis.add(i);
                        if (num % (num / i) == 0){
                            multis.add(num / i);
                        }
                    }
                    num /= i;
                    i++;
                }
            }
            System.out.println(multis);


        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
