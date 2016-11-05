package com.example.nanchen.nettest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.1.113/AiYaSchoolPush/test/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppService service = retrofit.create(AppService.class);

        service.listResponse().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<User> userList = response.body().data;
                Toast.makeText(MainActivity.this, "访问成功:" + userList.toString(), Toast.LENGTH_LONG).show();
//                Log.e(TAG,"访问成功:"+userList.toString());
                for (int i = 0; i < userList.size(); i++) {
                    User user = userList.get(i);
                    String birthday = user.getBirthday();
                    Log.e(TAG, birthday);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    user.setBirthday(sdf.format(new Date(Long.valueOf(birthday))));
                    Log.e(TAG, user.toString());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "访问失败:" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e(TAG, "访问失败:" + t.getMessage());
            }
        });

    }


}
