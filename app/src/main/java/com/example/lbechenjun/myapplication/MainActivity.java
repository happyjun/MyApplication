package com.example.lbechenjun.myapplication;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private FrameLayout revellayout;
    private ImageView image2;
    private FrameLayout container;
    private Button  action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("cj","on create()");
        revellayout = (FrameLayout) findViewById(R.id.revel_layout);
        image2 = (ImageView) findViewById(R.id.image_2);
        container = (FrameLayout) findViewById(R.id.fmt_container);
        action = (Button) findViewById(R.id.action);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fmt_container, new Fragment1(), null).commitNowAllowingStateLoss();
                revellayout.removeView(image2);
            }
        });
        LayoutTransition layoutTransition = revellayout.getLayoutTransition();
        if (layoutTransition == null) {
            layoutTransition = new LayoutTransition();
        }
        ObjectAnimator animOut = ObjectAnimator.ofFloat(null, View.ALPHA, 1f, 0f).setDuration(2000);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, animOut);
        ObjectAnimator animIn = ObjectAnimator.ofFloat(null, View.ALPHA, 0f, 1f).setDuration(2000);
        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, animIn);
        layoutTransition.setAnimateParentHierarchy(true);
        Toast.makeText(this,"this is a toast",Toast.LENGTH_SHORT).show();
        revellayout.setLayoutTransition(layoutTransition);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"on Start()",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on Start2()",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on master Start2()",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"on stop()",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on stop() myapplication2 1",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"on destroy()",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on destroy() myapplication2 1",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on destroy() myapplication2 2",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on destroy() maser 1",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on destroy() maser 2",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on destroy() myapplication2 2",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on destroy() myapplication2 3",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"on destroy() myapplication2 4",Toast.LENGTH_SHORT).show();
    }

    private void fadeInDisplay(ImageView imageView, Bitmap bitmap) {
        final TransitionDrawable td =
                new TransitionDrawable(new Drawable[]{
                        new ColorDrawable(getResources().getColor(R.color.test_color)),
                        new BitmapDrawable(imageView.getResources(), bitmap)
                });
        imageView.setImageDrawable(td);
        td.startTransition(6000);
    }

    private void my() {
        Log.d("","");
    }
}
