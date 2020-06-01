package com.friendroid.artificialsofttest.Core;

import android.content.Context;

import com.friendroid.artificialsofttest.Model.ReportResponse;

import java.util.List;

public class Presenter implements GetDataReport.Presenter, GetDataReport.onGetDataListener {
    private GetDataReport.View mGetDataView;
    private Intractor mIntractor;
    public Presenter(GetDataReport.View mGetDataView){
        this.mGetDataView = mGetDataView;
        mIntractor = new Intractor(this);
    }
    @Override
    public void getDataFromURL(Context context, String url) {
        mIntractor.initRetrofitCall(context,url);
    }

    @Override
    public void onSuccess(String message, List<ReportResponse> allCountriesData) {
        mGetDataView.onGetDataSuccess(message, allCountriesData);
    }

    @Override
    public void onFailure(String message) {
        mGetDataView.onGetDataFailure(message);
    }
}
