package com.developer.webprog26.u_rock.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.webprog26.u_rock.R;
import com.developer.webprog26.u_rock.app.URockApplication;
import com.developer.webprog26.u_rock.di.modules.fragments_presenters_modules.BookmarksScreenPresenterModule;
import com.developer.webprog26.u_rock.mvp.interfaces.fragments_views.BookmarksScreenView;

import butterknife.ButterKnife;

/**
 * This {@link android.support.v4.app.Fragment} works with bookmarks
 */

public class BookmarksScreenFragment extends BaseFragment implements BookmarksScreenView{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bookmarks_screen_fragment, container, false);
        setUnbinder(ButterKnife.bind(this, view));
        return view;
    }

    @Override
    protected void setupFragmentComponent() {
        URockApplication.getAppComponent().plus(new BookmarksScreenPresenterModule()).inject(this);
    }
}
