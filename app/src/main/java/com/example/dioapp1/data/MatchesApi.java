package com.example.dioapp1.data;

import java.util.List;
import com.example.dioapp1.domain.Match;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MatchesApi {
    @GET("matches.json")
    Call<List<Match>> getMatches();
}