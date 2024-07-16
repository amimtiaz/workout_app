package com.imtiaz_acedamy.workoutapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.imtiaz_acedamy.workoutapp.Activity.WorkoutActivity;
import com.imtiaz_acedamy.workoutapp.Domain.Workout;
import com.imtiaz_acedamy.workoutapp.databinding.ViewholderWorkoutBinding;

import java.io.Serializable;
import java.util.ArrayList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {

    private final ArrayList<Workout> list;
    private Context context;

    public WorkoutAdapter(ArrayList<Workout> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public WorkoutAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ViewholderWorkoutBinding  binding = ViewholderWorkoutBinding.inflate(LayoutInflater.from(context), parent, false);

        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutAdapter.ViewHolder holder, int position) {

        holder.binding.titleTxt.setText(list.get(position).getTitle());
        int resId = context.getResources().getIdentifier(list.get(position).getPicPath(), "drawable", context.getPackageName());

        Glide.with(context)
                .load(resId)
                .into(holder.binding.pic);
        holder.binding.excersizeTxt.setText(list.get(position).getLessions().size()+ " Exersices");
        holder.binding.kcalTxt.setText(list.get(position).getKcal() + " Kcal");
        holder.binding.durationTxt.setText(list.get(position).getDurationAll() );

        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, WorkoutActivity.class);
                intent.putExtra("object", String.valueOf(list.get(position)));
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewholderWorkoutBinding binding;
        public ViewHolder(ViewholderWorkoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
