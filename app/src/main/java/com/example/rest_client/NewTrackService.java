package com.example.rest_client;

import com.example.rest_client.models.Track;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
public interface NewTrackService {
    @Headers("Content-Type:application/json")
    @POST("dsaApp/tracks/addtrack")
    Call<Track> Createcredenciales(@Body Track track);
}
