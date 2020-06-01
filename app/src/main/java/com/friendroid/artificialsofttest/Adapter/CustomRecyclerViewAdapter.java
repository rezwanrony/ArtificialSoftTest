package com.friendroid.artificialsofttest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.friendroid.artificialsofttest.Utills.ItemClickListener;
import com.friendroid.artificialsofttest.Model.ReportResponse;
import com.friendroid.artificialsofttest.R;
import com.friendroid.artificialsofttest.Utills.Utility;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<ReportResponse> list = new ArrayList<>();
    private ItemClickListener itemClickListener;
    public CustomRecyclerViewAdapter(Context context, List<ReportResponse> list,ItemClickListener itemClickListener){
        this.context = context;
        this.list = list;
        this.itemClickListener=itemClickListener;
    }
    @Override
    public CustomRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomRecyclerViewAdapter.MyViewHolder holder, int position) {
        Picasso.get().load(Utility.BaseImageUrl+list.get(position).getImage()).into(holder.img_report);
        holder.tvReportTitle.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvReportTitle;
        ImageView img_report;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvReportTitle = (TextView)itemView.findViewById(R.id.tvtitle_report);
            img_report = itemView.findViewById(R.id.img_report);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(list,getAdapterPosition());
                }
            });
        }
    }
}
