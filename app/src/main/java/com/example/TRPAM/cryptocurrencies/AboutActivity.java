package com.example.TRPAM.cryptocurrencies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    TextView fb,ig,tw,em,rate,bug;

    private ResideMenu resideMenu;
    private ResideMenuItem itemTrending;
    private ResideMenuItem itemAbout;
    private ResideMenuItem itemAll;
    private ResideMenuItem itemConverter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        fb = findViewById(R.id.fb1);
        fb.setMovementMethod(LinkMovementMethod.getInstance());
        ig = findViewById(R.id.ig1);
        ig.setMovementMethod(LinkMovementMethod.getInstance());
        tw = findViewById(R.id.tw1);
        tw.setMovementMethod(LinkMovementMethod.getInstance());
        em = findViewById(R.id.em1);
        em.setMovementMethod(LinkMovementMethod.getInstance());
        rate = findViewById(R.id.rate1);
        rate.setMovementMethod(LinkMovementMethod.getInstance());
        bug = findViewById(R.id.bug1);
        bug.setMovementMethod(LinkMovementMethod.getInstance());

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        TextView title = toolbar.findViewById(R.id.txt_title);

        title.setText("About");

        setupMenu();


    }

    private void setupMenu() {

        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.gradient_background);
        resideMenu.attachToActivity(this);

        itemTrending = new ResideMenuItem(this, R.drawable.trending, "Trending");
        itemAll = new ResideMenuItem(this, R.drawable.dashboard, "Top Crypto");
        itemConverter = new ResideMenuItem(this, R.drawable.converter, "Converter");
        itemAbout = new ResideMenuItem(this, R.drawable.news, "About");

        itemAll.setOnClickListener(this);
        itemTrending.setOnClickListener(this);
        itemConverter.setOnClickListener(this);
        itemAbout.setOnClickListener(this);

        resideMenu.addMenuItem(itemTrending, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemAll, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemConverter, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemAbout, ResideMenu.DIRECTION_LEFT);

        resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.btn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view == itemAll) {
            Intent i = new Intent(AboutActivity.this, AllCryptosActivity.class);
            startActivity(i);
            Toast.makeText(this, "Click To See Details", Toast.LENGTH_SHORT).show();
        } else if (view == itemTrending) {
            Intent i = new Intent(AboutActivity.this, MainActivity.class);
            startActivity(i);
            Toast.makeText(this, "Click To See Details", Toast.LENGTH_SHORT).show();
        } else if (view == itemAbout) {

        } else if (view == itemConverter) {
            Intent i = new Intent(AboutActivity.this, ConverterActivity.class);
            startActivity(i);
        }

        resideMenu.closeMenu();
    }


    public ResideMenu getResideMenu() {
        return resideMenu;
    }

}