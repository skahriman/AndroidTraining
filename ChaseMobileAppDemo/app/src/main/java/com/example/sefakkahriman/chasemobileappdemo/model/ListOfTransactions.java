package com.example.sefakkahriman.chasemobileappdemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListOfTransactions {

    List<Transaction> list = new ArrayList<>();

    double balance;

    public ListOfTransactions(){
        addTransaction();
    }

    Transaction t1 = new Transaction("Walmart", 10.00, "01/01/2018", balance);
    Transaction t2 = new Transaction("Walmart", 11.00, "01/02/2018", balance);
    Transaction t3 = new Transaction("Walmart", 12.00, "01/03/2018", balance);
    Transaction t4 = new Transaction("Walmart", 13.00, "01/04/2018", balance);
    Transaction t5 = new Transaction("Walmart", 14.00, "01/05/2018", balance);
    Transaction t6 = new Transaction("Walmart", 15.00, "01/06/2018", balance);
    Transaction t7 = new Transaction("Walmart", 16.00, "01/08/2018", balance);
    Transaction t8 = new Transaction("Walmart", 17.00, "01/09/2018", balance);
    Transaction t9 = new Transaction("Walmart", 18.00, "01/10/2018", balance);
    Transaction t10 = new Transaction("Walmart", 19.00, "01/11/2018", balance);
    Transaction t11 = new Transaction("Walmart", 20.00, "01/12/2018", balance);
    Transaction t12 = new Transaction("Walmart", 21.00, "01/13/2018", balance);
    Transaction t13 = new Transaction("Walmart", 22.00, "01/14/2018", balance);
    Transaction t14 = new Transaction("Walmart", 23.00, "01/15/2018", balance);
    Transaction t15 = new Transaction("Walmart", 24.00, "01/16/2018", balance);
    Transaction t16 = new Transaction("Walmart", 25.00, "01/17/2018", balance);
    Transaction t17 = new Transaction("Walmart", 25.00, "01/18/2018", balance);
    Transaction t18 = new Transaction("Walmart", 25.00, "01/19/2018", balance);
    Transaction t19 = new Transaction("Walmart", 25.00, "01/20/2018", balance);
    Transaction t20 = new Transaction("Walmart", 5.00, "01/21/2018", balance);

    public void makeTransaction(Transaction t){
        User.balance = User.balance - t.getAmount();
        t.setBalance(User.balance);
        this.list.add(t);
    }

    public void addTransaction(){
        makeTransaction(t1);makeTransaction(t2);makeTransaction(t3);makeTransaction(t4);makeTransaction(t5);
        makeTransaction(t6);makeTransaction(t7);makeTransaction(t8);makeTransaction(t9);makeTransaction(t10);
        makeTransaction(t11);makeTransaction(t12);makeTransaction(t13);makeTransaction(t14);makeTransaction(t15);
        makeTransaction(t16);makeTransaction(t17);makeTransaction(t18);makeTransaction(t19);makeTransaction(t20);

    }

    public List<Transaction> getList(){
        return this.list;
    }

//    public static void main(String[] args) {
//        ListOfTransactions myList = new ListOfTransactions();
//        myList.addTransaction();
//        for (Transaction t : myList.getList()) {
//            System.out.println(t.toString());
//        }
//    }


}
