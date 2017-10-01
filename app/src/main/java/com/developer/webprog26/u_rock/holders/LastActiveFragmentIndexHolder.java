package com.developer.webprog26.u_rock.holders;

/**
 * Declares method which should be implemented by class, that provides storing last active {@link android.support.v4.app.Fragment} index
 */

public interface LastActiveFragmentIndexHolder {

    String LAST_ACTIVE_FRAGMENT_INDEX_TAG = "saved_fragment_index_tag";

    /**
     * Returns last active {@link android.support.v4.app.Fragment} index
     * @return int
     */
    int getLastActiveFragmentIndex();

    /**
     * Stores given active {@link android.support.v4.app.Fragment} index
     * @param lastActiveFragmentIndex int
     */
    void saveLastActiveFragmentIndex(final int lastActiveFragmentIndex);
}
