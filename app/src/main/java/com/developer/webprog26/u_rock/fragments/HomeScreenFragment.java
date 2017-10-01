package com.developer.webprog26.u_rock.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.webprog26.u_rock.Article;
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

public class HomeScreenFragment extends BaseFragment implements HomeScreenView{

    @Inject
    HomeScreenPresenter mHomeScreenPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_screen_fragment, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
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

    private HomeScreenPresenter getHomeScreenPresenter() {
        return mHomeScreenPresenter;
    }
}
