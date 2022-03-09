package com.example.mvpcounter;

public class presentercontracter  {
    interface CounterView{
void updateCounter(int counter);
    }
    interface CounterPresenter{
        void increment();
        void decrement();
        void attachView(CounterView counterView);
    }
}
