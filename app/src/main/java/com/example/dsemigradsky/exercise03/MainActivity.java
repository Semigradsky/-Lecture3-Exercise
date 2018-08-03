package com.example.dsemigradsky.exercise03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            RecyclerView list = findViewById(R.id.pokemonList);
            int itemPosition = list.getChildLayoutPosition(view);

            Intent intent = new Intent(MainActivity.this, PokemonInfoActivity.class);
            intent.putExtra(PokemonInfoActivity.ID, itemPosition + 1);

            startActivity(intent);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.pokemonList);
        list.setAdapter(new PokemonRecyclerAdapter(this, DataUtil.generatePokemons(), onClickListener));
    }
}
