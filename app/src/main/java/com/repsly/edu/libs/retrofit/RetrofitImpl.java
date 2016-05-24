package com.repsly.edu.libs.retrofit;

import com.repsly.edu.libs.models.OneModel;
import com.repsly.edu.libs.models.UserSearch;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tomkan on 19.5.2016..
 */
public class RetrofitImpl {
    String url;
    String searchName;

    public RetrofitImpl(String url) {
        this.url = url;
    }

    public RetrofitImpl setSearchName(String name) {
        this.searchName = name;
        return this;
    }

    public List<OneModel> getRepos() {
        HttpLoggingInterceptor hli = new HttpLoggingInterceptor();
        hli.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(hli);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        GitInterface service = retrofit.create(GitInterface.class);
        Call<List<OneModel>> repos = service.listRepos("octocat");
        List<OneModel> repoooo = null;
        try {
            repoooo = repos.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return repoooo;
    }

    public UserSearch getSearchResults() {
        HttpLoggingInterceptor hli = new HttpLoggingInterceptor();
        hli.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(hli);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        GitInterface service = retrofit.create(GitInterface.class);
        Call<UserSearch> call = service.getSearchResult(searchName);
        UserSearch result = null;
        try {
            result = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
