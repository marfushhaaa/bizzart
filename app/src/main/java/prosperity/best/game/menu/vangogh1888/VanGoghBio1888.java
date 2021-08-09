package prosperity.best.game.menu.vangogh1888;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.Printer2;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.UkrainianB;

public class VanGoghBio1888 extends AppCompatActivity {
    AlphaAnimation open = new AlphaAnimation(0, 1);
    AlphaAnimation close = new AlphaAnimation(1, 0);
    AlphaAnimation closeBig = new AlphaAnimation(1, 0);
    EnglishB enb = EnglishB.getInstance();
    UkrainianB uab = UkrainianB.getInstance();
    RussianB rub = RussianB.getInstance();
    ImageView bImg, letter, polgogen, sunflv, sunflm;
    TextView nextText, textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bio_layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
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
        }
        open.setDuration(200);
        close.setDuration(600);
        close.setStartOffset(6000);
        closeBig.setDuration(600);
        closeBig.setStartOffset(11000);
        bImg = findViewById(R.id.b_next);
        letter = findViewById(R.id.image_letter);
        polgogen = findViewById(R.id.image_polgogen);
        sunflm = findViewById(R.id.sunflm);
        sunflv = findViewById(R.id.sunflv);
        nextText = findViewById(R.id.b_text);
        textView = findViewById(R.id.texte);

        final ImageView invisi = new ImageView(this);
        invisi.setImageResource(R.drawable.binvisible);
        startText(close, getString(R.string.bio1), 4000,  invisi);
        startText(closeBig, getString(R.string.bio2), 10000,  letter);
        startText(close, getString(R.string.bio3), 23000, polgogen);
        startText2(closeBig,getString(R.string.bio4), 30000, sunflm, sunflv);







    }
    public void startText(final AlphaAnimation close, final String str, final int delay, final ImageView imageView) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Printer2.Word2 word = new Printer2.Word2(70, str);
                word.setOffset(90);
                final TextView textView = findViewById(R.id.texte);
                textView.startAnimation(open);
                imageView.startAnimation(open);
                nextText = findViewById(R.id.b_text);
                Printer2.printText(word, textView, bImg);
                textView.startAnimation(close);
                imageView.startAnimation(close);
            }

        }, delay);
    }
    public void startText2(final AlphaAnimation close, final String str, int delay, final ImageView imageView, final ImageView imageView2) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Printer2.Word2 word = new Printer2.Word2(70, str);
                word.setOffset(90);
                TextView textView = findViewById(R.id.texte);
                textView.startAnimation(open);
                imageView.startAnimation(open);
                imageView2.startAnimation(open);
                textView.startAnimation(close);
                imageView.startAnimation(close);
                imageView2.startAnimation(close);
                Printer2.printText(word, textView, bImg);
                close.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Intent i = new Intent(VanGoghBio1888.this, Menu1888.class);
                        startActivity2(i);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }

        }, delay);
    }
    public void startActivity2(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim_levels, R.anim.exit_anim);
    }

}
