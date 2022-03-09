package com.example.mvpcounter;


public class CounterModel {
 public int count = 0;
    public int getCount() {
        return count;
    }

    public void increment(){
    ++count;


}

    public void decrement(){
        --count;
    }
}
