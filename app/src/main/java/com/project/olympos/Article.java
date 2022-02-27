package com.project.olympos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;


public class Article extends AppCompatActivity {

    ImageView imageView;
    TextView tvResume;
    String name;
    Context context;
    View alertView;

    //Especific propierties
    Drawable drawable;
    String resume, url, title1, subtitle1, myth1, title2, subtitle2, myth2;

    ////Expandable CardView
    ImageButton arrow;
    LinearLayout hiddenView;
    CardView cardView;
    TextView tvTitle, tvSubtitle, tvMyth;

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

        //AlertDialog that show big image
        alertView = getLayoutInflater().inflate(R.layout.alert_dialog_image, null);
        ImageView imageViewAlert = alertView.findViewById(R.id.imageViewAlert);
        imageViewAlert.setImageDrawable(drawable);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cleanViewAnyChartPattern();
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(context);
                builder.setView(alertView);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //TextView that open Wiki
        tvMoreInfo.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        });

        //Expandable CardView
        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.arrow_button);
        hiddenView = findViewById(R.id.hidden_view);
        tvTitle = findViewById(R.id.tvTitle);
        tvSubtitle = findViewById(R.id.tvSubtitle);
        tvMyth = findViewById(R.id.tvMyth);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (hiddenView.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.vd_expand_more);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.vd_expand_less);
                }
            }
        });

        extractArticleValues();

    }

    private void cleanViewAnyChartPattern() {
        //VIEW CLEANER
        if (alertView != null) {
            ViewGroup parent = (ViewGroup) alertView.getParent();
            if (parent != null) {
                parent.removeView(alertView);
            }
        }
        try {
            alertView = getLayoutInflater().inflate(R.layout.alert_dialog_image, null);
        } catch (InflateException e) {
            e.printStackTrace();
        }
    }

    private void setArticleValues() {
        imageView.setImageDrawable(drawable);
        tvResume.setText(resume);
        tvTitle.setText(title1);
        tvSubtitle.setText(subtitle1);
        tvMyth.setText(myth1);
    }

    //@SuppressLint("UseCompatLoadingForDrawables")
    private void extractArticleValues() {
        switch (name) {
            case "Zeus":
                drawable = getResources().getDrawable(R.drawable.zeus_x);
                resume = getString(R.string.eolo_resume);
                url = "https://es.wikipedia.org/wiki/Zeus";
                /*title1 = getString(R.string.hestia_myth1_title);
                subtitle1 = getString(R.string.hestia_myth1_subtitle);
                myth1 = getString(R.string.hestia_myth1_text);*/
                setArticleValues();
                break;
            case "Hades":
                drawable = getResources().getDrawable(R.drawable.hades_x);
                resume = getString(R.string.eolo_resume);
                url = "https://es.wikipedia.org/wiki/Hades";
                /*title1 = getString(R.string.hestia_myth1_title);
                subtitle1 = getString(R.string.hestia_myth1_subtitle);
                myth1 = getString(R.string.hestia_myth1_text);*/
                setArticleValues();
                break;
            case "Poseidón":
                drawable = getResources().getDrawable(R.drawable.poseidon_x);
                resume = getString(R.string.eolo_resume);
                url = "https://es.wikipedia.org/wiki/Poseidón";
                /*title1 = getString(R.string.hestia_myth1_title);
                subtitle1 = getString(R.string.hestia_myth1_subtitle);
                myth1 = getString(R.string.hestia_myth1_text);*/
                setArticleValues();
                break;
            case "Hera":
                drawable = getResources().getDrawable(R.drawable.hera_x);
                resume = getString(R.string.eolo_resume);
                url = "https://es.wikipedia.org/wiki/Hera";
                /*title1 = getString(R.string.hestia_myth1_title);
                subtitle1 = getString(R.string.hestia_myth1_subtitle);
                myth1 = getString(R.string.hestia_myth1_text);*/
                setArticleValues();
                break;
            case "Hestia":
                drawable = getResources().getDrawable(R.drawable.hestia_x);
                resume = getString(R.string.eolo_resume);
                url = "https://es.wikipedia.org/wiki/Hestia";
                title1 = getString(R.string.hestia_myth1_title);
                subtitle1 = getString(R.string.hestia_myth1_subtitle);
                myth1 = getString(R.string.hestia_myth1_text);
                setArticleValues();
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