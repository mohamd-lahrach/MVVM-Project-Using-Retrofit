package com.lahrachtech.mvvmfullprojectusingretrofit.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lahrachtech.mvvmfullprojectusingretrofit.bojo.ModelPost;
import com.lahrachtech.mvvmfullprojectusingretrofit.data.PostsClients;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModle extends ViewModel {
    MutableLiveData<List<ModelPost>> postMutableLiveData = new MutableLiveData<>();

    public void getPosts(){
        PostsClients.getINSTENCE().getPosts().enqueue(new Callback<List<ModelPost>>() {
            @Override
            public void onResponse(Call<List<ModelPost>> call, Response<List<ModelPost>> response) {
                postMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ModelPost>> call, Throwable t) {

            }
        });
    }
}
