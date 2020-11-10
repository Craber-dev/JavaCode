package com_8_8;

public class Date {
	private int year;
	private int month;
	private int day;
	private int totalDays;
	final public int  DAYS_BEFORE_MONTH[] = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
	
	public Date(int year,int month,int day) {
		this.day=day;
		this.year=year;
		this.month=month;
		if(day<=0||day>getMaxDay()) {
			System.out.println("Invalid date: ");
			show();
			System.out.println();
			System.exit(1);
		}
		int years = year - 1;
		totalDays = years * 365 + years / 4 - years / 100 + years / 400
			+ DAYS_BEFORE_MONTH[month - 1] + day;
		if (isLeapYear() && month > 2) totalDays++;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getMaxDay() {
		if(isLeapYear()&&month==2) {
			return 29;
		}else {
			if(month>0) {
				return DAYS_BEFORE_MONTH[month]-DAYS_BEFORE_MONTH[month-1];
			}else {
				return 0;
			}
		}
	}
	public boolean isLeapYear() {
		return ((year%4==0)&&(year%100!=0||year%400==0));
	}
	public void show() {
		System.out.print(getYear()+"-"+getMonth()+"-"+getDay());
	}
	public int distance(Date date) {
		return totalDays-date.totalDays;
	}
}