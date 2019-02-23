package com.tae.a101newjwtlogin;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;


import com.tae.a101newjwtlogin.adapter.PetAdapter;
import com.tae.a101newjwtlogin.dao.Pet;
import com.tae.a101newjwtlogin.dao.PetDatabase;
import com.tae.a101newjwtlogin.managers.DataManager;

import java.util.List;

public class PetActivity extends AppCompatActivity {
    public RecyclerView recyclerView;
    public List<Pet> pets = null;
    public DataManager dataManager;
    public PetDatabase petDatabase;
    public PetAdapter petAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);

//        pets = (List<Pet>) getIntent().getSerializableExtra("start");

        dataManager = DataManager.getInstance();
        petDatabase = dataManager.getDatabase();
        pets = petDatabase.petDao().fetchAllPets();

        recyclerView = findViewById(R.id.pets_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PetAdapter(this, pets));

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        petAdapter = new PetAdapter(this,this.pets);
        searchView = findViewById(R.id.searchView);

        CardView cardView = findViewById(R.id.card_view);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println(query+ "  !!!!!!!!!!!!!!!#!#!##!!#!!#!#");
                        petAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                petAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

}