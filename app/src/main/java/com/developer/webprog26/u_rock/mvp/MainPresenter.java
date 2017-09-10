package com.developer.webprog26.u_rock.mvp;

/**
 * Manages app main screen actions
 */

public interface MainPresenter {

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
     * Switches app screen to home
     */
    void goToHomeScreen();

    /**
     * Switches app screen to popular
     */
    void goToPopularScreen();

    /**
     * Switches app screen to recommended
     */
    void goToRecommendedScreen();

    /**
     * Switches app screen to favourites
     */
    void goToFavouritesScreen();
}
