package com.gyk.loginapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*Project Name: CustomListView
Package Name: com.gyk.customlistview
API Level: 16
Activity: Empty Activity
 */

public class HomePage extends AppCompatActivity {
    List<String> gelecegiYazanlar;// Kişiler için String'lerden oluşan liste referansı
    EditText editTextPersonName;
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        gelecegiYazanlar = new ArrayList<>(); // kişiler referansı ile array listi işaretleme
        gelecegiYazanlar.add("Betül"); // Listeye eleman ekleme

        ListView gykListView = (ListView) findViewById(R.id.listView);//Listview tanımlandı ID ye göre
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                HomePage.this, android.R.layout.simple_list_item_1,//Hazır görünüş layoutu
                android.R.id.text1,
                gelecegiYazanlar);//gösterilecek dizi
        gykListView.setAdapter(adapter);//ListView'a adaptörü bağlamak

        String isim = getIntent().getStringExtra("kisiAdi"); // İntent'ten kisiAdi'ni almak
        TextView messageTextView = (TextView) findViewById(R.id.textViewMessage);//TextView tanımlaması
        messageTextView.setText("Hoş geldin geleceği yazan kadın: " + isim);//Text view içeriği değiştirme

        editTextPersonName = (EditText) findViewById(R.id.editTextPersonName);
        Button buttonAddPerson = (Button) findViewById(R.id.buttonAddPerson);
        Toast.makeText(HomePage.this, "Kişi sayısı:"
                + gelecegiYazanlar.size(), Toast.LENGTH_SHORT).show(); // List.size() listenin boyutunu döndürür
        buttonAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gelecegiYazanlar.add(editTextPersonName.getText().toString());
                Toast.makeText(HomePage.this, "Kişi sayısı:" + gelecegiYazanlar.size(), Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();//adapter listeyi  ve listview görünüşünü günceller
            }
        });
        /*String[] gelecegiYazanlar = {"Betül","Çağla","Çise",
                "Ebru", "Eda Nur","Elif","Esra","Miray","Mürvet",
                "Nazlı","Özge","Pamela","Rukiye","Rüveyda","Songül",
                "Şuheda","Tuba","Verda"};//Kişi listesi tanımlandı */


       KafasiniKirdiğim();



    }

    public  void KafasiniKirdiğim() {


        try {
            Log.d("Bunu", "KafasiniKirdiğim: "+ new MyTask().execute().get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class MyTask extends AsyncTask<Void, Void, ArrayList<String>> {

        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            String title ="";
            Document doc = null;
            ArrayList<String> result = new ArrayList<String>();

            try {
                doc = Jsoup.connect("https://keyserver.ubuntu.com/pks/lookup?search=saruhan&fingerprint=on&op=index").get();

                title = doc.title();

                Elements links = doc.select("pre");
                title = links.toString();
                for (Element link : links) {

                    result.add(link.text());
                    //System.out.println("\nText:" + link.text());
                    //Log.e("Dizi", String.valueOf(result));

                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("istek", "doInBackground: "+e);
            }catch (Exception e){
                Log.d("istek", "doInBackground: "+e);
            }
            Log.e("Dizi", String.valueOf(result));
            return result;
        }


        @Override
        protected void onPostExecute(ArrayList<String> result) {
            //if you had a ui element, you could display the title
            Log.d("İstek", "onPostExecute: "+result);
        }
    }
}
