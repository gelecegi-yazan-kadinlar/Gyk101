package com.gyk.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText) findViewById(R.id.editTextisim);//ID'ye göre komponenti getir
        editTextPassword = (EditText) findViewById(R.id.editTextParola);
        Button buttonGirisYap = (Button) findViewById(R.id.button);

        Intent homeIntent = new Intent(MainActivity.this, HomePage.class);//Sayfa geçişlerine yarar
        homeIntent.putExtra("kisiAdi", "Furkan");//İntent kisiAdi isimli değişkeni paket olarak taşır
        startActivity(homeIntent);//Diğer aktivity'i başlatır.
        //CTRL+ALT+L
        buttonGirisYap.setOnClickListener(new View.OnClickListener() {//Butona listener ekle
            @Override
            public void onClick(View view) {//Butona tıklandığında çalışacak kod bloğu
                String isim = editTextName.getText().toString();//Edittext içindeki yazıyı almak için
                if("1234".equals(editTextPassword.getText().toString())) {//Girilen parola 1234 olduğunda if çalışır
                    Toast.makeText(MainActivity.this,
                            "İsminiz:" + isim, Toast.LENGTH_SHORT).show(); //Toast message sayfada çıkan bilgi mesajı
                    Intent homeIntent = new Intent(MainActivity.this, HomePage.class);//Sayfa geçişlerine yarar
                    homeIntent.putExtra("kisiAdi", isim);//İntent kisiAdi isimli değişkeni paket olarak taşır
                    startActivity(homeIntent);//Diğer aktivity'i başlatır.
                }else{
                    Toast.makeText(MainActivity.this, "Yanlış şifre girdin!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
