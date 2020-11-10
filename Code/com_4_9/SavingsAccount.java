package com_4_9;

public class SavingsAccount {//储蓄账户类

    private int id;				//账号
    private double balance;		//余额
    private double rate;		//存款的年利率
    private int lastDate;		//上次变更余额的时期
    private double accumulation;

    private void record(int date, double amount){
        accumulation = accumulate(date);
        lastDate = date;
        amount = Math.floor(amount * 100 + 0.5) / 100;	//保留小数点后两位
        balance += amount;
        System.out.println(date+"\t#"+id+"\t"+amount+"\t"+balance);
    }
    private double accumulate(int date){
        return accumulation + balance * (date - lastDate);
    }
    public SavingsAccount(int date, int id, double rate){
        this.id=id;
        this.accumulation=0;
        this.balance=0;
        this.rate=rate;
        this.lastDate=date;
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
    public void deposit(int date, double amount){
        record(date, amount);
    }
    public void withdraw(int date, double amount){
        if (amount > getBalance())
            System.out.println("Error: not enough money");
        else
            record(date, -amount);
    }
    public void settle(int date){
        double interest = accumulate(date) * rate / 365;	//计算年息
        if (interest != 0)
            record(date, interest);
        accumulation = 0;
    }
    public void show(){
        System.out.println("#" + id + "\tBalance: " + balance);
    }
}
