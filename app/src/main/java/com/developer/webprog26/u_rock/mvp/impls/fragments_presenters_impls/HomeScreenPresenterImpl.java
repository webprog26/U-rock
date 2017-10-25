package com.developer.webprog26.u_rock.mvp.impls.fragments_presenters_impls;

import android.util.Log;

import com.developer.webprog26.u_rock.data_loading.OnArticlesDownloadedFromNetworkCallback;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.HomeScreenPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.HomeScreenView;
import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

public class HomeScreenPresenterImpl implements HomeScreenPresenter {

    private static final String TAG = "HomeScreenPresenter";

    private HomeScreenView homeScreenView;

    @Override
    public void setView(HomeScreenView view) {
        this.homeScreenView = view;
    }

    @Override
    public void notifyMainViewToSetUserGreetingsMessage(String userName) {

    }

    @Override
    public void onStart() {
        Log.i(TAG, "HomeScreenPresenter");

    }

    @Override
    public void notifyMainViewToSetNewArticlesMessage(int newArticlesNumber) {

    }

    @Override
    public void notifyMainViewToSetNewCommentsMessage(int newCommentsNumber) {

    }

    private HomeScreenView getHomeScreenView() {
        return homeScreenView;
    }
}
