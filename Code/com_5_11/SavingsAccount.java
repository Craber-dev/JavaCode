package com_5_11;

public class SavingsAccount {
    private int id;
    private double balance;
    private double rate;
    private int lastDate;
    private double accumulation;
    private static double total;

    private void record(int date,double amount){
        accumulation=accumulate(date);
        lastDate=date;
        amount=Math.floor(amount*100+0.5)/100;
        balance+=amount;
        total+=amount;
        System.out.println(date+"\t#"+id+"\t"+amount+"\t"+balance);
    }
    private double accumulate(int date){
        return accumulation+balance*(date-lastDate);
    }
    public SavingsAccount(int date,int id,double rate){
        this.id=id;
        this.balance=0;
        this.rate=rate;
        this.lastDate=date;
        this.accumulation=0;
        System.out.println(date+"\t#"+id+" id created");
    }
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getRate(){
        return rate;
    }
    public static double getTotal(){
        return total;
    }
    public void deposit(int date,double amount){
        record(date,amount);
    }
    public void withdraw(int date,double amount){
        if(amount>getBalance()){
            System.out.println("Error: not enough money");
        }else{
            record(date,-amount);
        }
    }
    public void settle(int date){
        double interest=accumulate(date)*rate/365;
        if(interest!=0){
            record(date,interest);
        }
        accumulation=0;
    }
    public void show(){
        System.out.println("#"+id+"\tBalance:"+balance);
    }
}
