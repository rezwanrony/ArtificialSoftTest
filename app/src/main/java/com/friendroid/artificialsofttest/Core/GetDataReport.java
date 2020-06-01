package com.friendroid.artificialsofttest.Core;

import android.content.Context;

import com.friendroid.artificialsofttest.Model.Report;
import com.friendroid.artificialsofttest.Model.ReportResponse;

import java.util.List;

public interface GetDataReport {
    interface View{
        void onGetDataSuccess(String message, List<ReportResponse> list);
        void onGetDataFailure(String message);
    }
    interface Presenter{
        void getDataFromURL(Context context, String url);
    }
    interface Interactor{
        void initRetrofitCall(Context context, String url);

    }
    interface onGetDataListener{
        void onSuccess(String message, List<ReportResponse> list);
        void onFailure(String message);
    }
}
