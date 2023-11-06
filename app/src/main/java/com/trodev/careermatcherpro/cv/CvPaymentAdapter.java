package com.trodev.careermatcherpro.cv;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class CvPaymentAdapter extends RecyclerView.Adapter<CvPaymentAdapter.MyViewHolder> {
    ArrayList<UserModel> list;
    Context context;

    public CvPaymentAdapter(ArrayList<UserModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cv_payment_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        UserModel model = list.get(position);

        holder.nameTv.setText(model.getName());
        holder.emailTv.setText(model.getGmail());
        holder.phoneTv.setText("+88" + model.getMobile());
        holder.paymentTv.setText(model.getPayment_method());
        holder.transactionTv.setText(model.getTransaction_id());
        holder.statusTv.setText(model.getStatus());

        String status = holder.statusTv.getText().toString();

        if (status.equals("unapproved")) {
            holder.statusTv.setTextColor(Color.parseColor("#F44336"));
        } else if (status.equals("approved")) {
            // holder.statusTv.getResources().getColor(R.color.app_color);
            holder.statusTv.setTextColor(Color.parseColor("#008937"));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv, emailTv, phoneTv, transactionTv, paymentTv, statusTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            emailTv = itemView.findViewById(R.id.emailTv);
            phoneTv = itemView.findViewById(R.id.mobileTv);
            transactionTv = itemView.findViewById(R.id.transactionTv);
            paymentTv = itemView.findViewById(R.id.paymentTv);
            statusTv = itemView.findViewById(R.id.statusTv);

        }
    }
}
