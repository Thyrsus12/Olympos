package com.project.olympos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class Article extends AppCompatActivity {

    ImageView imageView;
    TextView tvResume;
    String name;
    String url;
    Context context;
    View alertView;
    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        context = this;
        imageView = findViewById(R.id.imageView);
        tvResume = findViewById(R.id.tvResume);
        TextView tvMoreInfo = findViewById(R.id.tvMoreInfo);
        url = "https://es.wikipedia.org/wiki/Zeus";

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font>"+ name +"</font>"));

        setArticleValues();

        alertView = getLayoutInflater().inflate(R.layout.alert_dialog_image, null);
        ImageView imageViewAlert = alertView.findViewById(R.id.imageViewAlert);
        imageViewAlert.setImageDrawable(drawable);

        tvMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                builder.setView(alertView);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    private void setArticleValues() {
        switch (name) {
            case "Zeus":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.zeus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Hades":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hades_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Poseidón":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.poseidon_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Hera":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hera_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Hestia":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hestia_x));
                tvResume.setText(getString(R.string.hestia_resume));
                url = "https://es.wikipedia.org/wiki/Hestia";
                drawable = getResources().getDrawable(R.drawable.hestia_x);
                break;
            case "Demeter":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.demeter_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Afrodita":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aphrodite_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Apolo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.apollo_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Ares":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ares_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Artemisa":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.artemis_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Atenea":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.athenea_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Dioniso":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.dionysus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Helios":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.helios_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Hefesto":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hephaestus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Hermes":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hermes_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Anfitrite":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.amphitrite_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Eos":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eos_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Eris":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eris_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Eros":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.eros_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Hebe":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.hebe_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Iris":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.iris_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Perséfone":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.persephone_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Morfeo":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.morpheus_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Nike":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nike_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Kione":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.khione_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Melinoe":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.melinoe_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Selene":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.selene_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Nemesis":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.nemesis_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            case "Tyche":
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.tyche_x));
                tvResume.setText(getString(R.string.eolo_resume));
                url = "https://es.wikipedia.org/wiki/Zeus";
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                break;
            default:
        }

    }
}