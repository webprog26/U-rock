package com.developer.webprog26.u_rock.data_loading;

import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

/**
 * Created by webprog26 on 15.10.17.
 */

public interface OnArticlesDownloadedFromNetworkCallback {

    void onArticlesDownloadedFromNetwork(final ArrayList<Article> articles);
}
