package com_6_25;

public class SavingsAccount {

    private double balance;
    private String id;
    private double rate;
    private Date lastDate;
    private double accumulation;
    private static double total;
    private static Date newDate;

    private void record(Date date,double amount,String desc) {
        accumulation=accumulate(date);
        lastDate=date;
        amount=Math.floor(amount*100+0.5)/100;
        balance+=amount;
        total+=amount;
        date.show();
        System.out.println("\t#"+id+"\t"+amount+"\t"+balance+"\t"+desc);
    }
    private void error(String msg) {
        System.out.println("Error(#"+id+"):"+msg);
    }
    private double accumulate(Date date) {
        return accumulation+balance*date.distance(lastDate);
    }
    public SavingsAccount(Date date,String id,double rate) {
        this.id=id;
        this.rate=rate;
        this.lastDate=date;
        this.accumulation=0;
        newDate=new Date(1,1,1);
        date.show();
        System.out.println("\t#"+id+" created");
    }
    public String getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public double getRate() {
        return rate;
    }
    public static double getTotal() {
        return total;
    }
    public void deposit(Date date,double amount,String desc) {
        record(date,amount,desc);
    }
    public void withdraw(Date date,double amount,String desc) {
        if(amount>getBalance()) {
            error("not enough money");
        }else {
            record(date,-amount,desc);
        }
    }
    public void settle(Date date) {
        Date d=new Date(date.getYear()-1,1,1);
        double interest =accumulate(date)*rate/date.distance(d);
        if(interest!=0) {
            record(date,interest,"interest");
        }
        accumulation=0;
    }
    public void show() {
        System.out.println(id+"\tBalance: "+balance);
    }
}
