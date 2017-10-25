package com.developer.webprog26.u_rock.data_loading;

import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

/**
 * Created by webprog26 on 15.10.17.
 */

public interface ArticlesViewModel {

    void subscribe(@NonNull final OnArticlesReadyEventListener eventListener);
    void unsubscribe(@NonNull final OnArticlesReadyEventListener eventListener);
    void notify(@NonNull final ArrayList<Article> articles);
}
