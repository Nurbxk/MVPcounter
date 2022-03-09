package com.example.mvpcounter;

public class presentercontracter  {
    interface CounterView{
void updateCounter(int counter);
        void showToast();
        void changeTextColor();
    }
    interface CounterPresenter{
        void increment();
        void decrement();
        void checkConditionForToast();
        void checkConditionForTextColor();
        void attachView(CounterView counterView);
    }
}
