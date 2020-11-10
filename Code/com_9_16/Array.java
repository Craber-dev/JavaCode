package com_9_16;

public class Array<T> {
    private T[] list;
    private int size=50;

    public Array(int sz) {
        if(sz<0) {
            System.exit(1);
        }
        size=sz;
        list=(T[])new Object [size];
    }
    public Array(Array<T> a) {
        this.size=a.getSize();
        this.list=(T[])new Object[a.getSize()];
        for(int i=0;i<a.getSize();i++) {
            list[i]=a.getList(i);
        }
    }
    public int getSize() {
        return this.size;
    }
    public T getList(int i) {
        return this.list[i];
    }
    public Array<T> equal(Array<T> rhs){
        if(rhs!=this) {
            if(size != rhs.getSize()) {
                this.size=rhs.getSize();
                this.list=(T[])new Object[this.size];
            }
            for(int i=0;i<this.size;i++) {
                this.list[i]=rhs.getList(i);
            }
        }
        return this;
    }
    public void change(T a,int i){
        list[i]=a;
    }
    public T bracket(int n){
        if(n<0||n>=this.size) {
            System.exit(1);
        }
        return this.getList(n);
    }
    public void resize(int sz) {
        if(sz<0) {
            System.exit(1);
        }
        if(sz==this.size) {
            return;
        }else {
            T[] newList=(T[])new Object[sz];
            int n=(sz<this.size)? sz:this.size;
            for(int i=0;i<n;i++) {
                newList[i]=this.getList(i);
            }
            this.list=newList;
            this.size=sz;
        }
    }
}
