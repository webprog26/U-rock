package com.developer.webprog26.u_rock.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import butterknife.Unbinder;

/**
 * Created by webprog on 15.09.17.
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

    protected void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }
}
