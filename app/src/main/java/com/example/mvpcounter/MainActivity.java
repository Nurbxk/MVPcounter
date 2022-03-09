package com.example.mvpcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvpcounter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements presentercontracter.CounterView{
ActivityMainBinding binding;
CounterPresenter counterPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        counterPresenter = Injector.getPresenter();
        counterPresenter.attachView(this);
initclickers();
    }

    private void initclickers() {
        binding.decrement.setOnClickListener(v -> {
        counterPresenter.decrement();
            counterPresenter.checkConditionForTextColor();
            counterPresenter.checkConditionForToast();
        });



        binding.increment.setOnClickListener(v -> {
            counterPresenter.increment();
            counterPresenter.checkConditionForTextColor();
            counterPresenter.checkConditionForToast();
        });
        }


    @Override
    public void updateCounter(int counter) {
        binding.tvCounter.setText(String.valueOf(counter));
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "You reached 10th level", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeTextColor() {
        binding.tvCounter.setTextColor(Color.rgb(40,0,0));
    }
}