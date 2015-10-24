package com.example.androidlearning.md;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.androidlearning.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by fcwl on 5/22/2015.
 */
public class CardsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("--------- CardsActivity onCreate called --------");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        CardsAdapter ca = new CardsAdapter(createList(10), this);
        recList.setAdapter(ca);
    }

    private List<CountryData> createList(int size) {
        List<CountryData> result = new ArrayList<CountryData>();
        for (int i = 1; i <= size; i++) {
            CountryData cd = new CountryData();
            cd.setName(CountryData.NAME_PREFIX + i);
            cd.setCountryDetails(CountryData.DETAILS_PREFIX + i);
            result.add(cd);
        }

        return result;
    }

}
