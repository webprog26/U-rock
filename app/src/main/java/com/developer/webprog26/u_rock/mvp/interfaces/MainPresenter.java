package com.developer.webprog26.u_rock.mvp.interfaces;

import android.content.Context;

/**
 * Manages app main screen actions
 */

public interface MainPresenter {

    int HOME_SCREEN_FRAGMENT_INDEX = 0;
    int POPULAR_SCREEN_FRAGMENT_INDEX = 1;
    int RECOMMENDED_SCREEN_FRAGMENT_INDEX = 2;
    int BOOKMARKS_SCREEN_FRAGMENT_INDEX = 3;

    /**
     * Sets {@link MainView} to interact with
     * @param mainView {@link MainView}
     */
    void setMainView(MainView mainView);

    /**
     * Executes user search
     * @param userSearchRequest {@link String}
     */
    void executeUserSearch(final String userSearchRequest);

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

    /**
     * Changes fragments on app screen depending on index param
     */
    void setScreenFragment(final Context context, final int screenFragmentIndex);
}
