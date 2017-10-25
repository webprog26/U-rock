package com.developer.webprog26.u_rock.data_loading.data_loading_api;

import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

/**
 * Created by webprog26 on 15.10.17.
 */

public interface OnArticlesLoadedFromNetworkCallback {

    void onArticlesLoadedFromNetwork(@NonNull final ArrayList<Article> articles);
}
