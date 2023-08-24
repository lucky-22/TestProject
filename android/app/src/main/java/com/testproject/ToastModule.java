package com.testproject;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import android.widget.Toast;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.location.Location;
import android.location.LocationManager;
import android.location.LocationRequest;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import android.provider.Settings;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SettingsClient;
import android.app.Activity;

public class ToastModule extends ReactContextBaseJavaModule {


   private FusedLocationProviderClient fusedLocationProviderClient;
   private LocationCallback locationCallback;
   private SettingsClient settingsClient;
   private LocationRequest locationRequest;
   private LocationSettingsRequest locationSettingsRequest;
   private Location lastLocation;
   private final static int REQUEST_CODE = 100;
   final Activity activity = getCurrentActivity();

    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastModule";
    }

    @ReactMethod
    public void showToast(String message) {
        Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

//     @ReactMethod
//     public void getLocationDetails() {
// //        First check the location permission
//        checkAndRequestLocationPermission();
//    }


//    private void checkAndRequestLocationPermission() {
//        if (ContextCompat.checkSelfPermission(getReactApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
//            // Permission already granted. Get the location.
// //            getLastKnownLocation();

//        } else {
//            // Request location permission.
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
//        }
//    }

//    private void getLastKnownLocation() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getReactApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        fusedLocationProviderClient.getLastLocation()
//                .addOnSuccessListener(activity, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        if (location != null) {
//                            double latitude = location.getLatitude();
//                            double longitude = location.getLongitude();
//                            Toast.makeText(getReactApplicationContext(), "Latitude: " + latitude + "\nLongitude: " + longitude, Toast.LENGTH_SHORT).show();
//                        } else {
//                            requestEnableLocationServices();
// //                            Toast.makeText(getReactApplicationContext(), "Location is null", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }

//    private void requestEnableLocationServices() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(getReactApplicationContext());
//        builder.setMessage("Location services are disabled. Do you want to enable them?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // Open the location settings
//                        Intent locationSettingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                        activity.startActivity(locationSettingsIntent);
//                    }
//                })
//                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // User declined to enable location services. Handle accordingly.
//                        Toast.makeText(getReactApplicationContext(), "Location services are disabled.", Toast.LENGTH_SHORT).show();
//                    }
//                });
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == REQUEST_CODE) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Permission granted. Get the location.
//                getLastKnownLocation();
//            } else {
//                Toast.makeText(getReactApplicationContext(), "Location permission denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    };
}
