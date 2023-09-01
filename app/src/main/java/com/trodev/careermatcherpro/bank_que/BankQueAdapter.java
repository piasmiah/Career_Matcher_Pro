package com.trodev.careermatcherpro.bank_que;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.trodev.careermatcherpro.FullQuestionAnswerActivity;
import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class BankQueAdapter extends RecyclerView.Adapter<BankQueAdapter.MyViewHolder> {

    ArrayList<BankQueModel> list;
    Context context;

    public BankQueAdapter(ArrayList<BankQueModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.bank_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        BankQueModel bcsModel = list.get(position);

        holder.detailsTv.setText(bcsModel.getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FullQuestionAnswerActivity.class);
                intent.putExtra("pdfUrl", bcsModel.getPdfUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView detailsTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            detailsTv = itemView.findViewById(R.id.detailsTv);
        }
    }
}
