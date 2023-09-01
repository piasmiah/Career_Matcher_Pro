package com.trodev.careermatcherpro.premium_pdf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.R;

import java.util.ArrayList;


public class PremiumPdfAdapter extends RecyclerView.Adapter<PremiumPdfAdapter.MyViewHolder>{
    ArrayList<PremiumPdf> list;
    Context context;

    public PremiumPdfAdapter(ArrayList<PremiumPdf> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PremiumPdfAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.premium_item_layout, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PremiumPdfAdapter.MyViewHolder holder, int position) {

        PremiumPdf model = list.get(position);
        holder.detailsTv.setText(model.getPdfTitle());

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
