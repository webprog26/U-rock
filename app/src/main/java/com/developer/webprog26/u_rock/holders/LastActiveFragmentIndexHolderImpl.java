package com.developer.webprog26.u_rock.holders;

import javax.inject.Singleton;

/**
 * {@link LastActiveFragmentIndexHolder} implementation
 */
@Singleton
public class LastActiveFragmentIndexHolderImpl implements LastActiveFragmentIndexHolder{

    private int lastActiveFragmentIndex = 0;

    @Override
    public int getLastActiveFragmentIndex() {
       return lastActiveFragmentIndex;
    }

    @Override
    public void saveLastActiveFragmentIndex(final int lastActiveFragmentIndex) {
        this.lastActiveFragmentIndex = lastActiveFragmentIndex;
    }
}
