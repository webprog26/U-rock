package com.developer.webprog26.u_rock.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Base class for application {@link Fragment} classes
 */

public abstract class BaseFragment extends Fragment {

    protected Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent();
    }

    /**
     * Sets up dagger component with lifecycle similar to current fragment
     */
    protected abstract void setupFragmentComponent();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != null) {
            unbinder.unbind();
        }
    }

    /**
     * Initializes {@link Unbinder} instance to break {@link android.view.View} bindings when it has been destroyed
     * to avoid memory leaks
     * @param unbinder {@link Unbinder}
     */
    protected void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }
}
