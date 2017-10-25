package com.developer.webprog26.u_rock.data_loading;

import android.support.annotation.NonNull;
import android.util.Log;

import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.data_loading.data_loading_api.DataLoadingApiManager;
import com.developer.webprog26.u_rock.data_loading.data_loading_api.OnArticlesLoadedFromNetworkCallback;
import com.developer.webprog26.u_rock.data_loading.sqlite.UrockDbHelper;
import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by webprog26 on 15.10.17.
 */

public class DataRepositoryImpl implements DataRepository {

    private static final String TAG = "DataRepository";

    @Inject
    ArticlesViewModel mArticlesViewModel;

    @Inject
    DataLoadingApiManager mDataLoadingApiManager;

    @Inject
    UrockDbHelper mUrockDbHelper;

    public DataRepositoryImpl() {
        URockApplication.getAppComponent().inject(this);
    }

    @Override
    public void getArticlesData() {
        final DataLoadingApiManager dataLoadingApiManager = getDataLoadingApiManager();
        final UrockDbHelper urockDbHelper = getUrockDbHelper();
        final ArrayList<Article> articlesFromLocalDb = dataLoadingApiManager.getArticlesFromLocalDb(getUrockDbHelper());

        if(articlesFromLocalDb.size() > 0) {
            getArticlesViewModel().notify(articlesFromLocalDb);
        }

        dataLoadingApiManager.loadArticlesFromNetwork(urockDbHelper, new OnArticlesLoadedFromNetworkCallback() {
            @Override
            public void onArticlesLoadedFromNetwork(@NonNull ArrayList<Article> articles) {
                if(articles.size() > 0) {
                    try {
                        dataLoadingApiManager.saveDataToLocalDb(articles,
                                urockDbHelper, new OnArticlesDataSavedToLocalDbCallback() {
                            @Override
                            public void onArticlesDataSavedToLocalDb(boolean response) {
                                if(response) {
                                    getArticlesViewModel()
                                            .notify(dataLoadingApiManager.getArticlesFromLocalDb(urockDbHelper));
                                }
                            }
                        });
                    } catch (Exception e){
                        Log.e("DataRepository", e.getMessage());
                    }
                }
            }
        });
    }

    private ArticlesViewModel getArticlesViewModel() {
        return mArticlesViewModel;
    }

    private DataLoadingApiManager getDataLoadingApiManager() {
        return mDataLoadingApiManager;
    }

    private UrockDbHelper getUrockDbHelper() {
        return mUrockDbHelper;
    }
}
