package com.example.androidlearning.spring;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created by fcwl on 6/9/2015.
 */
public class ProxyAuthenticator extends Authenticator {

    private String user, password;

    public ProxyAuthenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(user, password.toCharArray());
    }
}
