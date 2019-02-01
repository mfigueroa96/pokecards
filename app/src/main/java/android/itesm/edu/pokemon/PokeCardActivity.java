package android.itesm.edu.pokemon;

import android.itesm.edu.pokemon.model.PokeCard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PokeCardActivity extends AppCompatActivity {
    RequestOptions options;
    TextView id, name, artist;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_card);

        PokeCard pokeCard = (PokeCard)getIntent().getSerializableExtra("pokemon");
        loadPokemon(pokeCard);
    }

    public void loadPokemon(PokeCard _card) {
        id = findViewById(R.id.id_card);
        name = findViewById(R.id.card_name);
        artist = findViewById(R.id.author_card);
        image = findViewById(R.id.card);

        options = new RequestOptions().centerCrop()
                .placeholder(R.drawable.load_card).error(R.drawable.load_card);

        name.setText(_card.getName());
        artist.setText(_card.getArtist());
        id.setText(_card.getId());
        Glide.with(this).load(_card.getImageUrl()).apply(options).into(image);
    }
}
