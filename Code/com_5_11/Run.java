package com_5_11;

public class Run {
    public static void main(String[] args){
        SavingsAccount sa0,sa1;
        sa0=new SavingsAccount(1, 21325302, 0.015);
        sa1=new SavingsAccount(1, 58320212, 0.015);

        sa0.deposit(5, 5000);
        sa1.deposit(25, 10000);
        sa0.deposit(45, 5500);
        sa1.withdraw(60, 4000);

        sa0.settle(90);
        sa1.settle(90);

        sa0.show();
        System.out.println();
        sa1.show();
        System.out.println();
        System.out.println("Total: "+SavingsAccount.getTotal());
    }
}
