package com.trodev.careermatcherpro.bcs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.trodev.careermatcherpro.activity.FullQuestionAnswerActivity;
import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class BCSAdapter extends RecyclerView.Adapter<BCSAdapter.MyViewHolder> {
    ArrayList<BCSModel> list;
    Context context;

    public BCSAdapter(ArrayList<BCSModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bcs_item_layout, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        BCSModel bcsModel = list.get(position);

        holder.detailsTv.setText(bcsModel.getPdfTitle() + " তম বিসিএস প্রশ্ন ও সমাধান");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FullQuestionAnswerActivity.class);
                intent.putExtra("pdfUrl", bcsModel.getPdfUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

        /*animation view with slider*/
        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slider));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView detailsTv;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            detailsTv = itemView.findViewById(R.id.detailsTv);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
