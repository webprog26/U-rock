package com.developer.webprog26.u_rock.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.webprog26.u_rock.data_loading.ArticlesViewModel;
import com.developer.webprog26.u_rock.data_loading.OnArticlesReadyEventListener;
import com.developer.webprog26.u_rock.mvp.interfaces.OnArticlesListShouldBeUpdatedCallback;
import com.developer.webprog26.u_rock.pojo.Article;
import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.HomeScreenPresenterModule;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.HomeScreenPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.HomeScreenView;
import java.util.ArrayList;
import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * This {@link android.support.v4.app.Fragment} is application main screen
 */

public class HomeScreenFragment extends BaseFragment implements HomeScreenView, OnArticlesReadyEventListener{

    private static final String TAG = "HomeScreenFragment";

    @Inject
    HomeScreenPresenter mHomeScreenPresenter;

    @Inject
    ArticlesViewModel articlesViewModel;

    private OnArticlesListShouldBeUpdatedCallback mOnArticlesListShouldBeUpdatedCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnArticlesListShouldBeUpdatedCallback) {
            mOnArticlesListShouldBeUpdatedCallback = (OnArticlesListShouldBeUpdatedCallback) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getHomeScreenPresenter().setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_screen_fragment, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
        articlesViewModel.subscribe(this);

        if(mOnArticlesListShouldBeUpdatedCallback != null) {
            mOnArticlesListShouldBeUpdatedCallback.onArticlesListShouldBeUpdated();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
        articlesViewModel.unsubscribe(this);
    }

    @Override
    protected void setupFragmentComponent() {
        URockApplication.getAppComponent().plus(new HomeScreenPresenterModule()).inject(this);
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

    @Override
    public void onArticlesReady(@NonNull ArrayList<Article> articles) {
        for(Article article: articles) {
            Log.i(TAG, "article with id: " + article.getArticleId());
        }
    }

    private HomeScreenPresenter getHomeScreenPresenter() {
        return mHomeScreenPresenter;
    }
}
