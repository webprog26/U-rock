package com.developer.webprog26.u_rock.mvp.interfaces;

/**
 * Manages app main screen actions
 */

public interface MainPresenter {

    int HOME_SCREEN_FRAGMENT_INDEX = 0;
    int POPULAR_SCREEN_FRAGMENT_INDEX = 1;
    int RECOMMENDED_SCREEN_FRAGMENT_INDEX = 2;
    int BOOKMARKS_SCREEN_FRAGMENT_INDEX = 3;

    String HOME_SCREEN_FRAGMENT_TAG = "home_screen_fragment_tag";
    String POPULAR_SCREEN_FRAGMENT_TAG = "popular_screen_fragment_tag";
    String RECOMMENDED_SCREEN_FRAGMENT_TAG = "recommended_screen_fragment_tag";
    String BOOKMARKS_SCREEN_FRAGMENT_TAG = "bookmarks_screen_fragment_tag";

    String SAVED_FRAGMENT_INDEX_TAG = "saved_fragment_index_tag";

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

    void setStartFragment();

    /**
     * Changes fragments on app screen depending on index param
     */
    void setScreenFragment(final int screenFragmentIndex);

    void onPause();
}
