package com.trodev.careermatcherpro;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class McqAdapter extends RecyclerView.Adapter<McqAdapter.MyViewHolder> {

    private Context context;
    private List<McqModel> list;

    public McqAdapter(Context context, List<McqModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mcq_template_layout, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        McqModel model = list.get(position);

        /*set data on short views*/
        holder.serialTv.setText(model.getMcq_no()+".");
        holder.questionTv.setText(model.getGrp_ques());
        holder.firstTv.setText(model.getFirst());
        holder.secondTv.setText(model.getSecond());
        holder.thirdTv.setText(model.getThird());
        holder.fourthTv.setText(model.getFourth());
        holder.ansTv.setText(model.getAns());


        /*animation view with slider*/
        // holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.slider));

        boolean isExpandable = list.get(position).isExpandable();
        holder.expandable_layout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView serialTv, questionTv, firstTv, secondTv, thirdTv ,fourthTv, ansTv ;
        CardView cardView;
        ImageView dropdown;

        RelativeLayout expandable_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            /*init views*/
            serialTv = itemView.findViewById(R.id.serialTv);
            questionTv = itemView.findViewById(R.id.questionTv);
            firstTv = itemView.findViewById(R.id.firstTv);
            secondTv = itemView.findViewById(R.id.secondTv);
            thirdTv = itemView.findViewById(R.id.thirdTv);
            fourthTv = itemView.findViewById(R.id.fourthTv);
            ansTv = itemView.findViewById(R.id.ansTv);
            cardView = itemView.findViewById(R.id.cardView);
            dropdown = itemView.findViewById(R.id.dropdown);
            expandable_layout = itemView.findViewById(R.id.expandable_layout);

            dropdown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    McqModel mcqModel = list.get(getAdapterPosition());
                    mcqModel.setExpandable(!mcqModel.isExpandable());
                    notifyItemChanged(getAdapterPosition());

                }
            });


        }
    }
}
