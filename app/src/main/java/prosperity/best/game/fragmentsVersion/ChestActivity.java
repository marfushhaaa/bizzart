package prosperity.best.game.fragmentsVersion;
import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;
import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.menu.vangogh1888.VanGoghBio1888;
import prosperity.best.game.objects.BucketWithDirtyWater;
import prosperity.best.game.objects.Candle;
import prosperity.best.game.objects.Chest;
import prosperity.best.game.objects.Clipses;
import prosperity.best.game.objects.Cow;
import prosperity.best.game.objects.DelayedPrinter;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.Obj;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.Sunflowers;
import prosperity.best.game.objects.Towel;
import prosperity.best.game.objects.UkrainianB;

public class ChestActivity extends AppCompatActivity {
    FrameLayout container;
    ImageView commentView, blackEnd;
    TextView textView;
    Cow cow = Cow.getInstanceCow();
    Clipses clips = Clipses.getInstanceClipses();
    Chest chest = Chest.getInstanceChest();
    Candle candle = Candle.getInstancecandle();
    Sunflowers sunflowers = Sunflowers.getInstancesunflowers();
    BucketWithDirtyWater bucket = BucketWithDirtyWater.getInstancebucket();
    Towel towel = Towel.getInstancetowel();
    ImageView[] images = new ImageView[5];
    ConstraintLayout box1, box2, box3, box4, box5;
    ImageView imgbox1,imgbox2,imgbox3,imgbox4,imgbox5;
    final ImageView[] chestImgs = new ImageView[]{imgbox1, imgbox2, imgbox3, imgbox4, imgbox5};
    ImageView shadow;
    AlphaAnimation openTxt = new AlphaAnimation(0, 1);
    AlphaAnimation closeTxt = new AlphaAnimation(1, 0);
    AlphaAnimation preOpenBlack = new AlphaAnimation(0, 1);
    AlphaAnimation preOpenBlack2 = new AlphaAnimation(1, 0);
    ConstraintLayout chest2;
    private static String TAG = "MyLogs";
    EnglishB enb = EnglishB.getInstance();
    UkrainianB uab = UkrainianB.getInstance();
    RussianB rub = RussianB.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chest_fragment);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        box1 = findViewById(R.id.box1m);
        box2 = findViewById(R.id.box2m);
        box3 = findViewById(R.id.box3m);
        box4 = findViewById(R.id.box4m);
        box5 = findViewById(R.id.box5m);
        shadow = findViewById(R.id.shader);
        images[0] = findViewById(R.id.img1);
        images[1] = findViewById(R.id.img2);
        images[2] = findViewById(R.id.img3);
        images[3] = findViewById(R.id.img4);
        images[4] = findViewById(R.id.img5);
        container = findViewById(R.id.walls);
        ZoomCowFragment zoomCowFragment = new ZoomCowFragment();
        add();
        Locale locale_ru = new Locale("ru");
        Locale locale_en = new Locale("en");
        Locale locale_ua = new Locale("uk");
        if (enb.getCounter() == 1){
            Locale.setDefault(locale_en);
            Configuration configuration = new Configuration();
            configuration.locale = locale_en;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }
        else if (rub.getCounter() == 1){
            Locale.setDefault(locale_ru);
            Configuration configuration = new Configuration();
            configuration.locale = locale_ru;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }
        else if (uab.getCounter() == 1){
            Locale.setDefault(locale_ua);
            Configuration configuration = new Configuration();
            configuration.locale = locale_ua;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }        chest2 = findViewById(R.id.chest2);
        openTxt.setDuration(200);
        closeTxt.setStartOffset(2800);
        closeTxt.setDuration(200);
        blackEnd = findViewById(R.id.black_end);
        if (candle.isJ() == true){
            candle.getCandleButton().setImageResource(R.drawable.candlemain);
        }

        preOpenBlack.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                blackEnd.setVisibility(View.VISIBLE);

                Intent i = new Intent(ChestActivity.this, VanGoghBio1888.class);
                startActivity2(i);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        preOpenBlack2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                chest2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        preOpenBlack.setDuration(7000);
        preOpenBlack.setStartOffset(900);
        preOpenBlack2.setDuration(3000);
        preOpenBlack2.setStartOffset(900);

        //sunflowers
        ImageView sunflowerInChest = new ImageView(this);
        sunflowerInChest.setImageResource(R.drawable.sunflowers_in_chest);
        sunflowers.setImageInChest(sunflowerInChest);
        ImageView candleButton = findViewById(R.id.candleButton2);
        candle.setCandleButton(candleButton);

        //cow
        final ImageView cowInChest = new ImageView(this);
        cowInChest.setImageResource(R.drawable.cowinchestsmaller);
        ImageView cowi = findViewById(R.id.big_cow);
        cow.setDefaultImage(cowi);
        cow.setImageInChest(cowInChest);
        cow.setImageId(R.drawable.cowinchestsmaller);
        startText(openTxt, closeTxt, getString(R.string.first_question), 2500);
        selectObj();

        //clips
        final ImageView clipsInChest = new ImageView(this);
        clipsInChest.setImageResource(R.drawable.clipses_in_chest);
        ImageView clipsImg = findViewById(R.id.clipses);
        clips.setDefaultImage(clipsImg);
        clips.setImageInChest(clipsInChest);
        clips.setImageId(R.drawable.clipses_in_chest);

        //bucket
        final ImageView bucketInChest = new ImageView(this);
        bucketInChest.setImageResource(R.drawable.bucket_in_chest);
        ImageView bucketImage = findViewById(R.id.bucket_img);
        bucket.setDefaultImage(bucketImage);
        bucket.setImageInChest(bucketInChest);
        bucket.setImageId(R.drawable.bucket_in_chest_2);

        //towel
        final ImageView towelInChest = new ImageView(this);
        towelInChest.setImageResource(R.drawable.towel_in_chest);
        ImageView towelImage = findViewById(R.id.towel_img);
        towel.setDefaultImage(towelImage);
        towel.setImageInChest(towelInChest);
        towel.setImageId(R.drawable.towel_in_chest);

    }
    private void add(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.walls,new Wall1Fragment());
        transaction.commit();
    }
    public void startText(final AlphaAnimation open, final AlphaAnimation close, final String str, int delay) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DelayedPrinter.Word word = new DelayedPrinter.Word(70, str);
                word.setOffset(70);
                textView = findViewById(R.id.maintext);
                DelayedPrinter.printText(word, textView);
                commentView = findViewById(R.id.comment_window);
                textView.startAnimation(close);
                commentView.startAnimation(open);
                commentView.startAnimation(close);

            }

        }, delay);
    }
    public void addObj(final Obj obj, final ImageView img){
        imgbox1 = findViewById(R.id.chest_box_1);
        imgbox2 = findViewById(R.id.chest_box_2);
        imgbox3 = findViewById(R.id.chest_box_3);
        imgbox4 = findViewById(R.id.chest_box_4);
        imgbox5 = findViewById(R.id.chest_box_5);
        final ImageView[] chestImgs = new ImageView[]{imgbox1, imgbox2, imgbox3, imgbox4, imgbox5};
        img.setVisibility(View.INVISIBLE);
        obj.setClicked(false);
        chest.addObject(obj);
        int curr = chest.getObjects().indexOf(obj);
        Log.d(TAG, "" + curr);
        images[curr].setImageDrawable(getResources().getDrawable(chest.getObjects().get(curr).getImageId()));
        Log.d(TAG, "" + chestImgs[curr]);
        chestImgs[curr].setTag("unselected");
    }
    public boolean touchCounter = false;
    public void useObj(final ImageView paste, final Obj obj, final Fragment fragment, final String str) {

        ImageView selectImg = new ImageView(this);
        selectImg.setImageResource(R.drawable.chestboxselectedcorrected);
        imgbox1 = findViewById(R.id.chest_box_1);
        imgbox2 = findViewById(R.id.chest_box_2);
        imgbox3 = findViewById(R.id.chest_box_3);
        imgbox4 = findViewById(R.id.chest_box_4);
        imgbox5 = findViewById(R.id.chest_box_5);
        final ImageView[] chestImgs = new ImageView[]{imgbox1, imgbox2, imgbox3, imgbox4, imgbox5};
        for (int i = 0; i < images.length; i++) {
            final int finalI = i;
            final ImageView currimg = images[i];
            currimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if (chestImgs[finalI].getTag().equals("unselected")) {
                       touchCounter = true;
                       chestImgs[finalI].setImageResource(R.drawable.chestboxselectedcorrected);
                       chestImgs[finalI].setTag("selected");
                       Obj currObj = chest.getObjects().get(finalI);
                       Log.d(TAG, String.valueOf(currObj));
                       if (currObj == obj){
                           paste.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   paste.setEnabled(false);
                                   List <Obj> currentObj = chest.getObjects();
                                   currentObj.remove(obj);
                                   changeFragment(fragment);
                                   images[finalI].setImageResource(R.drawable.binvisible);
                                   chestImgs[finalI].setImageResource(R.drawable.chestboxx);
                                   chestImgs[finalI].setTag("without object");
                                   startText(openTxt, closeTxt, str, 0);
                                   obj.setClicked(true);
                                   for (int j = 0; j < images.length; j++) {
                                       images[j].setEnabled(true);
                                   }

                                   for (int i = 0; i < images.length; i++) {
                                       if (chestImgs[i].getTag().equals("without object") && chestImgs[i + 1].getTag().equals("unselected") && chest.getObjects().size() > i){
                                           Log.d(TAG, String.valueOf(i));
                                           images[i].setImageResource(chest.getObjects().get(i).getImageId());
                                           images[i + 1].setImageResource(R.drawable.binvisible);
                                           chestImgs[i].setTag("unselected");
                                           chestImgs[i + 1].setTag("without object");
                                       }
//
                                   }
                               }
                           });
                       }
                       for (int j = 0; j < images.length; j++) {
                           Log.d(TAG, "tag" + chestImgs[j].getTag());
                           if (chestImgs[j].getTag().equals("unselected")){
                               images[j].setEnabled(false);
                           }
                       }
                    }
                   else if (chestImgs[finalI].getTag().equals("selected")) {
                       chestImgs[finalI].setImageResource(R.drawable.chestboxx);
                       chestImgs[finalI].setTag("unselected");
                       for (int j = 0; j < images.length; j++) {
                           images[j].setEnabled(true);
                       }
                       for (int i = 0; i < images.length; i++) {
                           if (chestImgs[i].getTag().equals("without object") && chestImgs[i + 1].getTag().equals("unselected") && chest.getObjects().size() > i){
                               Log.d(TAG, String.valueOf(i));
                               images[i].setImageResource(chest.getObjects().get(i).getImageId());
                               images[i + 1].setImageResource(R.drawable.binvisible);
                               chestImgs[i].setTag("unselected");
                               chestImgs[i + 1].setTag("without object");
                           }
//
                       }
                       touchCounter = false;
                   }
                }
            });
        }
    }
    public void selectObj() {
        ImageView selectImg = new ImageView(this);
        selectImg.setImageResource(R.drawable.chestboxselectedcorrected);
        imgbox1 = findViewById(R.id.chest_box_1);
        imgbox2 = findViewById(R.id.chest_box_2);
        imgbox3 = findViewById(R.id.chest_box_3);
        imgbox4 = findViewById(R.id.chest_box_4);
        imgbox5 = findViewById(R.id.chest_box_5);
        imgbox1.setTag("unselected");
        imgbox2.setTag("unselected");
        imgbox3.setTag("unselected");
        imgbox4.setTag("unselected");
        imgbox5.setTag("unselected");
        final ImageView[] chestImgs = new ImageView[]{imgbox1, imgbox2, imgbox3, imgbox4, imgbox5};
        for (int i = 0; i < images.length; i++) {
            final int finalI = i;
            final ImageView currimg = images[i];
            currimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if (chestImgs[finalI].getTag().equals("unselected")) {
                       touchCounter = true;
                       chestImgs[finalI].setImageResource(R.drawable.chestboxselectedcorrected);
                       chestImgs[finalI].setTag("selected");

                       for (int j = 0; j < images.length; j++) {
                           if (chestImgs[j].getTag().equals("unselected")){
                               images[j].setEnabled(false);
                           }
                       }
                    }
                   else if (chestImgs[finalI].getTag().equals("selected")) {
                       chestImgs[finalI].setImageResource(R.drawable.chestboxx);
                       chestImgs[finalI].setTag("unselected");
                       for (int j = 0; j < images.length; j++) {
                           images[j].setEnabled(true);
                       }
                       touchCounter = false;
                   }
                }
            });
        }
    }
    public void changeFragment(final Fragment fragment){
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.walls, fragment);
                transaction.commit();
    }
    public void startActivity2(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim_levels, R.anim.exit_anim);
    }
}