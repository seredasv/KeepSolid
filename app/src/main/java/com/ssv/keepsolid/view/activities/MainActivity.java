package com.ssv.keepsolid.view.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ssv.keepsolid.R;
import com.ssv.keepsolid.view.MainApplication;
import com.ssv.keepsolid.view.fragments.LoginFragment;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    protected Context context;

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MainApplication) getApplication()).getComponent().inject(this);
        fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            openFragment(LoginFragment.newInstance(), true);
        }
    }

    protected void openFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = fm.beginTransaction();
        if (addToBackStack) {
            transaction
                    .addToBackStack(fragment.getClass().getSimpleName())
                    .replace(R.id.container, fragment, fragment.getClass().getSimpleName())
                    .commit();
        } else {
            transaction.replace(R.id.container, fragment).commit();
        }
    }
}
