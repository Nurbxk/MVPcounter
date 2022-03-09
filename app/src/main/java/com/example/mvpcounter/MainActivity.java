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
        });



        binding.increment.setOnClickListener(v -> {
            counterPresenter.increment();
        });
        }

    @Override
    public void updateCounter(int counter) {
        binding.tvCounter.setText(String.valueOf(counter));
            if(counter == 5){
                Toast.makeText(getApplicationContext(), "You reached 5th level", Toast.LENGTH_SHORT).show();
            }
            else if (counter == 10){
                binding.tvCounter.setTextColor(Color.BLACK);
            }
    }
}