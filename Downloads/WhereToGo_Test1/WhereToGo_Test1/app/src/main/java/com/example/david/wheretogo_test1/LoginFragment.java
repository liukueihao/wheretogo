package com.example.david.wheretogo_test1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.widget.LoginButton;
/**
 * Created by alanliu on 3/13/2015.
 */
public class LoginFragment extends Fragment {
    private LoginButton loginButton;
    private TextView skipLoginButton;
    private SkipLoginCallback skipLoginCallback;

    public interface SkipLoginCallback {
        void onSkipLoginPressed();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);

        loginButton = (LoginButton) view.findViewById(R.id.fb_login_button);
        loginButton.setReadPermissions("user_friends");

        skipLoginButton = (TextView) view.findViewById(R.id.skip_login_button);
        skipLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (skipLoginCallback != null) {
                    skipLoginCallback.onSkipLoginPressed();
                }
            }
        });

        return view;
    }

    public void setSkipLoginCallback(SkipLoginCallback callback) {
        skipLoginCallback = callback;
    }

}
