package com.developer.webprog26.u_rock.mvp.impls;

import android.content.Context;
import android.util.Log;

import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.MainView;

/**
 * {@link MainPresenter} implementation
 */

public class MainPresenterImpl implements MainPresenter {

    private static final String TAG = "MainPresenter";

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
        testFragmentSet(screenFragmentIndex);
    }

    private MainView getMainView() {
        return mainView;
    }

    private void testFragmentSet(final int fragmentIndex){
        switch (fragmentIndex){
            case HOME_SCREEN_FRAGMENT_INDEX:
                Log.i(TAG, "Setting Home fragment");
                break;
            case POPULAR_SCREEN_FRAGMENT_INDEX:
                Log.i(TAG, "Setting Popular fragment");
                break;
            case RECOMMENDED_SCREEN_FRAGMENT_INDEX:
                Log.i(TAG, "Setting All categories fragment");
                break;
            case BOOKMARKS_SCREEN_FRAGMENT_INDEX:
                Log.i(TAG, "Setting Favorites fragment");
                break;
            default:
                Log.i(TAG, "Something went wrong with setting fragment");
        }
    }
}
