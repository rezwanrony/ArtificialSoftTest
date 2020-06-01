package com.friendroid.artificialsofttest.Utills;

import com.friendroid.artificialsofttest.Model.ReportResponse;

import java.util.List;

public interface ItemClickListener {
    void onItemClick(List<ReportResponse>reportResponseList, int pos);
}
