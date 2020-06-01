package com.friendroid.artificialsofttest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Report {
    @SerializedName("report")
    @Expose
    private List<ReportResponse> report = null;

    public List<ReportResponse> getReport() {
        return report;
    }

    public void setReport(List<ReportResponse> report) {
        this.report = report;
    }

}
