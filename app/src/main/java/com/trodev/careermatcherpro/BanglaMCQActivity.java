package com.trodev.careermatcherpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BanglaMCQActivity extends AppCompatActivity {

    private static final String json_url = "https://zobayer-dev-e12aa.web.app/bangla_mcq.json";
    RecyclerView recyclerView;
    List<McqModel> list;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangla_mcqactivity);


        // set title in activity
        getSupportActionBar().setTitle("বাংলা ভাষা ও সাহিত্য");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*init views*/
        recyclerView = findViewById(R.id.dataRv);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setVisibility(View.VISIBLE);
        list = new ArrayList<>();

        GetData getData = new GetData();
        getData.execute();

    }


    public class GetData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {

            String current = "";

            URL url;
            HttpURLConnection urlConnection = null;

            try {

                url = new URL(json_url);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();

                while (data != -1) {
                    current += (char) data;
                    data = inputStreamReader.read();
                }

                return current;
            } catch (Exception e) {

            } finally {
                if (urlConnection != null) {

                    urlConnection.disconnect();
                }
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            try {

                progressBar.setVisibility(View.INVISIBLE);

                JSONObject jsonObject = new JSONObject(s);

                // database info
                JSONArray jsonArray = jsonObject.getJSONArray("bangla_first");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    /*create model class variable, object*/
                    McqModel modelClass = new McqModel();

                    /*set data on recyclerview*/
                    modelClass.setMcq_no(jsonObject1.getString("mcq_no"));

                    modelClass.setGrp_ques(jsonObject1.getString("grp_ques"));

                    modelClass.setFirst(jsonObject1.getString("first"));

                    modelClass.setSecond(jsonObject1.getString("second"));

                    modelClass.setThird(jsonObject1.getString("third"));

                    modelClass.setFourth(jsonObject1.getString("fourth"));

                    modelClass.setAns(jsonObject1.getString("ans"));


                    /*add model data on empty model class*/
                    list.add(modelClass);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            PutDataIntoRecyclerview(list);
        }
    }

    private void PutDataIntoRecyclerview(List<McqModel> list) {

        progressBar.setVisibility(View.INVISIBLE);
        McqAdapter customAdapter = new McqAdapter(getApplicationContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(customAdapter);

    }
}
