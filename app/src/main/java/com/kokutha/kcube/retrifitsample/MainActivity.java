package com.kokutha.kcube.retrifitsample;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.kokutha.kcube.retrifitsample.adapter.BookListAdapter;
import com.kokutha.kcube.retrifitsample.model.BookModel;
import com.kokutha.kcube.retrifitsample.model.ResultModel;
import com.kokutha.kcube.retrifitsample.network.RetrofitHelper;

import java.util.ArrayList;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BookListAdapter bookListAdapter;
    private RetrofitHelper retrofitHelper;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        bookListAdapter = new BookListAdapter();
        recyclerView.setAdapter(bookListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        progressDialog.show();
        retrofitHelper = new RetrofitHelper();
        Call<ResultModel> call = retrofitHelper.getBookList();
        call.enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                Toast.makeText(MainActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
                if (response.isSuccessful()) {
                    if (response.body().getStatus() == 1) {
                        Toast.makeText(MainActivity.this, response.body().getMessage() + "", Toast.LENGTH_SHORT).show();
                        bookListAdapter.addList(response.body().getBook());
                    }
                }
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
