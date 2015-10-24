package com.example.androidlearning.lbs;

/**
 * Created by FCWL on 10/6/2015.
 */
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.example.androidlearning.R;
import com.example.androidlearning.spring.ProxyAuthenticator;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fcwl on 6/11/2015.
 */
public class MapsActivity extends FragmentActivity {

    GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("------ MapsActivity ------", "onCreate()");
        super.onCreate(savedInstanceState);

        // Used for SF proxy authentication.
        Authenticator.setDefault(new ProxyAuthenticator("fcwl", "3943Round#"));
        System.setProperty("http.proxyHost", "in00pxy1.opr.statefarm.org");
        System.setProperty("http.proxyPort", "8000");

        setContentView(R.layout.activity_lbs);

        // Pinpoint the locations on a map
        setupMapIfRequired();
    }

    private void setupMapIfRequired() {
        if(map == null) {
            MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            map = mapFragment.getMap();

            if(map != null) {
                map.setMyLocationEnabled(true);
                showLatLongOnGoogleMap();
            }
        }
    }

    private void showLatLongOnGoogleMap() {
        List<Geometry> dataList = new ArrayList<Geometry>();
        Geometry geometry = new Geometry();
        geometry.setLatitude(47.6097);
        geometry.setLongitude(-122.3331);
        geometry.setTitle("Seatle_1");
        geometry.setAddress("3718 Rosedale St NW, Gig Harbor, WA");
        dataList.add(geometry);

        geometry = new Geometry();
        geometry.setLatitude(45.6097);
        geometry.setLongitude(-120.3331);
        geometry.setTitle("Seatle_2");
        geometry.setAddress("735 12th St SE Auburn, WA");
        dataList.add(geometry);

        geometry = new Geometry();
        geometry.setLatitude(46.6097);
        geometry.setLongitude( -121.3331);
        geometry.setTitle("Seatle_3");
        geometry.setAddress("Vashon Island, WA");
        dataList.add(geometry);

        for (int i = 0; i < dataList.size(); i++) {
            double latitude = dataList.get(i).getLatitude();
            double longitude =  dataList.get(i).getLongitude();

            LatLng pinLocation = new LatLng(latitude, longitude);
            map.addMarker(new MarkerOptions().
                    position(pinLocation).
                    title(dataList.get(i).getTitle()).
                    snippet(dataList.get(i).getAddress()).
                    icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            map.setBuildingsEnabled(true);
        }
    }

    @Override
    // Called when the activity becomes visible to the user
    protected void onStart() {
        super.onStart();
    }

    @Override
    // Called when the activity is no longer visible to the user
    protected void onStop() {
        super.onStop();
    }

}

