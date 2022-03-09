package com.example.mvpcounter;

import android.widget.TextView;
import android.widget.Toast;

public class CounterPresenter implements presentercontracter.CounterPresenter{
presentercontracter.CounterView counterView;
CounterModel counterModel;

    public CounterPresenter(){
    counterModel = new CounterModel();

    }

    @Override
    public void increment() {
counterModel.increment();
counterView.updateCounter(counterModel.getCount());



    }

    @Override
    public void decrement() {
counterModel.decrement();
counterView.updateCounter(counterModel.getCount());
    }



    @Override
    public void attachView(presentercontracter.CounterView counterView) {
        this.counterView = counterView;

    }
}
