package com.example.onlinegroceriesapp.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.onlinegroceriesapp.models.Products;
import com.example.onlinegroceriesapp.repository.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenViewModel extends ViewModel {

   public MutableLiveData<List<Products>> listMutableLiveData = new MutableLiveData<>();
   Repository repo = new Repository();
   public void getData(){
       Call<List<Products>> call = repo.getProducts();
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
}
