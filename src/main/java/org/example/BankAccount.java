package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    private Scanner sc = new Scanner(System.in);
    private String user;
    private Cell user_cell; // основная ячейка
    private List<Cell> users_account = new ArrayList<>();
    /* Список - банковские ячейки (счета) одного пользователя банка
        0 индекс - user_account[0] - стартовая ячейка
    */

    public BankAccount(String user, Cell user_cell) {
        try {
            if (user == user_cell.getOwner()) {
                this.user = user;
                this.user_cell = user_cell;
                users_account.add(user_cell);
            }else{throw new RuntimeException("Unidentified user cell");}
        } catch (Exception e){
            System.out.println(e);
        }


    }

    public void newCell(double money){
        Cell newcomer = new Cell(money, user);
        users_account.add(newcomer);
    }

    public void merging_cells(){
        try {
            System.out.println("Текущий счет: ");
            info(user_cell);
            System.out.println("Выберете ячейку: ");
            for (int i = 1; i < users_account.size(); i++){
                System.out.println("--------------------------------------");
                System.out.print(i + " - "); info(users_account.get(i));
            }

            int choice = sc.nextInt();
            if (choice > users_account.size() - 1 | choice < 0){throw new RuntimeException("incorrect index of cells");}
            double curBalance = user_cell.getBalance();
            double pickedCell = users_account.get(choice).getBalance();
            user_cell.setBalance(curBalance + pickedCell);
            users_account.remove(choice);
            users_account.get(0).setBalance(user_cell.getBalance());
            System.out.println("Текущая информация о счетах: ");
            System.out.println("--------------------------------------");
            for (Cell x: users_account){
                info(x);
                System.out.println("--------------------------------------");

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void sendCash(BankAccount toUser){
        try {
            System.out.println("Выберете ячейку для перевода:");
            for (int i = 0; i < users_account.size(); i++){
                System.out.println("--------------------------------------");
                System.out.print(i + " - "); info(users_account.get(i));
            }
            int cel = sc.nextInt();
            if (cel > users_account.size() - 1 | cel < 0){throw new RuntimeException("incorrect index of cells");}
            System.out.println("Сумма для перевода (формата 1.0 ):");
            double sUser = sc.nextDouble();
            sUser = Math.abs(sUser);
            if (sUser <= users_account.get(cel).getBalance()){
                double prevBalance = toUser.getUser_cell().getBalance();
                toUser.setUser_cell(prevBalance + sUser);
                users_account.get(cel).setBalance(users_account.get(cel).getBalance() - sUser);
                user_cell = users_account.get(0);
                System.out.println("Текущий баланс счета после операции: ");
                info(users_account.get(cel));
            } else {throw new RuntimeException("Not enough money");}
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    private void info(Cell x) {
        System.out.print("Владелец: " + x.getOwner() + "\n");
        System.out.print("Валюта: " + x.getCurrency() + "\n");
        System.out.print("Баланс: " + x.getBalance() + "\n");
    }

    public Cell getUser_cell() {
        return user_cell;
    }

    public void setUser_cell(double cash) {
        this.user_cell.setBalance(cash);
    }
}
