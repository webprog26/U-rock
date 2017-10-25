package com.developer.webprog26.u_rock.mvp.interfaces.fragments_presenters;

import com.developer.webprog26.u_rock.mvp.interfaces.MainView;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.HomeScreenView;

public interface HomeScreenPresenter {

    void setView(final HomeScreenView view);

    /**
     * Notifies {@link MainView} to set user greetings message
     * @param userName {@link String}
     */
    void notifyMainViewToSetUserGreetingsMessage(final String userName);

    /**
     * Notifies {@link MainView} to set user greetings message
     * @param newArticlesNumber int
     */
    void notifyMainViewToSetNewArticlesMessage(final int newArticlesNumber);

    /**
     * Notifies {@link MainView} to set user greetings message
     * @param newCommentsNumber int
     */
    void notifyMainViewToSetNewCommentsMessage(final int newCommentsNumber);

    void onStart();

    void detach();
}
