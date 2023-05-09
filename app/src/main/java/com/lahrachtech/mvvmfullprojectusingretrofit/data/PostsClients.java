package com.lahrachtech.mvvmfullprojectusingretrofit.data;

import com.lahrachtech.mvvmfullprojectusingretrofit.bojo.ModelPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClients {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostsClients INSTENCE;

    public PostsClients(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }
    public static PostsClients getINSTENCE() {
        if (INSTENCE == null){
            INSTENCE = new PostsClients();
        }
        return INSTENCE;
    }

    public Call<List<ModelPost>> getPosts(){
        return postInterface.getPosts();
    }
}
