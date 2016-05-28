package com.ssv.keepsolid.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.ssv.keepsolid.R;
import com.ssv.keepsolid.helpers.utils.ToastHelper;
import com.ssv.keepsolid.model.LoginModelRequest;
import com.ssv.keepsolid.presenter.login_presenter.LoginPresenter;
import com.ssv.keepsolid.view.MainApplication;
import javax.inject.Inject;

public class LoginFragment extends Fragment {
    private static final String ACTION = "login";
    private static final String SERVICE = "com.braininstock.ToDoChecklist";

    @Inject
    protected LoginPresenter presenter;
    @Inject
    protected Context context;

    private EditText etLogin, etPassword;
    private Button btnLogin;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainApplication) getActivity().getApplication()).getComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        findView(view);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeLogin();
            }
        });

        return view;
    }

    private void makeLogin() {
        if (etLogin.getText().length() == 0 && etPassword.getText().length() == 0) {
            ToastHelper.toastShort(context, getString(R.string.login_password_empty));
            return;
        }
        if (etLogin.getText().length() == 0) {
            ToastHelper.toastShort(context, getString(R.string.login_empty));
            return;
        }
        if (etPassword.getText().length() == 0) {
            ToastHelper.toastShort(context, getString(R.string.password_empty));
            return;
        }

        if (etLogin.getText().length() > 0 && etPassword.getText().length() > 0) {
            LoginModelRequest loginModelRequest = new LoginModelRequest(
                    etLogin.getText().toString(),
                    etPassword.getText().toString(),
                    presenter.getDeviceId(),
                    presenter.getDeviceName(),
                    presenter.getPlatform(),
                    presenter.getPlatformVersion(),
                    presenter.getAppVersion(),
                    presenter.getLocale(),
                    presenter.getTimeZone(),
                    ACTION,
                    SERVICE);
            presenter.Login(loginModelRequest);
        }
    }

    private void findView(View view) {
        etLogin = (EditText) view.findViewById(R.id.et_login);
        etPassword = (EditText) view.findViewById(R.id.et_password);
        btnLogin = (Button) view.findViewById(R.id.btn_login);
    }
}
