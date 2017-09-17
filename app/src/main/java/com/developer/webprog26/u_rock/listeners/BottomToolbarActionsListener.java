package com.developer.webprog26.u_rock.listeners;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;

/**
 * Created by webprog on 15.09.17.
 */

public class BottomToolbarActionsListener extends NavigationActionsListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    public BottomToolbarActionsListener(MainPresenter mainPresenter) {
        super(mainPresenter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_all_categories:
                getMainPresenter().setScreenFragment(MainPresenter.HOME_SCREEN_FRAGMENT_INDEX);
                break;
            case R.id.action_popular:
                getMainPresenter().setScreenFragment(MainPresenter.POPULAR_SCREEN_FRAGMENT_INDEX);
                break;
            case R.id.action_recommended:
                getMainPresenter().setScreenFragment(MainPresenter.RECOMMENDED_SCREEN_FRAGMENT_INDEX);
                break;
            case R.id.action_bookmarks:
                getMainPresenter().setScreenFragment(MainPresenter.BOOKMARKS_SCREEN_FRAGMENT_INDEX);
                break;
        }
        return true;
    }
}
