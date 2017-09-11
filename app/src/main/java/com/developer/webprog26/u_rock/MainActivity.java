package com.developer.webprog26.u_rock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.developer.webprog26.u_rock.mvp.interfaces.MainView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setGreetingsMessage(String userName) {

    }

    @Override
    public void setNewArticlesMessage(int newArticlesNumber) {

    }

    @Override
    public void setNewCommentsMessage(int newCommentsNumber) {

    }

    @Override
    public void updateArticlesListOnTheMainScreen(ArrayList<Article> articles) {

    }
}
