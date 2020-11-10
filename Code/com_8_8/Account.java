package com_8_8;

abstract public class Account {
	private String id;
	private double balance;
	private static double total;
	
	protected Account(Date date,String id) {
		this.id=id;
		this.balance=0;
		date.show();
		System.out.println("\t#"+id+" created");
	}
	protected void record(Date date,double amount,String desc) {
		amount =Math.floor(amount*100+0.5)/100;
		balance+=amount;
		total+=amount;
		date.show();
		System.out.println("\t#"+id+"\t"+amount+"\t"+balance+"\t"+desc);
	}
	protected void error(String msg) {
		System.out.println("Error(#"+id+"): "+msg);
	}
	public String getId() {
		return this.id;
	}
	public double getBalance() {
		return this.balance;
	}
	public static double getTotal() {
		return total;
	}
	public void show() {
		System.out.print(id+"\tBalance: "+balance);
	}
	abstract public void deposit(Date date,double amount,String desc);
	abstract public void withdraw(Date date,double amount,String desc);
	abstract public void settle(Date date);
}