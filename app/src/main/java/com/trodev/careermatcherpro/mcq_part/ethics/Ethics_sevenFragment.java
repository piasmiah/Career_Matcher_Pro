package com.trodev.careermatcherpro.mcq_part.ethics;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.trodev.careermatcherpro.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Ethics_sevenFragment extends Fragment {

    private static final String json_url = "https://zobayer-dev-e12aa.web.app/ethics_mcq.json";
    RecyclerView recyclerView;
    List<EthicsModel> list;
    ProgressBar progressBar;

    public Ethics_sevenFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ethics_seven, container, false);

        /*init views*/
        recyclerView = view.findViewById(R.id.dataRv);
        progressBar = view.findViewById(R.id.progress_bar);

        progressBar.setVisibility(View.VISIBLE);
        list = new ArrayList<>();

        loadData();

        return view;
    }

    private void loadData() {

        /*which fragments load data init it*/
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
                JSONArray jsonArray = jsonObject.getJSONArray("ethics_seven");

                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    /*create model class variable, object*/
                    EthicsModel modelClass = new EthicsModel();

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

    private void PutDataIntoRecyclerview(List<EthicsModel> list) {

        progressBar.setVisibility(View.INVISIBLE);
        EthicsAdapter customAdapter = new EthicsAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(customAdapter);

    }

}