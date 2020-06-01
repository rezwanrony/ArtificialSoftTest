package com.friendroid.artificialsofttest.Core;

import android.content.Context;
import android.util.Log;

import com.friendroid.artificialsofttest.Model.AllApiInterface;
import com.friendroid.artificialsofttest.Model.Report;
import com.friendroid.artificialsofttest.Model.ReportResponse;
import com.friendroid.artificialsofttest.Utills.Utility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Intractor implements GetDataReport.Interactor{
    private GetDataReport.onGetDataListener mOnGetDatalistener;
    List<ReportResponse> allreport = new ArrayList<>();
    List<String> allReportsData = new ArrayList<>();

    public Intractor(GetDataReport.onGetDataListener mOnGetDatalistener){
        this.mOnGetDatalistener = mOnGetDatalistener;
    }
    @Override
    public void initRetrofitCall(Context context, String url) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        AllApiInterface request = retrofit.create(AllApiInterface.class);
        retrofit2.Call<Report> call = request.getReport();
        call.enqueue(new retrofit2.Callback<Report>() {
            @Override
            public void onResponse(retrofit2.Call<Report> call, retrofit2.Response<Report> response) {
                Report jsonResponse = response.body();
                allreport = jsonResponse.getReport();
                for(int i = 0; i< allreport.size(); i++){
                    allReportsData.add(allreport.get(i).getTitle());
                }
                Log.d("Data", "Refreshed");
                mOnGetDatalistener.onSuccess("List Size: " + allReportsData.size(), allreport);



            }
            @Override
            public void onFailure(retrofit2.Call<Report> call, Throwable t) {
                Log.v("Error",t.getMessage());
                mOnGetDatalistener.onFailure(t.getMessage());
            }
        });
    }
}
