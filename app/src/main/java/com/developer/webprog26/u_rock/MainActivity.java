package com.developer.webprog26.u_rock;

import android.os.Bundle;

import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.di.modules.MainPresenterModule;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainView{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MainPresenter mainPresenter = getMainPresenter();

        mainPresenter.setMainView(this);

        //Todo just for test
        mainPresenter.setScreenFragment(this, MainPresenter.HOME_SCREEN_FRAGMENT_INDEX);

    }

    @Override
    protected void setupActivityComponent() {
        URockApplication.getAppComponent().plus(new MainPresenterModule()).inject(this);
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

    private MainPresenter getMainPresenter() {
        return mainPresenter;
    }
}
