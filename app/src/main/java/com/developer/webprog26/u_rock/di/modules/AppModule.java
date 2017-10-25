package com.developer.webprog26.u_rock.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.developer.webprog26.u_rock.data_loading.ArticlesViewModel;
import com.developer.webprog26.u_rock.data_loading.ArticlesViewModelImpl;
import com.developer.webprog26.u_rock.data_loading.DataRepository;
import com.developer.webprog26.u_rock.data_loading.DataRepositoryImpl;
import com.developer.webprog26.u_rock.data_loading.data_loading_api.DataLoadingApiManager;
import com.developer.webprog26.u_rock.data_loading.sqlite.UrockDbHelper;
import com.developer.webprog26.u_rock.helpers.interfaces.SharedPreferencesHelper;
import com.developer.webprog26.u_rock.helpers.interfaces.SharedPreferencesHelperImpl;
import com.developer.webprog26.u_rock.holders.LastActiveFragmentIndexHolder;
import com.developer.webprog26.u_rock.holders.LastActiveFragmentIndexHolderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context mAppContext;

    public AppModule(Context context) {
        this.mAppContext = context;
    }

    @Provides
    @NonNull
    @Singleton
    Context provideAppContext(){
        return mAppContext;
    }

    @Provides
    @NonNull
    @Singleton
    SharedPreferencesHelper provideSharedPreferencesHelper(SharedPreferences sharedPreferences){
        return new SharedPreferencesHelperImpl(sharedPreferences);
    }

    @Provides
    @NonNull
    @Singleton
    SharedPreferences provideSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(provideAppContext());
    }

    @Provides
    @NonNull
    @Singleton
    LastActiveFragmentIndexHolder provideLastActiveFragmentIndexHolder(){
        return new LastActiveFragmentIndexHolderImpl();
    }

    @Provides
    @NonNull
    @Singleton
    UrockDbHelper provideUrockDbHelper(Context context){
        return new UrockDbHelper(context);
    }

    @Provides
    @NonNull
    @Singleton
    DataRepository provideDataRepository(){
        return new DataRepositoryImpl();
    }

    @Provides
    @NonNull
    @Singleton
    ArticlesViewModel provideArticlesViewModel(){
        return new ArticlesViewModelImpl();
    }

    @Provides
    @NonNull
    @Singleton
    DataLoadingApiManager provideDataLoadingApiManager(){
        return new DataLoadingApiManager();
    }
}
