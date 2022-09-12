package com.example.desafiotalana.CORE.HOME.MODEL;

import android.util.Log;

import com.example.desafiotalana.IO.ApiRestAdapter;
import com.example.desafiotalana.IO.RESPONSES.FeedResponse;
import com.example.desafiotalana.IO.RESPONSES.LoginResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeInteractorImplements  implements HomeInteractor{
    @Override
    public void getAllFeeds(OnHomeListener listener) {
        Call<ArrayList<FeedResponse>> call;
        call = ApiRestAdapter.getRestApiService().getAllFeeds();
        call.enqueue(new Callback<ArrayList<FeedResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<FeedResponse>> call, Response<ArrayList<FeedResponse>> response) {
                if (response.code() ==200){
                    Log.d("feeedss", response.body().toString());
                    listener.succes(response.body());

                }
                else {
                    listener.error();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<FeedResponse>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getSelectedFeed(Integer id,OnHomeListener listener) {


    }
}
