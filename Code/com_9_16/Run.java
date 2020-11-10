package com_9_16;

import java.util.Scanner;
public class Run {
    public static void main(String[] args) {
        Date date=new Date(2008, 11, 1);	//起始日期
        //建立几个账户
        Array<Account> accounts=new Array<Account>(0);
        System.out.print("\"(a)add account (d)deposit (w)withdraw (s)show (c)change day (n)next month (e)exit\"");
        String cmd;
        Scanner input=new Scanner(System.in);
        do {
            //显示日期和总金额
            date.show();
            System.out.print("\tTotal: "+ Account.getTotal()+"\tcommand> ");

            char type;
            int index, day;
            double amount,credit,rate,fee;
            String id,desc;
            Account account;
            cmd=input.next();
            switch (cmd) {
                case "a":
                    type=input.next().charAt(0);
                    id=input.next();
                    if(type=='s'){
                        rate=input.nextDouble();
                        account=new SavingsAccount(date,id,rate);
                    }else{
                        credit=input.nextDouble();
                        rate=input.nextDouble();
                        fee=input.nextDouble();
                        account=new CreditAccount(date,id,credit,rate,fee);
                    }
                    //accounts.getSize();
                    accounts.resize(accounts.getSize()+1);
                    accounts.change(account,accounts.getSize()-1);

                    break;
                case "d":	//存入现金
                    index=input.nextInt();
                    amount=input.nextDouble();
                    desc=input.next();
                    accounts.bracket(index).deposit(date, amount, desc);
                    break;
                case "w":	//取出现金
                    index=input.nextInt();
                    amount=input.nextDouble();
                    desc=input.next();
                    accounts.bracket(index).withdraw(date, amount, desc);
                    break;
                case "s":	//查询各账户信息
                    for (int i = 0; i < accounts.getSize(); i++) {
                        System.out.print("[" + i + "] ");
                        accounts.bracket(i).show();
                        System.out.println();
                    }
                    break;
                case "c":	//改变日期
                    day=input.nextInt();
                    if (day < date.getDay())
                        System.out.print("You cannot specify a previous day");
                    else if (day > date.getMaxDay())
                        System.out.print("Invalid day");
                    else
                        date = new Date(date.getYear(), date.getMonth(), day);
                    break;
                case "n":	//进入下个月
                    if (date.getMonth() == 12)
                        date = new Date(date.getYear() + 1, 1, 1);
                    else
                        date = new Date(date.getYear(), date.getMonth() + 1, 1);
                    for (int i = 0; i < accounts.getSize(); i++)
                        accounts.bracket(i).settle(date);
                    break;
            }
        } while (cmd != "e");
        input.close();
    }
}