package com.trodev.careermatcherpro.notification;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.R;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {

    ArrayList<NoticeModel> list;
    Context context;

    public NoticeAdapter(ArrayList<NoticeModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification_item_layout, parent, false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NoticeModel model = list.get(position);

        holder.detailsTv.setText(model.getTitle());
        holder.typeTv.setText(model.getJob());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NoticeViewActivity.class);
                intent.putExtra("details", model.getTitle());
                intent.putExtra("type", model.getJob());
                intent.putExtra("image", model.getImage());
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

        TextView detailsTv, typeTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            detailsTv = itemView.findViewById(R.id.detailsTv);
            typeTv = itemView.findViewById(R.id.typeTv);


        }
    }
}
