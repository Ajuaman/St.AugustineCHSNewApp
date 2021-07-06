package com.example.staugustinechsnewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //INITIATE SOME FIREBASE SETTINGS
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().build();
        FirebaseFirestore.getInstance().setFirestoreSettings(settings);

        //FIREBASE MESSAGING SETTINGS
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView,navController);

    }

    private void init(Bundle savedInstanceState) {
        if(savedInstanceState == null) {
            //IF THE USER ISN'T SIGNED INTO FIREBASE, GO TO LOGIN ACTIVITY
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }
    }
}