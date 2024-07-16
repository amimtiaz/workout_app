package com.imtiaz_acedamy.workoutapp.Activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.imtiaz_acedamy.workoutapp.Adapter.WorkoutAdapter;
import com.imtiaz_acedamy.workoutapp.Domain.Lession;
import com.imtiaz_acedamy.workoutapp.Domain.Workout;
import com.imtiaz_acedamy.workoutapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        binding.view1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.view1.setAdapter(new WorkoutAdapter(getData()));


    }

    private ArrayList<Workout> getData() {
        ArrayList<Workout> list = new ArrayList<>();

        list.add(new Workout("Yoga", "Relaxing and strengthening yoga poses", "pic_1", 150, "60 minutes", getLession_1()));
        list.add(new Workout("Running", "Outdoor running exercise", "pic_2", 300, "45 minutes", getLession_2()));
        list.add(new Workout("Cycling", "Indoor cycling workout", "pic_3", 250, "60 minutes", getLession_3()));

        return list;

    }


    private ArrayList<Lession> getLession_1() {
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lesson 1", "03:46", "HBPMvFkpNgE", "pic_1_1"));
        list.add(new Lession("Lesson 2", "03:41", "K6124WgiiPw", "pic_1_2"));
        list.add(new Lession("Lesson 3", "01:57", "Zc08v4YYOeA", "pic_1_3"));

        return list;
    }

    private ArrayList<Lession> getLession_2() {
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lesson 1", "20:23", "L3eImBAXT71", "pic_3_1"));
        list.add(new Lession("Lesson 2", "18:27", "47Exgz07FLU", "pic_3_2"));
        list.add(new Lession("Lesson 3","32:25","OnLx8tmaQ-4", "pic_3_3"));
        list.add(new Lession("Lesson 3","32:25","OnLx8tmaQ-4", "pic_3_4"));
        return list;
    }

    private ArrayList<Lession> getLession_3() {
        ArrayList<Lession> list = new ArrayList<>();
        list.add(new Lession("Lesson 1", "23:00", "v7AYKMP6г0E", "pic_3_1"));
        list.add(new Lession("Lesson 2", "27:00", "Em12xnoLpYE", "pic_3_2"));
        list.add(new Lession("Lesson 3", "25:00", "v7SN-d4qXx0", "pic_3_3"));
        list.add(new Lession("Lesson 4", "21:00", "LqXZ628YNj4", "pic_3_4"));
        return list;

        }

    }