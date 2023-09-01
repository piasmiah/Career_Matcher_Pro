package com.trodev.careermatcherpro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.cv.TemplateModel;
import com.trodev.careermatcherpro.cv.TemplateViewActivity;

import java.util.ArrayList;

public class PremiumAdapter extends RecyclerView.Adapter<PremiumAdapter.MyViewHolder> {

    ArrayList<TemplateModel> list;
    Context context;

    public PremiumAdapter(ArrayList<TemplateModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PremiumAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.template_item_layout, parent, false);
       return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PremiumAdapter.MyViewHolder holder, int position) {

        TemplateModel model = list.get(position);

        holder.detailsTv.setText("টেম্পলেট নংঃ- "+ model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TemplateViewActivity.class);
                intent.putExtra("link",  model.getLink());
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

        TextView detailsTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            detailsTv  = itemView.findViewById(R.id.detailsTv);
        }
    }
}
