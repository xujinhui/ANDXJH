package com.example.a02kotlin;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class ThreeActivity extends AppCompatActivity {


//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        NavController nav = Navigation.findNavController (this,R.id.fragment_threeVC);
        NavigationUI.setupActionBarWithNavController(this,nav);
    }

    @Override
    public boolean onSupportNavigateUp() {

        NavController nav = Navigation.findNavController (this,R.id.fragment_threeVC);
        return   nav.navigateUp();
//        return  super.onSupportNavigateUp();
    }
}
