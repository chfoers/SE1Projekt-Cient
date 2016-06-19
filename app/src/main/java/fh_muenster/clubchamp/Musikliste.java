package fh_muenster.clubchamp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;
import fh_muenster.webservices.AQLmusikWuenscheAusgebenResponse;

/**
 * Ausgeben der Musikliste
 * @author Carlo Eefting
 */
public class Musikliste extends AppCompatActivity {

    SharedPreferences pref;

    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musikliste);
        pref = getApplicationContext().getSharedPreferences("shared_preferences", 0);
        ListView wuensche = (ListView) findViewById(R.id.lvw);
        //lvLike();
        String[] items = {};
        arrayList = new ArrayList<String>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(Musikliste.this, R.layout.activity_musikliste, R.id.txtv, arrayList);
        wuensche.setAdapter(adapter);
        new WuenscheAusgebenAsync().execute();

        adapter.notifyDataSetChanged();


    }


   /* private void lvLike() {
        ListView lv = (ListView) findViewById(R.id.lvw);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                adapter.getItemIdAtPosition(position);

                //new likenAsync().execute();

            }
        });
    }
*/

    /**
     *
     * Menü angelegt
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                new LogoutAsync().execute();
                finish();


                break;
            case R.id.item4:
                Toast.makeText(Musikliste.this,"Du bist bereits auf der Seite", Toast.LENGTH_SHORT).show();

                break;

            case R.id.item3:
                startActivity(new Intent(Musikliste.this, Musikwunsch.class));

                break;

        }
        return true;
    }
    /*class likenAsync extends AsyncTask<Void, String, String> {


        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(Void... strings) {

            try {
                AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();

                try {
                    String o = service.musikWuenscheAusgeben().toString();
                    Log.i("LOGGING: ", o);
                    return o;
                } catch (Exception e) {
                    return " ";
                }
            } catch (Exception e) {
                return " ";
            }

        }


        protected void onPostExecute(String result) {

            Log.i("LOG: ", result);
            if (result.equals(" ")) {

            } else {

            }


        }
    }*/

    /**
     * @author Carlo Eefting
     */
    class WuenscheAusgebenAsync extends AsyncTask<Void, String, String> {


        @Override
        protected void onPreExecute() {

        }

        /**
         *
         * @param strings
         * @return
         */
        @Override
        protected String doInBackground(Void... strings) {

            try {
                AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();

                try {
                    String o = service.musikWuenscheAusgeben().toString();
                    Log.i("LOGGING: ", o);
                    return o;
                } catch (Exception e) {
                    return " ";
                }
            } catch (Exception e) {
                return " ";
            }

        }

        /**
         *
         * @param result
         */

        protected void onPostExecute(String result) {

            Log.i("LOG: ", result);
            if (result.equals(" ")) {

            } else {
                dMusic(result);
                adapter.notifyDataSetChanged();
            }


        }

        /**
         *
         * @param result
         */
        private void dMusic(String result) {
            String[] re = result.split(", ");

            for (int i = 0; i < re.length; i++) {
                arrayList.add(re[i]);

            }

        }
    }

    /**
     * @author Carlo Eefting
     */

    class LogoutAsync extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {

        }

        /**
         *
         * @param strings
         * @return
         */
        @Override
        protected String doInBackground(String... strings) {
            try {
                AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();
                try {
                    return service.logout(pref.getString("Session", null));

                } catch (Exception e) {
                    return " ";
                }
            } catch (Exception e) {
                return " ";
            }
        }

        /**
         *
         * @param result
         */
        protected void onPostExecute(String result) {
            Log.i("LOG: ", result);
            if (result.equals(" ")) {

                Toast.makeText(Musikliste.this, "Logged out", Toast.LENGTH_LONG).show();
            } else {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Musikliste.this, "Logged out", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Musikliste.this, MainActivity.class));
                finish();
            }
        }


    }
}


