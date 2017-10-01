package com.developer.webprog26.u_rock.app;

import android.app.Application;

import com.developer.webprog26.u_rock.di.components.AppComponent;
import com.developer.webprog26.u_rock.di.components.DaggerAppComponent;
import com.developer.webprog26.u_rock.di.modules.AppModule;

public class URockApplication extends Application {

    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = initAppComponent();
    }

    @SuppressWarnings("deprecation")
    protected AppComponent initAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent(){
        return mAppComponent;
    }
}
