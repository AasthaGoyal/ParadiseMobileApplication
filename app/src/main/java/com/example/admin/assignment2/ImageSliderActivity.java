package com.example.admin.assignment2;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageSliderActivity extends AppCompatActivity {

    private Handler handler;
    private ImageView imageView1;
    private int[] images;
    private int imageNo = 0;
    Button btnGoToWebsite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_slider);

        images = new int[]{R.drawable.paradise1, R.drawable.paradise2,
                R.drawable.paradise3, R.drawable.paradise4};
        imageView1 = findViewById(R.id.imageView1);
        btnGoToWebsite = (Button) findViewById(R.id.btnGoToWebsite);

        handler = new Handler();
        ChangeImagesThread aThread = new ChangeImagesThread();
        aThread.start();

        btnGoToWebsite.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                loadWebsite thread2 = new loadWebsite();
                 Thread bThread = new Thread(thread2);
                 bThread.start();
            }
        });


        Toast.makeText(ImageSliderActivity.this, "Code is reaching", Toast.LENGTH_SHORT).show();
    }



    class loadWebsite implements Runnable{
        @Override
        public void run()
        {

            handler.post(new Runnable()
            {
                @Override
                public void run()
                {
                    WebView webView = new WebView(ImageSliderActivity.this);
                    setContentView(webView);
                    webView.loadUrl("https://www.paradiseindianfood.co.nz/");
                }
            });


            try{
                Thread.sleep(1000);

            }catch(InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }
    class ChangeImagesThread extends Thread {
        public boolean isRunning = true;

        public void setIsRunning(boolean isrun) {
            isRunning = isrun;
        }

        public void run() {

            while (isRunning = true) {
                final int imageLocation = images[imageNo];

                Log.d("Image Number = ", "" + imageNo);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView1.setImageResource(imageLocation);
                    }
                });
                imageNo++;
                if (imageNo >= images.length)
                    imageNo = 0;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
