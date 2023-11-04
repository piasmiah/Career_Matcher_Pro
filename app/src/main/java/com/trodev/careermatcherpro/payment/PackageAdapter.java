package com.trodev.careermatcherpro.payment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.R;

import java.util.ArrayList;


public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<PackageModel> list;
    public PackageAdapter(ArrayList<PackageModel> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public PackageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.package_by_item, parent, false);
        return  new PackageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackageAdapter.MyViewHolder holder, int position) {
        PackageModel model = list.get(position);
        holder.nameTv.setText(model.getName());
        holder.emailTv.setText(model.getEmail());
        holder.mobileTv.setText(model.getPhone());
        holder.paymentTv.setText(model.getPayments());
        holder.packageTv.setText(model.getPackages());
        holder.statusTv.setText(model.getStatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv, emailTv, mobileTv, paymentTv, transactionTv, packageTv, statusTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            emailTv = itemView.findViewById(R.id.emailTv);
            mobileTv = itemView.findViewById(R.id.mobileTv);
            paymentTv = itemView.findViewById(R.id.paymentTv);
            transactionTv = itemView.findViewById(R.id.transactionTv);
            packageTv = itemView.findViewById(R.id.packageTv);
            statusTv = itemView.findViewById(R.id.statusTv);
        }
    }
}
