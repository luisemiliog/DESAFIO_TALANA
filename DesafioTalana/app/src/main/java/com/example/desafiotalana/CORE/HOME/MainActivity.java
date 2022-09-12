package com.example.desafiotalana.CORE.HOME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.desafiotalana.CORE.ADAPTER.FeedAdapter;
import com.example.desafiotalana.CORE.HOME.MODEL.HomeInteractorImplements;
import com.example.desafiotalana.CORE.HOME.PRESENTER.HomePresenter;
import com.example.desafiotalana.CORE.HOME.PRESENTER.HomePresenterImplements;
import com.example.desafiotalana.CORE.HOME.VIEW.HomeView;
import com.example.desafiotalana.IO.RESPONSES.FeedResponse;
import com.example.desafiotalana.R;
import com.example.desafiotalana.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements HomeView {

    private HomePresenter homePresenter;
    private ActivityMainBinding binding;
    private RecyclerView.LayoutManager layoutManager;
    private FeedAdapter feedAdapter;
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.homePresenter = new HomePresenterImplements(this, new HomeInteractorImplements());
        this.homePresenter.getAllFeeds();
        this.lista = findViewById(R.id.fedd_recicle);
        layoutManager = new LinearLayoutManager(this);
        lista.setHasFixedSize(true);
        lista.setLayoutManager(layoutManager);



    }


    @Override
    public void setSUccess(ArrayList<FeedResponse> responses) {
        feedAdapter = new FeedAdapter(MainActivity.this,responses);
        this.lista.setAdapter(feedAdapter);
    }
}