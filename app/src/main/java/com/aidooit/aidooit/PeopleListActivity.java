package com.aidooit.aidooit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleListActivity extends AppCompatActivity {

    private static final String LOG_TAG = PeopleListActivity.class.getSimpleName();
    public static final String API_URL_LOCAL = "http://192.168.1.101:8000";
    public static final String API_URL_PROD = "https://aidooit.pythonanywhere.com";


    RecyclerView recyclerView;
    PeopleAdapter adapter;
    List<People> peopleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people_list);

        peopleList = new ArrayList<>();

        recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adding some items to our list
        peopleList.add(
                new People(
                        1,
                        "Reinaldo J. Menendez",
                        "53278865",
                        "48712206",
                        "rejamen@gmail.com",
                        R.drawable.king));

        peopleList.add(
                new People(
                        2,
                        "Ivis Orea Cordero",
                        "",
                        "",
                        "ivisorea@gmail.com",
                        R.drawable.king));




        //creating recyclerview adapter
        PeopleAdapter adapter = new PeopleAdapter(this, peopleList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);




    }

    /*private void initiatePeopleApi(final View recyclerView) {
        Log.d(LOG_TAG,"initiateCupcakeApi");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL_LOCAL)
                .addConverterFactory(GsonConverterFactory.create
                        ())
                .build();
        PeopleApi api = retrofit.create(PeopleApi.class);
        Call<People[]> call = api.getPeopleList("json");

        call.enqueue(new Callback<People[]>() {
            @Override
            public void onResponse(Call<People[]> call,
                                   Response<People[]> response) {
                if (response.isSuccessful()) {
                    Log.d(LOG_TAG, "success - response is " + response.body());
                } else {
                    Log.d(LOG_TAG, "failure response is " + response.raw().toString());
                }
            }
            @Override
            public void onFailure(Call<People[]> call,
                                  Throwable t) {
                Log.e(LOG_TAG, " Error : " + t.getMessage());
            }
        });
        }*/

}
