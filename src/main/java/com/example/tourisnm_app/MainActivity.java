package com.example.tourisnm_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements tourist_adapter.OnRowClickListener {

    RecyclerView rv;
    tourist_adapter tourist_adapter;
    List<tourist_spot> tourist_spotList = new ArrayList<>();

    Integer[] imageList = {R.drawable.fed, R.drawable.bot, R.drawable.mcg, R.drawable.sou, R.drawable.ngv};
    String[] nameList = {"Federation Square", "Royal Botanic Gardens", "Melbourne Cricket Ground", "Arts Centre Melbourne", "National Gallery of Victoria"};
    String[] descList = {"When Federation Square opened in 2002 to commemorate 100 years of federation, it divided Melburnians. There were those who loved it and those who hated it. Either way, it has become an integral part of the city and a great place for tourists to start their sightseeing. Located opposite Flinders Street Station, a major public transport hub, the building's ultra-modern design of open and closed spaces contrasts with the surrounding Victorian architecture. With more than 2,000 events annually, you can always find entertainment in the central outdoor performance space and intimate indoor venues.", "In the heart of green parkland extending south of the Yarra River, about two kilometers from the CBD, the Royal Botanic Gardens are among the finest of their kind in the world. Established in 1846, the gardens encompass two locations: Melbourne and Cranbourne. The Melbourne Gardens cover an area of 38 hectares with more than 8,500 species of plants, including many rare specimens.", "Melbourne is the sporting capital of Australia, so it's no surprise that a sports stadium numbers among the city's top tourist attractions. With a capacity of 100,000 and a history dating back to 1853, the MCG is considered one of the world's greatest stadiums. As the main stadium for the 1956 Olympic Games and 2006 Commonwealth Games, the birthplace of Test Cricket, and the home of Australian Rules Football, \"the 'G\" is woven into the fabric of Melbourne. Daily 75-minute tours take visitors for a trip down a memory lane of great moments in sporting history and incorporate the National Sports Museum, including the Australian Gallery of Sport and Olympic Museum. You can also catch a game of cricket in summer or football during winter.", "On the banks of the Yarra River, a short stroll from Flinders Street Station, this area is packed with cultural attractions. Southbank promenade is filled with indoor/outdoor cafés, restaurants, and live entertainment. An excellent arts and crafts market is held every Sunday, and the area is also home to many festivals throughout the year. Easily recognizable by its spire, the Arts Centre incorporates a range of theaters and spaces, including the State Theatre, Playhouse, Fairfax Theatre, and Hamer Hall, the premier performance space for the revered Melbourne Symphony Orchestra.", "The oldest public art gallery in Australia, the National Gallery of Victoria holds more than 70,000 works of art in two city locations. The international collection is housed in the St. Kilda Road building, originally opened in 1968 and extensively renovated in 2003. The building is renowned for The Great Hall, where visitors are encouraged to lie on the floor and gaze at the colorful stained glass ceiling. The extensive Australian collection is held in the Ian Potter Gallery in Federation Square, featuring the history of Australian art from Aboriginal works through to the Heidelberg School, and contemporary mixed media. One of the highlights is the large triptych format, The Pioneer by Frederick McCubbin."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        tourist_adapter = new tourist_adapter(tourist_spotList, MainActivity.this, this );
        rv.setAdapter(tourist_adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        for(int i = 0; i < imageList.length; i++)
        {
            com.example.tourisnm_app.tourist_spot tourist_spot = new com.example.tourisnm_app.tourist_spot(i, imageList[i], nameList[i], descList[i]);
            tourist_spotList.add(tourist_spot);
        }
    }



    @Override
    public void onItemClick(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new des1_fragment();
                break;
            case 1:
                fragment = new des2_frag();
                break;
            case 2:
                fragment = new des3_frag();
                break;
            case 3:
                fragment = new des4_frag();
                break;
            case 4:
                fragment = new des5_frag();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + position);
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment).addToBackStack("back").commit();
    }
}