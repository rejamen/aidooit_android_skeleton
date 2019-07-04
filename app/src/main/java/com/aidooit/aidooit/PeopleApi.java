package com.aidooit.aidooit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeopleApi {

    @GET("people/api/people_list/")
    Call<People[]> getPeopleList(@Query("format") String format);
}
