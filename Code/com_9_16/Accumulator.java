package com_9_16;

public class Accumulator {
    private Date lastDate;
    private double value;
    private double sum;

    public Accumulator(Date date, double value) {
        this.lastDate=date;
        this.value=value;
        this.sum=0;
    }
    public double getSum(Date date) {
        return sum+value*date.distance(lastDate);
    }
    public void change(Date date, double value) {
        sum=getSum(date);
        lastDate=date;
        this.value=value;
    }
    public void reset(Date date, double value) {
        lastDate=date;
        this.value=value;
        sum=0;
    }
}
