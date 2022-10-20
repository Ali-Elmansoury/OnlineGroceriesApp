package com.example.onlinegroceriesapp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlinegroceriesapp.models.Products;
import com.example.onlinegroceriesapp.repository.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends ViewModel {

    public MutableLiveData<List<Products>> listMutableLiveData = new MutableLiveData<>();
    Repository repo = new Repository();
    public void getData(){
        Call<List<Products>> call = repo.getJewelery();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<Products>> listMutableLiveData1 = new MutableLiveData<>();
    Repository repo1 = new Repository();
    public void getData1(){
        Call<List<Products>> call = repo1.getElectronics();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                listMutableLiveData1.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<Products>> listMutableLiveData2 = new MutableLiveData<>();
    Repository repo2 = new Repository();
    public void getData2(){
        Call<List<Products>> call = repo2.getMen();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                listMutableLiveData2.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }

    public MutableLiveData<List<Products>> listMutableLiveData3 = new MutableLiveData<>();
    Repository repo3 = new Repository();
    public void getData3(){
        Call<List<Products>> call = repo3.getWomen();
        call.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                listMutableLiveData3.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

            }
        });
    }
}
