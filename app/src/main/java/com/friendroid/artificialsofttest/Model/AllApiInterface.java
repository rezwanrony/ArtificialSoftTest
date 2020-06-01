package com.friendroid.artificialsofttest.Model;

import retrofit2.Call;
import retrofit2.http.GET;
public interface AllApiInterface {

    @GET("home_page.php")
    Call<Report> getReport();
}
