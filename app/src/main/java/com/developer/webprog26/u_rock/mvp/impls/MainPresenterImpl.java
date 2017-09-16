package com.developer.webprog26.u_rock.mvp.impls;

import android.util.Log;

import com.developer.webprog26.u_rock.fragments.BaseFragment;
import com.developer.webprog26.u_rock.fragments.BookmarksScreenFragment;
import com.developer.webprog26.u_rock.fragments.HomeScreenFragment;
import com.developer.webprog26.u_rock.fragments.PopularScreenFragment;
import com.developer.webprog26.u_rock.fragments.RecommendedScreenFragment;
import com.developer.webprog26.u_rock.helpers.FragmentChangeHelper;
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
        this.mainView = mainView;
    }

    @Override
    public void executeUserSearch(String userSearchRequest) {

    }

    @Override
    public void setScreenFragment(int screenFragmentIndex) {
        testFragmentSet(screenFragmentIndex);
        BaseFragment fragment = null;
        switch (screenFragmentIndex) {
            case HOME_SCREEN_FRAGMENT_INDEX:
                fragment = new HomeScreenFragment();
                break;
            case POPULAR_SCREEN_FRAGMENT_INDEX:
                fragment = new PopularScreenFragment();
                break;
            case RECOMMENDED_SCREEN_FRAGMENT_INDEX:
                fragment = new RecommendedScreenFragment();
                break;
            case BOOKMARKS_SCREEN_FRAGMENT_INDEX:
                fragment = new BookmarksScreenFragment();
                break;
            }

        if(fragment != null) {
            FragmentChangeHelper.changeFragment(getMainView().getScreenFragmentManager(),
                    getMainView().getContainerResId(), fragment, HOME_SCREEN_FRAGMENT_TAG);
        }
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
                Log.i(TAG, "Setting Recommended fragment");
                break;
            case BOOKMARKS_SCREEN_FRAGMENT_INDEX:
                Log.i(TAG, "Setting Bookmarks fragment");
                break;
            default:
                Log.i(TAG, "Something went wrong with setting fragment");
        }
    }
}
