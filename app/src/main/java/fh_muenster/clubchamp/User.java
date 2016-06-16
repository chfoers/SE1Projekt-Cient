package fh_muenster.clubchamp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;

public class User extends AppCompatActivity {

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        pref = getApplicationContext().getSharedPreferences("shared_preferences", 0);

        TextView username = (TextView) findViewById(R.id.tvUsername);
        TextView email = (TextView) findViewById(R.id.tvEmail);

        username.setText( pref.getString("Session", null));
        email.setText(pref.getString("Email", null));

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
            case R.id.item3 :
                startActivity(new Intent(User.this, Musikwunsch.class));
                finish();
                break;
        }
        return true;
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

                Toast.makeText(User.this,"Logged out", Toast.LENGTH_LONG).show();
            }
            else {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(User.this,"Logged out", Toast.LENGTH_LONG).show();
                startActivity(new Intent(User.this, MainActivity.class));
                finish();
            }
        }
    }
}
