package com.developer.webprog26.u_rock.mvp.impls;

import android.support.v4.view.GravityCompat;
import android.util.Log;

import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.fragments.BaseFragment;
import com.developer.webprog26.u_rock.fragments.BookmarksScreenFragment;
import com.developer.webprog26.u_rock.fragments.HomeScreenFragment;
import com.developer.webprog26.u_rock.fragments.PopularScreenFragment;
import com.developer.webprog26.u_rock.fragments.RecommendedScreenFragment;
import com.developer.webprog26.u_rock.helpers.FragmentChangeHelper;
import com.developer.webprog26.u_rock.helpers.interfaces.SharedPreferencesHelper;
import com.developer.webprog26.u_rock.holders.ActiveFragmentIndexHolder;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.MainView;

import javax.inject.Inject;

/**
 * {@link MainPresenter} implementation
 */

public class MainPresenterImpl implements MainPresenter {

    private static final String TAG = "MainPresenter";

    @Inject
    SharedPreferencesHelper mSharedPreferencesHelper;

    private final ActiveFragmentIndexHolder mActiveFragmentIndexHolder = ActiveFragmentIndexHolder.getInstance();

    public MainPresenterImpl() {
        URockApplication.getAppComponent().inject(this);
    }

    private static final String[] fragmentsTags = new String[]{
            HOME_SCREEN_FRAGMENT_TAG,
            POPULAR_SCREEN_FRAGMENT_TAG,
            RECOMMENDED_SCREEN_FRAGMENT_TAG,
            BOOKMARKS_SCREEN_FRAGMENT_TAG
    };

    private static final int[] bottomNavigationViewItemsIds = new int[]{
            R.id.action_all_categories,
            R.id.action_popular,
            R.id.action_recommended,
            R.id.action_bookmarks
    };

    private MainView mainView;

    @Override
    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void executeUserSearch(String userSearchRequest) {

    }

    @Override
    public void setStartFragment() {
        int lastActiveFragmentIndex = getSharedPreferencesHelper().get(LAST_ACTIVE_FRAGMENT_INDEX_TAG, 3);
        setScreenFragment(lastActiveFragmentIndex);

        getMainView().getBottomNavigationView().setSelectedItemId(getBottomNavigationViewItemsIds()[lastActiveFragmentIndex]);
    }

    @Override
    public void setScreenFragment(int screenFragmentIndex) {
        testFragmentSet(screenFragmentIndex);
        BaseFragment fragment = null;
        String fragmentTAG = null;
        switch (screenFragmentIndex) {
            case HOME_SCREEN_FRAGMENT_INDEX:
                fragment = new HomeScreenFragment();
                fragmentTAG = getFragmentsTags()[HOME_SCREEN_FRAGMENT_INDEX];
                break;
            case POPULAR_SCREEN_FRAGMENT_INDEX:
                fragment = new PopularScreenFragment();
                fragmentTAG = getFragmentsTags()[POPULAR_SCREEN_FRAGMENT_INDEX];
                break;
            case RECOMMENDED_SCREEN_FRAGMENT_INDEX:
                fragment = new RecommendedScreenFragment();
                fragmentTAG = getFragmentsTags()[RECOMMENDED_SCREEN_FRAGMENT_INDEX];
                break;
            case BOOKMARKS_SCREEN_FRAGMENT_INDEX:
                fragment = new BookmarksScreenFragment();
                fragmentTAG = getFragmentsTags()[BOOKMARKS_SCREEN_FRAGMENT_INDEX];
                break;
            }

        if(fragment != null && fragmentTAG != null) {
            FragmentChangeHelper.changeFragment(getMainView().getScreenFragmentManager(),
                    getMainView().getContainerResId(), fragment, fragmentTAG);
            getActiveFragmentIndexHolder().setActiveFragmentIndex(screenFragmentIndex);
        }
    }

    @Override
    public void onPause() {
        getSharedPreferencesHelper().put(LAST_ACTIVE_FRAGMENT_INDEX_TAG, getActiveFragmentIndexHolder().getActiveFragmentIndex());
    }


    @Override
    public void closeDrawerLayoutAfterActionPerformed() {
        getMainView().getDrawerLayout().closeDrawer(GravityCompat.START);
    }

    @Override
    public void openSettingsActvity() {
        Log.i(TAG, "openSettingsActvity");
    }

    @Override
    public void openFeedbackActivity() {
        Log.i(TAG, "openFeedbackActivity");
    }

    private MainView getMainView() {
        return mainView;
    }

    private static String[] getFragmentsTags() {
        return fragmentsTags;
    }

    private static int[] getBottomNavigationViewItemsIds() {
        return bottomNavigationViewItemsIds;
    }

    private SharedPreferencesHelper getSharedPreferencesHelper() {
        return mSharedPreferencesHelper;
    }

    private ActiveFragmentIndexHolder getActiveFragmentIndexHolder() {
        return mActiveFragmentIndexHolder;
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
