package com.developer.webprog26.u_rock.mvp.impls;

import android.content.Context;

import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.MainView;

/**
 * {@link MainPresenter} implementation
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    @Override
    public void setMainView(MainView mainView) {

    }

    @Override
    public void executeUserSearch(String userSearchRequest) {

    }

    @Override
    public void notifyMainViewToSetUserGreetingsMessage(String userName) {

    }

    @Override
    public void notifyMainViewToSetNewArticlesMessage(int newArticlesNumber) {

    }

    @Override
    public void notifyMainViewToSetNewCommentsMessage(int newCommentsNumber) {

    }

    @Override
    public void setScreenFragment(Context context, int screenFragmentIndex) {

    }

    private MainView getMainView() {
        return mainView;
    }
}
