package com.developer.webprog26.u_rock.holders;

/**
 * Created by webprog on 17.09.17.
 */

public class ActiveFragmentIndexHolder {

    private int mActiveFragmentIndex = 0;

    private static ActiveFragmentIndexHolder instance;

    private ActiveFragmentIndexHolder() {}

    public static ActiveFragmentIndexHolder getInstance(){
        if(instance == null) {
            instance = new ActiveFragmentIndexHolder();
        }
        return instance;
    }

    public int getActiveFragmentIndex() {
        return mActiveFragmentIndex;
    }

    public void setActiveFragmentIndex(int activeFragmentIndex) {
        this.mActiveFragmentIndex = activeFragmentIndex;
    }
}
