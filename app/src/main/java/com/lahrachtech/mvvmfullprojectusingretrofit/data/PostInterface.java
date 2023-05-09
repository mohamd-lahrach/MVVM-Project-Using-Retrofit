package com.lahrachtech.mvvmfullprojectusingretrofit.data;

import com.lahrachtech.mvvmfullprojectusingretrofit.bojo.ModelPost;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    Call<List<ModelPost>> getPosts();
}
