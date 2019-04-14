package com.gyk.haberapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//https://codeshare.io/5gvnz8
public class MainActivity extends AppCompatActivity {
    List<NewsSite> newsSiteList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsSiteList = new ArrayList<>();

        newsSiteList.add(new NewsSite("Sabah","https://www.sabah.com.tr","https://isbh.tmgrup.com.tr/sbh/site/v3/i/sabah-logo-170x71.png"));
        newsSiteList.add(new NewsSite("Hürriyet","https://www.hurriyet.com.tr","http://s.hurriyet.com.tr/static/images/common/hurriyet/logo/hurriyet-logo2018.png"));
        newsSiteList.add(new NewsSite("F5Haber","https://www.f5haber.com","https://s.f5haber.com/images/F5Haber_Logo.png"));
        newsSiteList.add(new NewsSite("Posta","https://www.posta.com.tr","http://www.postagazeteilan.net/images/hurriyet_gazete_logo.png"));
        newsSiteList.add(new NewsSite("Akşam","https://www.aksam.com.tr","http://i.radikal.com.tr/480x325/2013/07/19/fft64_mf1554501.Jpeg"));


        ListView listView = (ListView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(newsSiteList,MainActivity.this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                NewsSite clickedNewsSite = newsSiteList.get(position);
                Toast.makeText(MainActivity.this,
                        ""+clickedNewsSite.getName(), Toast.LENGTH_LONG).show();

                Intent webViewIntent =
                        new Intent(MainActivity.this,WebViewActivity.class);

                webViewIntent.putExtra("siteUrl",clickedNewsSite.getUrl());
                startActivity(webViewIntent);
            }
        });


    }
}
