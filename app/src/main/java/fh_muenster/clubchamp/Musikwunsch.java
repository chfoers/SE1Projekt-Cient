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
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;

public class Musikwunsch extends AppCompatActivity {

    //private ArrayList<String> arrayList;
   // private ArrayAdapter<String> adapter;
    EditText lied;
    EditText inter;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musikwunsch);
        lied = (EditText) findViewById(R.id.wunsch);
        inter = (EditText) findViewById(R.id.etInterpret);
        //ListView wuensche = (ListView) findViewById(R.id.lvw);
        //String[] items = {"Test1","Test2","Test3"};
        //arrayList = new ArrayList<>(Arrays.asList(items));
       //adapter=new ArrayAdapter<String>(this, R.layout.activity_musikliste, R.id.txtv, arrayList);
        pref = getApplicationContext().getSharedPreferences("shared_preferences", 0);
        //wuensche.setAdapter(adapter);



        setupWunsch();
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
                startActivity(new Intent (Musikwunsch.this, User.class));

                break;

            case R.id.item4 :
                startActivity(new Intent (Musikwunsch.this, Musikliste.class));

                break;



        }
        return true;
    }

    public void setupWunsch() {
        Button wunsch = (Button) findViewById(R.id.button_wabgeben);


        View.OnClickListener myListener = new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (lied.getText().length() != 0 && lied.getText().toString() != "" && inter.getText().toString() != "" && inter.getText().length() != 0){
                    new WunschAsync().execute();

                }
                else{


                }
                //EditText wun = (EditText) findViewById(R.id.wunsch);
                //String wu = wun.getText().toString();
                //arrayList.add(wu);
                //adapter.notifyDataSetChanged();
                //wun.setText("");

            }

        };
        wunsch.setOnClickListener(myListener);

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

                Toast.makeText(Musikwunsch.this,"Logged out", Toast.LENGTH_LONG).show();
            }
            else {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(Musikwunsch.this,"Logged out", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Musikwunsch.this, MainActivity.class));
                finish();
            }
        }
    }

    class WunschAsync extends AsyncTask<String, String, String> {

        private String l = lied.getText().toString();
        private String i = inter.getText().toString();
        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                AQLClubChampWebServiceServiceSoapBinding service = new AQLClubChampWebServiceServiceSoapBinding();
                try {
                    return service.musikWuenschen(pref.getString("Session", null),l ,i);

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

                Toast.makeText(Musikwunsch.this,"fehlgeschlagen", Toast.LENGTH_LONG).show();
            }
            else {


                Toast.makeText(Musikwunsch.this,"Musik erfolgreich eingereicht", Toast.LENGTH_LONG).show();
                lied.setText("");
                inter.setText("");


            }
        }
    }
}
