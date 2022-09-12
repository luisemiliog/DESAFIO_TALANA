package com.example.desafiotalana.CORE.HOME.PRESENTER;

import com.example.desafiotalana.CORE.HOME.MODEL.HomeInteractor;
import com.example.desafiotalana.CORE.HOME.VIEW.HomeView;
import com.example.desafiotalana.IO.RESPONSES.FeedResponse;

import java.util.ArrayList;

public class HomePresenterImplements  implements  HomePresenter, HomeInteractor.OnHomeListener {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresenterImplements(HomeView homeView, HomeInteractor homeInteractor) {
        this.homeView = homeView;
        this.homeInteractor = homeInteractor;
    }

    @Override
    public void succes(ArrayList<FeedResponse> responses) {
        homeView.setSUccess(responses);
    }

    @Override
    public void error() {


    }

    @Override
    public void getAllFeeds() {
        homeInteractor.getAllFeeds(this);
    }

    @Override
    public void getCurrentFeed(Integer id) {
        homeInteractor.getSelectedFeed(id, this);
    }

    @Override
    public void onDestroy() {
        this.homeView = null;
    }
}
