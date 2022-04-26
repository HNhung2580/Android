package com.example.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;

public class ActivityTrungGian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trung_gian);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();
       if(id == R.id.share){
           ApplicationInfo api = getApplicationContext().getApplicationInfo();
           String apkpath = api.sourceDir;
           Intent intent = new Intent(Intent.ACTION_SEND);
           intent.setType("application/vnd.android.package-archive");
           intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
           startActivity(Intent.createChooser(intent, "ShareVia"));
       }
       else if (id == R.id.information){
           Intent intent = new Intent(ActivityTrungGian.this,Information.class);
           startActivity(intent);
           return true;
       }
       else if (id == R.id.logout){
           Intent intent = new Intent(ActivityTrungGian.this, MainActivity.class);
           startActivity(intent);
       }
       return true;
    }
}