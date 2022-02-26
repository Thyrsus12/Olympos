package com.project.olympos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Article extends AppCompatActivity {

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        ImageView imageView = findViewById(R.id.imageView);
        TextView tvResume = findViewById(R.id.tvResume);
        TextView tvMoreInfo = findViewById(R.id.tvMoreInfo);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font>"+ name +"</font>"));

        switch (name) {
            case "Zeus":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.zeus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Hades":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hades_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Poseidón":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.poseidon_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Hera":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hera_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Hestia":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hestia_x));
                tvResume.setText(getString(R.string.hestia_resume));
                break;
            case "Demeter":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.demeter_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Afrodita":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aphrodite_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Apolo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.apollo_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Ares":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ares_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Artemisa":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.artemis_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Atenea":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.athenea_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Dioniso":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dionysus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Helios":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.helios_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Hefesto":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hephaestus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Hermes":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hermes_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Anfitrite":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.amphitrite_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Eos":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eos_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Eris":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eris_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Eros":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eros_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Hebe":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hebe_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Iris":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.iris_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Perséfone":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.persephone_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Morfeo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.morpheus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Nike":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nike_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Kione":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.khione_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Melinoe":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.melinoe_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Selene":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.selene_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Nemesis":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nemesis_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            case "Tyche":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tyche_x));
                tvResume.setText(getString(R.string.eolo_resume));
                break;
            default:
        }



    }
}