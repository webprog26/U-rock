package com.developer.webprog26.u_rock.listeners;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;

/**
 * Created by webprog on 15.09.17.
 */

public class BottomToolbarActionsListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private final MainPresenter mainPresenter;
    private final Context mContext;

    public BottomToolbarActionsListener(MainPresenter mainPresenter, Context context) {
        this.mainPresenter = mainPresenter;
        this.mContext = context;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        final Context context = getContext();
        switch (item.getItemId()){
            case R.id.action_all_categories:
                getMainPresenter().setScreenFragment(context, MainPresenter.HOME_SCREEN_FRAGMENT_INDEX);
                break;
            case R.id.action_popular:
                getMainPresenter().setScreenFragment(context, MainPresenter.POPULAR_SCREEN_FRAGMENT_INDEX);
                break;
            case R.id.action_recommended:
                getMainPresenter().setScreenFragment(context, MainPresenter.RECOMMENDED_SCREEN_FRAGMENT_INDEX);
                break;
            case R.id.action_bookmarks:
                getMainPresenter().setScreenFragment(context, MainPresenter.BOOKMARKS_SCREEN_FRAGMENT_INDEX);
                break;
        }
        return true;
    }

    private MainPresenter getMainPresenter() {
        return mainPresenter;
    }

    private Context getContext() {
        return mContext;
    }
}
