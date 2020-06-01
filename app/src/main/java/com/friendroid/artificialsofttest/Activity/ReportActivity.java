package com.friendroid.artificialsofttest.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.friendroid.artificialsofttest.Adapter.CustomRecyclerViewAdapter;
import com.friendroid.artificialsofttest.Core.GetDataReport;
import com.friendroid.artificialsofttest.Utills.ConnectionDetectorUtils;
import com.friendroid.artificialsofttest.Utills.ItemClickListener;
import com.friendroid.artificialsofttest.Core.Presenter;
import com.friendroid.artificialsofttest.Model.ReportResponse;
import com.friendroid.artificialsofttest.R;
import com.friendroid.artificialsofttest.Utills.Utility;

import java.util.List;

public class ReportActivity extends AppCompatActivity implements GetDataReport.View, ItemClickListener {

    private Presenter mPresenter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    CustomRecyclerViewAdapter customRecyclerAdapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        mPresenter = new Presenter(this);
        mPresenter.getDataFromURL(getApplicationContext(), Utility.ApiBaseUrl);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onGetDataSuccess(String message, List<ReportResponse> list) {
        progressBar.setVisibility(View.GONE);
        customRecyclerAdapter = new CustomRecyclerViewAdapter(getApplicationContext(), list, this);
        recyclerView.setAdapter(customRecyclerAdapter);
    }

    @Override
    public void onGetDataFailure(String message) {
        if (ConnectionDetectorUtils.NetworkCheck(ReportActivity.this) == false) {
            progressBar.setVisibility(View.GONE);
            ConnectionDetectorUtils.buildDialog(ReportActivity.this).show();
        } else {
            progressBar.setVisibility(View.GONE);
            Log.d("Status", message);
        }
    }

    @Override
    public void onItemClick(List<ReportResponse> reportResponseList, int pos) {
        startActivity(new Intent(ReportActivity.this, ReportDetailsActivity.class)
                .putExtra("title", reportResponseList.get(pos).getTitle())
                .putExtra("price", reportResponseList.get(pos).getPrice())
                .putExtra("image", reportResponseList.get(pos).getImage()));
    }

}
