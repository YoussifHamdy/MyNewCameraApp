package com.example.dell.mynewcameraapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    private File output = null;
    private static final int CONTENT_REQUEST = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);  // 3shan tft7 el camera awel ma el app yfta7

        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM); // we saved the file to this particular path

        output = new File(dir ,"Camera.png");

        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(output));

        startActivityForResult(intent,CONTENT_REQUEST);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == CONTENT_REQUEST){
            if(resultCode == RESULT_OK){
                Intent i = new Intent(Intent.ACTION_VIEW);

                i.setDataAndType(Uri.fromFile(output),"image/jpeg");
                startActivity(i);
                finish();

            }
        }



    }
}
