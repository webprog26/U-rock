package com.developer.webprog26.u_rock.mvp.impls;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.util.Log;

import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.data_loading.DataRepository;
import com.developer.webprog26.u_rock.fragments.BaseFragment;
import com.developer.webprog26.u_rock.fragments.BookmarksScreenFragment;
import com.developer.webprog26.u_rock.fragments.HomeScreenFragment;
import com.developer.webprog26.u_rock.fragments.PopularScreenFragment;
import com.developer.webprog26.u_rock.fragments.RecommendedScreenFragment;
import com.developer.webprog26.u_rock.helpers.FragmentChangeHelper;
import com.developer.webprog26.u_rock.helpers.interfaces.SharedPreferencesHelper;
import com.developer.webprog26.u_rock.holders.LastActiveFragmentIndexHolder;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;
import com.developer.webprog26.u_rock.mvp.interfaces.MainView;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters.SettingsFragmentPresenter;

import javax.inject.Inject;

/**
 * {@link MainPresenter} implementation
 */

public class MainPresenterImpl implements MainPresenter {

    private static final String TAG = "MainPresenter";

    @Inject
    SharedPreferencesHelper mSharedPreferencesHelper;

    @Inject
    LastActiveFragmentIndexHolder mLastActiveFragmentIndexHolder;

    @Inject
    DataRepository mDataRepository;

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
        final int lastActiveFragmentIndex = getSharedPreferencesHelper()
                .get(LastActiveFragmentIndexHolder.LAST_ACTIVE_FRAGMENT_INDEX_TAG, 0);

        setScreenFragment(lastActiveFragmentIndex);

        getMainView().getBottomNavigationView()
                .setSelectedItemId(getBottomNavigationViewItemsIds()[lastActiveFragmentIndex]);
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


            getLastActiveFragmentIndexHolder().saveLastActiveFragmentIndex(shouldSaveLastActiveFragment()
                    ? screenFragmentIndex : 0);
        }
    }

    @Override
    public void onPause() {

        final int lastActiveFragmentIndex = shouldSaveLastActiveFragment() ? getLastActiveFragmentIndexHolder()
                .getLastActiveFragmentIndex() : 0;

        getSharedPreferencesHelper().put(LastActiveFragmentIndexHolder.LAST_ACTIVE_FRAGMENT_INDEX_TAG,
                lastActiveFragmentIndex);

    }


    @Override
    public void closeDrawerLayoutAfterActionPerformed() {
        getMainView().getDrawerLayout().closeDrawer(GravityCompat.START);
    }

    @Override
    public void openSettingsActivity(final Intent intent) {
        Log.i(TAG, "openSettingsActivity");
        getMainView().openActivity(intent);
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

    private LastActiveFragmentIndexHolder getLastActiveFragmentIndexHolder() {
        return mLastActiveFragmentIndexHolder;
    }

    private void testFragmentSet(final int fragmentIndex) {
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

    private boolean shouldSaveLastActiveFragment(){
        return getSharedPreferencesHelper().get(SettingsFragmentPresenter.REMEMBER_LAST_ACTIVE_CATEGORY_PREFERENCE_KEY, false);
    }

    private DataRepository getDataRepository() {
        return mDataRepository;
    }

    @Override
    public void loadArticlesDataWithDataRepository() {
        getDataRepository().getArticlesData();
    }
}
