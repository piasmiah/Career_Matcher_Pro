package com.trodev.careermatcherpro.nongovt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.R;
import com.trodev.careermatcherpro.activity.ViewAllJobActivity;

import java.util.ArrayList;

public class NonGovtAdapter extends RecyclerView.Adapter<NonGovtAdapter.MyViewHolder> {


    ArrayList<NonGovtModel> list;
    Context context;

    public NonGovtAdapter(ArrayList<NonGovtModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.job_list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NonGovtModel model = list.get(position);

        // Image get on firebase database.....
        // Picasso.get().load(model.getImage()).placeholder(R.drawable.app_logos).into(holder.imageIv);

        holder.detailsTv.setText(model.getPostdetails());
        holder.sourceTv.setText(model.getSource());
        holder.endDateTv.setText(model.getEnddate());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ViewAllJobActivity.class);

                intent.putExtra("details", model.getPostdetails());
                intent.putExtra("post", model.getPostname());
                intent.putExtra("source", model.getSource());
                intent.putExtra("sdate", model.getStartdate());
                intent.putExtra("edate", model.getEnddate());
                intent.putExtra("link", model.getLink());
                intent.putExtra("image", model.getImage());
                intent.putExtra("pdfUrl", model.getPdfUrl());

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

        private TextView detailsTv, sourceTv, endDateTv;
        private CardView cardView;

        private ImageView imageIv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            detailsTv = itemView.findViewById(R.id.detailsTv);
            sourceTv = itemView.findViewById(R.id.sourceTv);
            endDateTv = itemView.findViewById(R.id.endDateTv);
            imageIv = itemView.findViewById(R.id.imageIv);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}
