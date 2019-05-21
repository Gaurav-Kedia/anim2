package com.gaurav.anim2;

import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView image1;
    private int[] imageArray;
    private int currentIndex;
    private int startIndex;
    private int endIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1 = (ImageView)findViewById(R.id.imageView1);
        imageArray = new int[33];
        imageArray[0] = R.drawable.t1;
        imageArray[1] = R.drawable.t2;
        imageArray[2] = R.drawable.t3;
        imageArray[3] = R.drawable.t4;
        imageArray[4] = R.drawable.t5;
        imageArray[5] = R.drawable.t6;
        imageArray[6] = R.drawable.t7;
        imageArray[7] = R.drawable.t8;
        imageArray[8] = R.drawable.t9;
        imageArray[9] = R.drawable.t10;
        imageArray[10] = R.drawable.t11;
        imageArray[11] = R.drawable.t12;
        imageArray[12] = R.drawable.t13;
        imageArray[13] = R.drawable.t14;
        imageArray[14] = R.drawable.t15;
        imageArray[15] = R.drawable.t16;
        imageArray[16] = R.drawable.t17;
        imageArray[17] = R.drawable.t18;
        imageArray[18] = R.drawable.t19;
        imageArray[19] = R.drawable.t20;
        imageArray[20] = R.drawable.t21;

        imageArray[21] = R.drawable.t22;
        imageArray[22] = R.drawable.t23;
        imageArray[23] = R.drawable.t24;
        imageArray[24] = R.drawable.t25;
        imageArray[25] = R.drawable.t26;
        imageArray[26] = R.drawable.t27;
        imageArray[27] = R.drawable.t28;
        imageArray[28] = R.drawable.t29;
        imageArray[29] = R.drawable.t30;
        imageArray[30] = R.drawable.t31;
        imageArray[31] = R.drawable.t32;
        imageArray[32] = R.drawable.t33;




        startIndex = 0;
        endIndex = 32;

        anim2();
        //nextImage();
        /*try {
            custom_anim();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private void anim2() {
        for(int i = 0; i<= 100; i++) {
            image1.setImageResource(R.drawable.trans);
            ((TransitionDrawable) image1.getDrawable()).startTransition(3000);

            image1.setImageResource(R.drawable.trans2);
            ((TransitionDrawable) image1.getDrawable()).startTransition(3000);
        }
        //anim2();
    }

    private void custom_anim() throws InterruptedException {
        image1.setImageResource(imageArray[currentIndex]);
        for(int i = 1; i <= 23; i++ ){
            currentIndex++;
            Thread.sleep(100);
            image1.setImageResource(imageArray[currentIndex]);
        }
        for(int i = 22; i >= 0; i-- ){
            currentIndex--;
            Thread.sleep(100);
            image1.setImageResource(imageArray[currentIndex]);
        }
    }

    public void nextImage(){
        image1.setImageResource(imageArray[currentIndex]);
        Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        image1.startAnimation(rotateimage);
        currentIndex++;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(currentIndex>endIndex){
                    currentIndex--;
                    previousImage();
                }else{
                    nextImage();
                }

            }
        },(1/20)); // here 1000(1 second) interval to change from current  to next image

    }
    public void previousImage(){
        image1.setImageResource(imageArray[currentIndex]);
        Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        image1.startAnimation(rotateimage);
        currentIndex--;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(currentIndex<startIndex){
                    currentIndex++;
                    nextImage();
                }else{
                    previousImage(); // here 1000(1 second) interval to change from current  to previous image
                }
            }
        },(1/20));

    }
}
