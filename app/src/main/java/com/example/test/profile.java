package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.navigation.NavigationView;

public class profile extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    RadioGroup radioGroup1;
    RadioButton home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_view);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_open,R.string.navigation_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        radioGroup1=findViewById(R.id.radiogroup1);
        home=findViewById(R.id.home_radio_button);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                Intent in;
                switch (i)
                {
                    case R.id.home_radio_button:
                        in=new Intent(getBaseContext(), Home.class);
                        startActivity(in);
                        overridePendingTransition(0,0);
                        break;
                    case R.id.search_radio_button:
                        in=new Intent(getBaseContext(), search.class);
                        startActivity(in);
                        overridePendingTransition(0,0);
                        break;

                    case R.id.profile_radio_button:
                        in=new Intent(getBaseContext(), profile.class);
                        startActivity(in);
                        overridePendingTransition(0,0);
                        break;
                    default:
                        break;
                }
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemid=item.getItemId();
        if(itemid==R.id.homebutton)
        {
            Intent intent=new Intent(this,Home.class);
            startActivity(intent);
            finish();
        }
        else if(itemid==R.id.post)
        {
            Intent intent=new Intent(this,Post.class);
            startActivity(intent);
            finish();
        }
        else if(itemid==R.id.friend)
        {
            Intent intent=new Intent(this,friend.class);
            startActivity(intent);
            finish();
        }
        else if(itemid==R.id.logout)
        {
            Intent intent=new Intent(this,logout.class);
            startActivity(intent);
            finish();
        }
        return  true;
    }
}