package com.trodev.careermatcherpro.advice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class AdviceAdapter extends RecyclerView.Adapter<AdviceAdapter.MyViewHolder> {

    ArrayList<AdviceModel> list;;
    Context context;

    public AdviceAdapter(ArrayList<AdviceModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.advice_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AdviceModel adviceModel = list.get(position);

        holder.adviceTv.setText(adviceModel.getAdvice());
        holder.writerTv.setText(adviceModel.getWriter());
        holder.dateTv.setText(adviceModel.getDate());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView adviceTv, writerTv, dateTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            adviceTv = itemView.findViewById(R.id.adviceTv);
            writerTv = itemView.findViewById(R.id.writerTv);
            dateTv = itemView.findViewById(R.id.dateTv);

        }
    }
}
