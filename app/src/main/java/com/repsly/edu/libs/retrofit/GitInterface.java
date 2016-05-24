package com.repsly.edu.libs.retrofit;

import com.repsly.edu.libs.models.ItemForSending;
import com.repsly.edu.libs.models.OneModel;
import com.repsly.edu.libs.models.UserSearch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 */
public interface GitInterface {
    @GET("users/{user}/repos")
    Call<List<OneModel>> listRepos(@Path("user") String user);

    @GET("/search/users")
    Call<UserSearch> getSearchResult(@Query("q") String name);

    @POST("/1f12fel1")
    Call<ItemForSending> sendSomething(@Body ItemForSending some);

}
