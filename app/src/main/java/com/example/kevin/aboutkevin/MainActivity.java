package com.example.kevin.aboutkevin;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Uri> archivos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File mFile1 = Environment.getExternalStorageDirectory();
        String fileName = "kevin2.png";
        String path = mFile1.getAbsolutePath().toString()+"/"+fileName;

        Uri foto = Uri.fromFile(new File(path));
        archivos.add(foto);
        //

        Button shareButton = (Button) findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND_MULTIPLE);
                intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, archivos);
                intent.setType("image/*");
                startActivity(Intent.createChooser(intent, "Share images to.."));
            }
        });
    }
}
