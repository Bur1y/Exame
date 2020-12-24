package com.bur1y.examen.ui.map;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.bur1y.examen.BookBottomDialog;
import com.bur1y.examen.HomeActivity;
import com.bur1y.examen.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapFragment extends Fragment implements OnMapReadyCallback, LocationListener {
    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1337;
    private GoogleMap map;
    LocationManager locationManager;

    BottomSheetDialog dialog;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View root = inflater.inflate(R.layout.fragment_map, container, false);

        HomeActivity ha = (HomeActivity) getActivity();

        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(view -> ha.drawer.open());

        locationManager = (LocationManager) ha.getSystemService(Context.LOCATION_SERVICE);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return root;
    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.map = map;

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST_LOCATION);
        } else {
            enableMyLocation();
        }

        MarkerOptions m1 = new MarkerOptions();
        m1.position(new LatLng(22, -122));
        m1.icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map));
        MarkerOptions m2 = new MarkerOptions();
        m2.position(new LatLng(26, -122));
        m2.icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map));
        MarkerOptions m3 = new MarkerOptions();
        m3.position(new LatLng(56, -12));
        m3.icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map));
        MarkerOptions m4 = new MarkerOptions();
        m4.position(new LatLng(13, -78));
        m4.icon(BitmapDescriptorFactory.fromResource(R.drawable.car_map));
        map.addMarker(m1);
        map.addMarker(m2);
        map.addMarker(m3);
        map.addMarker(m4);
        map.setOnMarkerClickListener(marker -> {
            new BookBottomDialog(getActivity(), map, marker).show();
            return false;
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableMyLocation();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (map != null) {
            enableMyLocation();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        }
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 400, 1, this);
            map.setMyLocationEnabled(true);
            map.getUiSettings().setCompassEnabled(true);
            map.getUiSettings().setMyLocationButtonEnabled(false);

        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f));
    }

}