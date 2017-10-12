package com.developer.webprog26.u_rock.mvp.interfaces.fragments_views;

import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

/**
 * Created by webprog on 15.09.17.
 */

public interface HomeScreenView {

    /**
     * Sets greetings message into appropriate {@link android.widget.TextView}
     * @param userName {@link String}
     */
    void setGreetingsMessage(final String userName);

    /**
     * Sets new articles message
     * @param newArticlesNumber int
     */
    void setNewArticlesMessage(final int newArticlesNumber);

    /**
     * Sets new comments message if curent user is subscribed to any
     * @param newCommentsNumber int
     */
    void setNewCommentsMessage(final int newCommentsNumber);

    /**
     * Updates visible to user list of existing articles on the main screen
     * @param articles {@link Article}
     */
    void updateArticlesListOnTheMainScreen(ArrayList<Article> articles);
}
