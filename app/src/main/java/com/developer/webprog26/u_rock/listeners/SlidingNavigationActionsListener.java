package com.developer.webprog26.u_rock.listeners;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;

import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.holders.MainViewIntentsHolder;
import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;

/**
 * Created by webprog on 17.09.17.
 */

public class SlidingNavigationActionsListener extends NavigationActionsListener implements NavigationView.OnNavigationItemSelectedListener {

    private final MainViewIntentsHolder mainViewIntentsHolder;

    public SlidingNavigationActionsListener(MainPresenter mainPresenter, MainViewIntentsHolder mainViewIntentsHolder) {
        super(mainPresenter);
        this.mainViewIntentsHolder = mainViewIntentsHolder;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_action_settings:
                getMainPresenter().openSettingsActivity(getMainViewIntentsHolder().getSettingsActivityIntent());
                break;
            case R.id.nav_action_feedback:
                getMainPresenter().openFeedbackActivity();
                break;
        }

        getMainPresenter().closeDrawerLayoutAfterActionPerformed();
        return true;
    }

    public MainViewIntentsHolder getMainViewIntentsHolder() {
        return mainViewIntentsHolder;
    }
}
