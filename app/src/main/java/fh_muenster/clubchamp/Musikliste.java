package fh_muenster.clubchamp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;
import fh_muenster.webservices.AQLmusikWuenscheAusgebenResponse;

public class Musikliste extends AppCompatActivity {

    SharedPreferences pref;
    String[] items = {};
    //private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musikliste);
        pref = getApplicationContext().getSharedPreferences("shared_preferences", 0);
        ListView wuensche = (ListView) findViewById(R.id.lvw);
        //arrayList = new ArrayList<String>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(Musikliste.this, android.R.layout.simple_list_item_1, items);
        wuensche.setAdapter(adapter);
        new WuenscheAusgebenAsync().execute();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1 :
                new LogoutAsync().execute();


                break;
            case R.id.item2 :
                startActivity(new Intent (Musikliste.this, User.class));

                break;

            case R.id.item3:
                startActivity(new Intent (Musikliste.this, Musikwunsch.class));

                break;

        }
        return true;
    }

    class WuenscheAusgebenAsync extends AsyncTask<String, String, String> {




        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();
                try {
                    int i = 0;
                    String res;
                    //service.musikWuenscheAusgeben().getPropertyCount()
                    while(i < 3){
                    String re = (String) service.musikWuenscheAusgeben().getProperty(i);
                       Log.i("LOG pr: ", re);
                        i++;

                      //adapter.notifyDataSetChanged();
                   }

                    /*String res =  service.musikWuenscheAusgeben().getProperty(0).toString();
                    String res1 =  service.musikWuenscheAusgeben().getProperty(1).toString();
                    String res2 =  service.musikWuenscheAusgeben().getProperty(2).toString();
                    Integer res3 = service.musikWuenscheAusgeben().getPropertyCount();
                    Log.i("LOG: ", res);
                    Log.i("LOG: ", res1);
                    Log.i("LOG: ", res2);
                    Log.i("LOG: ", res3.toString());
                    */
                    return "ok";

                } catch (Exception e) {
                    return " ";
                }
            } catch (Exception e) {
                return " ";
            }
        }
        protected void onPostExecute(String result) {
            Log.i("LOG: ", result);
            if(result.equals(" ")){

            }
            else {
                adapter.add(result);
                adapter.notifyDataSetChanged();

            }
        }
    }
    class LogoutAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();
                try {
                    return service.logout(pref.getString("Session", null));

                } catch (Exception e) {
                    return " ";
                }
            }


            catch(Exception e){return " ";
            }
        }


        protected void onPostExecute(String result) {
            Log.i("LOG: ", result);
            if(result.equals(" ")){

                Toast.makeText(Musikliste.this,"Logged out", Toast.LENGTH_LONG).show();
            }
            else {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Musikliste.this,"Logged out", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Musikliste.this, MainActivity.class));
                finish();
            }
        }
    }
}
