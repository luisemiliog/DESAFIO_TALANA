package com.example.desafiotalana.CORE.HOME.MODEL;

import com.example.desafiotalana.IO.RESPONSES.FeedResponse;

import java.util.ArrayList;

public interface HomeInteractor {
    interface  OnHomeListener{
        void succes(ArrayList<FeedResponse> responses);
        void error();

    }

    void getAllFeeds(OnHomeListener listener);
    void getSelectedFeed(Integer id,OnHomeListener listener);
}
