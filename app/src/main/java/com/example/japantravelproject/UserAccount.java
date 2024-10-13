package com.example.japantravelproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class UserAccount {
    private String idToken;

    public UserAccount() {

    }

    public String getIdToken() {
        return idToken;
    }

    public Void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    private String idToken;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    private String emailId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
}