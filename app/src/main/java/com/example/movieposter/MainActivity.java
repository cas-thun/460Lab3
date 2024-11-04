package com.example.movieposter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PosterListener{

    private Button buttonAddToWatchlist;

    /**
     * Sets up the movie posters
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.posterRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchlist);

        //prepare data
        List<Poster> posterList = new ArrayList<>();

        Poster alien = new Poster();
        alien.image = R.drawable.alienromulus;
        alien.name = "Alien Romulous";
        alien.createdBy = "Fede Álvarez";
        alien.rating = 4f;
        alien.story = "Six downtrodden young space colonists encounter hostile creatures while scavenging a derelict space station.";
        posterList.add(alien);

        Poster eee = new Poster();
        eee.image = R.drawable.eeemp;
        eee.name = "Everything Everywhere All At Once";
        eee.createdBy = "Dan Kwan and Daniel Scheinert";
        eee.rating = 4f;
        eee.story = "An exhausted Chinese American woman who can't seem to finish her taxes.";
        posterList.add(eee);

        Poster dandw = new Poster();
        dandw.image = R.drawable.dandw;
        dandw.name = "Deadpool and Wolverine";
        dandw.createdBy = "Shawn Levy";
        dandw.rating = 4.5f;
        dandw.story = "Deadpool learns that the Time Variance Authority plans to destroy his universe and works with a reluctant Wolverine from another universe to stop them.";
        posterList.add(dandw);

        Poster insideout2 = new Poster();
        insideout2.image = R.drawable.insideout2;
        insideout2.name = "Inside Out 2";
        insideout2.createdBy = "Kelsey Mann";
        insideout2.rating = 3.5f;
        insideout2.story = "Riley's emotions find themselves joined by new emotions that want to take over Riley's head.";
        posterList.add(insideout2);

        Poster dune2 = new Poster();
        dune2.image = R.drawable.dunep2;
        dune2.name = "Dune: Part Two";
        dune2.createdBy = "Shawn Levy";
        dune2.rating = 4.75f;
        dune2.story = "Paul Atreides unites with the Fremen people of the desert planet Arrakis to wage war against House Harkonnen.";
        posterList.add(dune2);

        Poster beetlej = new Poster();
        beetlej.image = R.drawable.beetlej;
        beetlej.name = "Beetlejuice Beetlejuice";
        beetlej.createdBy = "Tim Burton";
        beetlej.rating = 3.4f;
        beetlej.story = "Lydia Deetz, now a mother, is struggling to keep her family together in the wake of a loss as the specter Betelgeuse returns to haunt her.";
        posterList.add(beetlej);

        Poster oppenhiemer = new Poster();
        oppenhiemer.image = R.drawable.oppenhiemer;
        oppenhiemer.name = "Oppenhiemer";
        oppenhiemer.createdBy = "Christopher Nolan";
        oppenhiemer.rating = 4f;
        oppenhiemer.story = "A dramatization of the life story of J. Robert Oppenheimer, the physicist who had a large hand in the development of the atomic bombs that brought an end to World War II.";
        posterList.add(oppenhiemer);

        Poster barbie = new Poster();
        barbie.image = R.drawable.barbie;
        barbie.name = "Barbie";
        barbie.createdBy = "Greta Gerwig";
        barbie.rating = 3.4f;
        barbie.story = "The film follows Barbie and Ken on a journey of self-discovery through Barbieland and the real world following an existential crisis.";
        posterList.add(barbie);

        Poster dandd = new Poster();
        dandd.image = R.drawable.dandd;
        dandd.name = "Dungeons & Dragons: Honor Among Thieves";
        dandd.createdBy = "John Francis Daley and Jonathan Goldstein";
        dandd.rating = 4f;
        dandd.story = "A charming thief and a band of unlikely adventurers embark on an epic quest to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people.";
        posterList.add(dandd);

        Poster gg = new Poster();
        gg.image = R.drawable.gg;
        gg.name = "Guardians of the Galaxy Vol. 3";
        gg.createdBy = "James Gunn";
        gg.rating = 4f;
        gg.story = "Still reeling from the loss of Gamora, Peter Quill rallies his team to defend the universe and one of their own - a mission that could mean the end of the Guardians if not successful.";
        posterList.add(gg);


        final PosterAdapter posterAdapter = new PosterAdapter(posterList, this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();
                for(int i = 0; i<selectPosters.size(); i++){
                    if(i==0){
                        posterNames.append(selectPosters.get(i).name);
                    }else {
                        posterNames.append("\n").append(selectPosters.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, posterNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onPosterAction(Boolean isSelected) {
        if(isSelected){
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        }else{
            buttonAddToWatchlist.setVisibility(View.GONE);
        }
    }
}