package fh_muenster.clubchamp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fh_muenster.webservices.AQLClubChampWebServiceServiceSoapBinding;

/**
 * @author Carlo Eefting
 */
public class Registrierung extends AppCompatActivity {

    EditText regiEmail;
    EditText regiUser;
    EditText regiPW;
    Button b;


    /**
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regi);
        regiEmail = (EditText) findViewById(R.id.email_regis);
        regiUser = (EditText) findViewById(R.id.regiUser);
        regiPW = (EditText) findViewById(R.id.regiPW);
        b = (Button) findViewById(R.id.button_registrieren);

        setupRegi();
    }

    /**
     *
     */
    public void setupRegi() {





        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (regiEmail.getText().length() != 0 && regiEmail.getText().toString() != "" &&
                        regiUser.getText().toString() != "" && regiUser.getText().length() != 0 &&
                        regiPW.getText().toString() != "" && regiPW.getText().length() != 0){

                    new RegiAsync().execute();

                }
                else{
                    Toast.makeText(Registrierung.this,"Bitte füll alle Felder aus", Toast.LENGTH_LONG).show();
                }
            }

        });


    }

    /**
     * @author Carlo Eefting
     */
  class RegiAsync extends AsyncTask<String, String, String> {

      private String regiMail = regiEmail.getText().toString();
      private String regiUse = regiUser.getText().toString();
      private String regiPas = regiPW.getText().toString();



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
                  String res = service.signUp(regiMail, regiUse,regiPas).toString();
                  return res;
                  //return service.signUp(regiMail, regiUse,regiPas);

              } catch (Exception e) {
                  return " ";
              }
          }


          catch(Exception e){return " ";
          }
      }

        /**
         *
         * @param result
         */
      protected void onPostExecute(String result) {
          Log.i("LOG: ", result);
          if(result.equals(" ")){

              Toast.makeText(Registrierung.this,"Registrierung fehlgeschlagen", Toast.LENGTH_LONG).show();
          }
          else {
              //editor.putString("Email", regiEmail.getText().toString());
              //editor.putString("Username", regiUser.getText().toString());
              //editor.putString("Password", regiPW.getText().toString());

              Toast.makeText(Registrierung.this, "Registrierung erfolgreich", Toast.LENGTH_LONG).show();
              startActivity(new Intent(Registrierung.this, Musikwunsch.class));
              finish();
          }
      }
  }
}
