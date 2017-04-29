package lottery.dhbk.nvmdung.lottery.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import lottery.dhbk.nvmdung.lottery.R;

public class ResultActivity extends AppCompatActivity {

    TextView txtpname;
    EditText edtdate;
    Button btnsearch;
    String JSON ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtpname = (TextView) findViewById(R.id.textViewProvince);
        btnsearch = (Button) findViewById(R.id.buttonSearch);
        edtdate = (EditText) findViewById(R.id.editTextDate);

        Bundle bd =  getIntent().getExtras();

        String provinceName = bd.getString("provinceName");
        final String provinceCode = bd.getString("provinceCode");
        txtpname.setText(provinceName);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://thanhhungqb.tk:8080/kqxsmn");
            }
        });

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentAward fragmentAward = (FragmentAward) getFragmentManager().findFragmentById(R.id.FragmentListResults);
                try {
                    JSONObject root = new JSONObject(JSON);
                    JSONObject Code = root.getJSONObject(provinceCode);
                    JSONObject s = Code.getJSONObject(edtdate.getText().toString());
                    fragmentAward.showAwards(s);
                } catch (JSONException e) {
                    Toast.makeText(ResultActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private class ReadJSON extends AsyncTask<String, Integer, String > {

        @Override
        protected String doInBackground(String... params) {
            String kq = docNoiDung_Tu_URL(params[0]);
            return kq;
        }

        @Override
        protected void onPostExecute(String s) {
            JSON = s;
            
        }
    }

    private static String docNoiDung_Tu_URL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
