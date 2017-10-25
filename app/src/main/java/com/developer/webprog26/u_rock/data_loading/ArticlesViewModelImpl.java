package com.developer.webprog26.u_rock.data_loading;

import android.support.annotation.NonNull;
import android.util.Log;

import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

/**
 * Created by webprog26 on 15.10.17.
 */

public class ArticlesViewModelImpl implements ArticlesViewModel {

    private static final String TAG = "ArticlesViewModel";

    private final ArrayList<OnArticlesReadyEventListener> eventListeners = new ArrayList<>();

    @Override
    public void subscribe(@NonNull OnArticlesReadyEventListener eventListener) {
        eventListeners.add(eventListener);
    }

    @Override
    public void unsubscribe(@NonNull OnArticlesReadyEventListener eventListener) {
        eventListeners.remove(eventListeners.indexOf(eventListener));
    }

    @Override
    public void notify(@NonNull ArrayList<Article> articles) {
        Log.i(TAG, "notify articles.size = " + articles.size());
        for (OnArticlesReadyEventListener eventListener: eventListeners) {
            if (eventListener != null) {
                eventListener.onArticlesReady(articles);
            }
        }
    }
}
