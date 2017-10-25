package com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters;

import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.PopularScreenView;

public interface PopularScreenPresenter {

    void setView(PopularScreenView view);
    void detach();
}
