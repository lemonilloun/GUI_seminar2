package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Mnozhitel mn = new Mnozhitel();

    Prisma prisma = new Prisma(4.0,4.0,3.0,2.0);

    Fibonachi fibonachi = new Fibonachi(132);
    // стартовые счета каждого пользователя, при создании аккаунта
    Cell client1Cel1 = new Cell(2007.0, "Alex");
    Cell client2Cel1 = new Cell(1234.0, "Tom");
    // создание аккаунтов пользователей
    BankAccount user1 = new BankAccount("Alex", client1Cel1);
    BankAccount user2 = new BankAccount("Tom", client2Cel1);

    Scanner sc = new Scanner(System.in);
    System.out.print("Задание: ");int choise = sc.nextInt();

    switch (choise){
        case 1:
            mn.multipliers();
            break;
        case 2:
            prisma.surf_are();
            prisma.volume();
            break;
        case 3:
            System.out.println("Объединение счетов");
            user1.newCell(1005.0);
            user1.merging_cells(); // объединение двух счетов одного пользователя

            // перевод с одного счета на другой (любой)
            System.out.println("Перевод с одного счета на другой");
            user1.newCell(23000.01);
            user2.newCell(35.35);

            user1.sendCash(user2);

            break;
        case 4:
            fibonachi.fibs();
            break;


    }



    }
}