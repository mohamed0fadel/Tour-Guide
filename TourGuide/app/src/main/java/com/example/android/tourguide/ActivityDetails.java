package com.example.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActivityDetails extends AppCompatActivity {

    Attraction attraction;
    ImageView imageView;
    TextView nameText;
    TextView detailsText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = findViewById(R.id.details_image);
        nameText = findViewById(R.id.details_name);
        detailsText = findViewById(R.id.full_details);
        button = findViewById(R.id.details_button);

        attraction = (Attraction)getIntent().getExtras().get("atrraction");
        imageView.setImageResource(attraction.getImage());
        nameText.setText(attraction.getName());
        detailsText.setText(attraction.getDescription());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(attraction.getLocation().getUri());
            }
        });
    }

    /**
     * starts implicit intent to show the location on maps
     * @param geoLocation location Uri
     */
    private void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
