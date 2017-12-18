package com.smaplerecyclerviewapp;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.Visibility;
import android.view.Gravity;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.IRecyclerViewAdapterCallBack{

    private RecyclerView mRecyclerView;
    private ArrayList<DataModel> mDataModelList;
    private RecyclerViewAdapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataModelList = new ArrayList<>();
        mDataModelList.add(new DataModel("Description 1", getString(R.string.desc1), false));
        mDataModelList.add(new DataModel("Description 2", getString(R.string.desc2), false));
        mDataModelList.add(new DataModel("Description 3", getString(R.string.desc3), false));
        mDataModelList.add(new DataModel("Description 4", getString(R.string.desc4), false));
        mDataModelList.add(new DataModel("Description 5", getString(R.string.desc5), false));
        mDataModelList.add(new DataModel("Description 6", getString(R.string.desc6), false));

        mAdapter = new RecyclerViewAdapter(this, mDataModelList);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onViewClick(int position, boolean isClick) {
        for(DataModel dataModel: mDataModelList){
            dataModel.isClick=false;
        }
        DataModel dataModel=mDataModelList.get(position);
        dataModel.isClick=isClick;
        mAdapter.notifyDataSetChanged();
    }
}
