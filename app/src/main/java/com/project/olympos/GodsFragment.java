package com.project.olympos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GodsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GodsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<Being> gods;
    RecyclerView recyclerGods;

    public GodsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GodsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GodsFragment newInstance(String param1, String param2) {
        GodsFragment fragment = new GodsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_gods, container, false);
        View view = inflater.inflate(R.layout.fragment_gods, container, false);
        gods = new ArrayList<>();
        recyclerGods = view.findViewById(R.id.rvGods);
        recyclerGods.setLayoutManager(new GridLayoutManager(getContext(), 2));
        RVadapter adaptador = new RVadapter(gods, getContext(), this);
        recyclerGods.setAdapter(adaptador);

        fillGodsArray();

        return view;
    }

    private void fillGodsArray() {
        gods.add(new Being(getResources().getDrawable(R.drawable.zeus_x), "Zeus"));
        gods.add(new Being(getResources().getDrawable(R.drawable.hades_x), "Hades"));
        gods.add(new Being(getResources().getDrawable(R.drawable.hestia_x), "Hestia"));
        gods.add(new Being(getResources().getDrawable(R.drawable.hera_x), "Hera"));
        gods.add(new Being(getResources().getDrawable(R.drawable.poseidon_x), "Poseidón"));
        gods.add(new Being(getResources().getDrawable(R.drawable.demeter_x), "Demeter"));
        gods.add(new Being(getResources().getDrawable(R.drawable.aphrodite_x), "Afrodita"));
        gods.add(new Being(getResources().getDrawable(R.drawable.apollo_x), "Apolo"));
        gods.add(new Being(getResources().getDrawable(R.drawable.ares_x), "Ares"));
        gods.add(new Being(getResources().getDrawable(R.drawable.artemis_x), "Artemisa"));
        gods.add(new Being(getResources().getDrawable(R.drawable.athenea_x), "Atenea"));
        gods.add(new Being(getResources().getDrawable(R.drawable.dionysus_x), "Dioniso"));
        gods.add(new Being(getResources().getDrawable(R.drawable.helios_x), "Helios"));
        gods.add(new Being(getResources().getDrawable(R.drawable.hephaestus_x), "Hefesto"));
        gods.add(new Being(getResources().getDrawable(R.drawable.hermes_x), "Hermes"));
        gods.add(new Being(getResources().getDrawable(R.drawable.amphitrite_x), "Anfitrite"));
        gods.add(new Being(getResources().getDrawable(R.drawable.eos_x), "Eos"));
        gods.add(new Being(getResources().getDrawable(R.drawable.eris_x), "Eris"));
        gods.add(new Being(getResources().getDrawable(R.drawable.eros_x), "Eros"));
        gods.add(new Being(getResources().getDrawable(R.drawable.hebe_x), "Hebe"));
        gods.add(new Being(getResources().getDrawable(R.drawable.iris_x), "Iris"));
        gods.add(new Being(getResources().getDrawable(R.drawable.persephone_x), "Perséfone"));
        gods.add(new Being(getResources().getDrawable(R.drawable.morpheus_x), "Morfeo"));
        gods.add(new Being(getResources().getDrawable(R.drawable.nike_x), "Nike"));
        gods.add(new Being(getResources().getDrawable(R.drawable.khione_x), "Kione"));
        gods.add(new Being(getResources().getDrawable(R.drawable.melinoe_x), "Melinoe"));
        gods.add(new Being(getResources().getDrawable(R.drawable.selene_x), "Selene"));
        gods.add(new Being(getResources().getDrawable(R.drawable.nemesis_x), "Nemesis"));
        gods.add(new Being(getResources().getDrawable(R.drawable.tyche_x), "Tyche"));

    }

    public void openArticle(String name) {
        Intent intent = new Intent(getActivity(), Article.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
