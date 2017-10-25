package com.developer.webprog26.u_rock.data_loading.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by webprog26 on 15.10.17.
 */

public class UrockDbHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "u_rock_database";
    private static final int DB_VERSION = 1;

    public UrockDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String TABLE_ARTICLES = "table_articles";
    public static final String ARTICLE_ID = "_id";
    public static final String ARTICLE_TITLE = "article_title";
    public static final String ARTICLE_CATEGORY_ID = "article_category_id";
    public static final String ARTICLE_SERVER_ID = "article_server_id";
    public static final String ARTICLE_MAIN_IMAGE_URL = "article_main_image_url";
    public static final String ARTICLE_TEXT = "article_text";
    public static final String ARTICLE_AUTHOR = "article_author";
    public static final String ARTICLE_DATE_PUBLISHED = "article_date_published";
    public static final String ARTICLE_IS_FAVOURITE = "article_is_favourite";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_ARTICLES + "("
            + ARTICLE_ID + " integer primary key autoincrement, "
            + ARTICLE_TITLE  + " varchar(400), "
            + ARTICLE_CATEGORY_ID + " integer, "
            + ARTICLE_SERVER_ID + " integer, "
            + ARTICLE_MAIN_IMAGE_URL+ " varchar(400), "
            + ARTICLE_TEXT+ " text, "
            + ARTICLE_AUTHOR + " varchar(200), "
            + ARTICLE_DATE_PUBLISHED + " varchar(100), "
            + ARTICLE_IS_FAVOURITE + " varchar(400))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
