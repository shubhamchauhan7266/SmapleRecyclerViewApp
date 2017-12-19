package com.smaplerecyclerviewapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 18/12/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private ArrayList<DataModel> mDataModelList;
    private Context mContext;
    private IRecyclerViewAdapterCallBack iRecyclerViewAdapterCallBack;

    RecyclerViewAdapter(Context context, ArrayList<DataModel> dataModelList) {
        mDataModelList = dataModelList;
        mContext = context;
        iRecyclerViewAdapterCallBack = (IRecyclerViewAdapterCallBack) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final DataModel dataModel = mDataModelList.get(position);

        if (dataModel.isClick) {
            holder.tvPlusMinus.setText("-");
            holder.tvDescription.setVisibility(View.VISIBLE);
        } else {
            holder.tvPlusMinus.setText("+");
            holder.tvDescription.setVisibility(View.GONE);
        }
        holder.tvName.setText(dataModel.name != null ? dataModel.name : "");
        holder.tvDescription.setText(dataModel.description != null ? dataModel.description : "");
        holder.tvPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dataModel.isClick) {
                    iRecyclerViewAdapterCallBack.onViewClick(position, false);
                } else {
                    iRecyclerViewAdapterCallBack.onViewClick(position, true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataModelList != null ? mDataModelList.size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvDescription;
        private TextView tvPlusMinus;

        MyViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvPlusMinus = itemView.findViewById(R.id.tv_plus_minus);

        }
    }

    public interface IRecyclerViewAdapterCallBack {
        void onViewClick(int position, boolean isClick);
    }
}
