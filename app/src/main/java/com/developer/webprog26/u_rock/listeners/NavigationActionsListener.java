package com.developer.webprog26.u_rock.listeners;

import com.developer.webprog26.u_rock.mvp.interfaces.MainPresenter;

/**
 * Created by webprog on 17.09.17.
 */

public abstract class NavigationActionsListener {

    private final MainPresenter mainPresenter;

    public NavigationActionsListener(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    protected MainPresenter getMainPresenter() {
        return mainPresenter;
    }
}
