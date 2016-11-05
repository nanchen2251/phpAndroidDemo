package com.example.nanchen.nettest;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author nanchen
 * @fileName NetTest
 * @packageName com.example.nanchen.nettest
 * @date 2016/11/05  15:19
 */

public interface AppService {

    @GET("test_api.php")
    Call<Response> listResponse();


}
