package com.developer.webprog26.u_rock.data_loading.data_loading_api;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;

import com.developer.webprog26.u_rock.data_loading.OnArticlesDataSavedToLocalDbCallback;
import com.developer.webprog26.u_rock.data_loading.sqlite.UrockDbHelper;
import com.developer.webprog26.u_rock.pojo.Article;

import java.util.ArrayList;

/**
 * Created by webprog26 on 15.10.17.
 */

public class DataLoadingApiManager {

    private static final String TAG = "DataLoadingApiManager";

    //Just for testing
    private final Article article = new Article(1, "Test title", "Test not really long text", 1, 1, "http://article.jpg", "Test author", "12=10-2017", false);

    public void loadArticlesFromNetwork(final UrockDbHelper urockDbHelper, final OnArticlesLoadedFromNetworkCallback callback){
        final ArrayList<Article> articles = new ArrayList<>();
        if(isFreshArticle(urockDbHelper, article.getArticleServerId())) {
            articles.add(article);
        }
        callback.onArticlesLoadedFromNetwork(articles);
    }

    public void saveDataToLocalDb(final ArrayList<Article> articles,
                                  final UrockDbHelper urockDbHelper,
                                  final OnArticlesDataSavedToLocalDbCallback callback) throws Exception{

        for(Article article: articles){
            if(!(urockDbHelper
                    .getWritableDatabase()
                    .insert(UrockDbHelper.TABLE_ARTICLES, null, getArticleContentValues(article)) > 0)) {
                callback.onArticlesDataSavedToLocalDb(false);
                throw new Exception("Unable to save article in local database");
            }
        }
        callback.onArticlesDataSavedToLocalDb(true);
    }

    @NonNull
    private ContentValues getArticleContentValues(final Article article){
        ContentValues articleContentValues = new ContentValues();
        articleContentValues.put(UrockDbHelper.ARTICLE_TITLE, article.getArticleTitle());
        articleContentValues.put(UrockDbHelper.ARTICLE_TEXT, article.getArticleText());
        articleContentValues.put(UrockDbHelper.ARTICLE_AUTHOR, article.getArticleAuthor());
        articleContentValues.put(UrockDbHelper.ARTICLE_CATEGORY_ID, article.getArticleCategoryId());
        articleContentValues.put(UrockDbHelper.ARTICLE_SERVER_ID, article.getArticleServerId());
        articleContentValues.put(UrockDbHelper.ARTICLE_DATE_PUBLISHED, article.getDateArticlePublished());
        articleContentValues.put(UrockDbHelper.ARTICLE_MAIN_IMAGE_URL, article.getArticleMainImageUrl());
        articleContentValues.put(UrockDbHelper.ARTICLE_IS_FAVOURITE, article.isArticleFavourite());

        return articleContentValues;
    }

    @NonNull
    public ArrayList<Article> getArticlesFromLocalDb(final UrockDbHelper urockDbHelper){

        final SQLiteDatabase database = urockDbHelper.getReadableDatabase();
        Cursor cursor = null;
        final ArrayList<Article> articles = new ArrayList<>();

        if(database != null) {
            cursor = database.query(UrockDbHelper.TABLE_ARTICLES,
                    null, null, null, null, null, UrockDbHelper.ARTICLE_ID);
        }

        if(cursor != null){
            while (cursor.moveToNext()) {
                articles.add(getSingleArticle(cursor));
            }
            cursor.close();
            database.close();
        }
        return articles;
    }

    @NonNull
    private Article getSingleArticle(@NonNull final Cursor cursor){
        return new Article(
            cursor.getLong(cursor.getColumnIndex(UrockDbHelper.ARTICLE_ID)),
                cursor.getString(cursor.getColumnIndex(UrockDbHelper.ARTICLE_TITLE)),
                cursor.getString(cursor.getColumnIndex(UrockDbHelper.ARTICLE_TEXT)),
                cursor.getInt(cursor.getColumnIndex(UrockDbHelper.ARTICLE_CATEGORY_ID)),
                cursor.getLong(cursor.getColumnIndex(UrockDbHelper.ARTICLE_SERVER_ID)),
                cursor.getString(cursor.getColumnIndex(UrockDbHelper.ARTICLE_MAIN_IMAGE_URL)),
                cursor.getString(cursor.getColumnIndex(UrockDbHelper.ARTICLE_AUTHOR)),
                cursor.getString(cursor.getColumnIndex(UrockDbHelper.ARTICLE_DATE_PUBLISHED)),
                Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(UrockDbHelper.ARTICLE_IS_FAVOURITE)))
        );
    }

    private boolean isFreshArticle(final UrockDbHelper urockDbHelper, final long articleServerId){
        final SQLiteDatabase database = urockDbHelper.getReadableDatabase();

        final String selection = UrockDbHelper.ARTICLE_SERVER_ID + " = ?";
        final String[] selectionArgs = new String[]{String.valueOf(articleServerId)};

        final Cursor cursor = database .query(UrockDbHelper.TABLE_ARTICLES,
                new String[]{UrockDbHelper.ARTICLE_SERVER_ID},
                selection,
                selectionArgs,
                null,
                null,
                UrockDbHelper.ARTICLE_ID);
        final boolean isFresh = cursor.getCount() == 0;
        Log.i(TAG, "isFresh: " + isFresh);
        database.close();
        cursor.close();
        return isFresh;
    }
}
