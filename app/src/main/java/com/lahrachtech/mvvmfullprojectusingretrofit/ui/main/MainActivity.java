package com.lahrachtech.mvvmfullprojectusingretrofit.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.lahrachtech.mvvmfullprojectusingretrofit.R;
import com.lahrachtech.mvvmfullprojectusingretrofit.bojo.ModelPost;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostViewModle postViewModle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModle = ViewModelProviders.of(this).get(PostViewModle.class);
        postViewModle.getPosts();
        RecyclerView recyclerView = findViewById(R.id.postsRecyclerView);
        PostAdapter postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

        postViewModle.postMutableLiveData.observe(this, modelPosts -> {
            postAdapter.setList(modelPosts);
        });

    }
}