package com.trodev.careermatcherpro.payment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.R;

import java.util.ArrayList;


public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.MyViewHolder>{

    Context context;
    ArrayList<PackageModel> list;
    String category;

    public PackageAdapter(Context context, ArrayList<PackageModel> list, String category) {
        this.context = context;
        this.list = list;
        this.category = category;
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

        holder.nameTv.setText("Name: "+model.getName());
        holder.emailTv.setText(model.getEmail());
        holder.mobileTv.setText(model.getPhone());
        holder.paymentTv.setText(model.getPayments());
        holder.packageTv.setText(model.getPackages());
        holder.statusTv.setText(model.getStatus());
        holder.dateTv.setText(model.getDate() +" & "+ model.getTime());

        // ##########################################################################
        /*status color*/
        String status = holder.statusTv.getText().toString();
        if (status.equals("pending")) {
            holder.statusTv.setTextColor(Color.parseColor("#F44336"));
        } else if (status.equals("confirmed order")) {
            // holder.statusTv.getResources().getColor(R.color.app_color);
            holder.statusTv.setTextColor(Color.parseColor("#008937"));
        }

        /*#########################################################################*/
        /*package color code*/

        String basic = "Basic";
        String gold = "Gold";
        String platinum = "Platinum";
        String master = "Master";
        String packages = holder.packageTv.getText().toString().trim();

        if (packages.equals(basic)) {
            holder.packageTv.setTextColor(Color.parseColor("#0027B6"));
        } else if (packages.equals(gold)) {
            holder.packageTv.setTextColor(Color.parseColor("#FFC107"));
        } else if (packages.equals(platinum)) {
            holder.packageTv.setTextColor(Color.parseColor("#F100A1"));
        } else if (packages.equals(master)) {
            holder.packageTv.setTextColor(Color.parseColor("#FF1100"));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv, emailTv, mobileTv, paymentTv, transactionTv, packageTv, statusTv, dateTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTv);
            emailTv = itemView.findViewById(R.id.emailTv);
            mobileTv = itemView.findViewById(R.id.mobileTv);
            paymentTv = itemView.findViewById(R.id.paymentTv);
            transactionTv = itemView.findViewById(R.id.transactionTv);
            packageTv = itemView.findViewById(R.id.packageTv);
            statusTv = itemView.findViewById(R.id.statusTv);
            dateTv = itemView.findViewById(R.id.dateTv);

        }
    }
}
