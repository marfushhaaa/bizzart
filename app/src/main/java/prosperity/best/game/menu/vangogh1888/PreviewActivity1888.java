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
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.fragmentsVersion.ChestActivity;
import prosperity.best.game.objects.DelayedPrinter;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.UkrainianB;

public class PreviewActivity1888 extends AppCompatActivity {
    TextView textView ;
    EnglishB enb = EnglishB.getInstance();
    UkrainianB uab = UkrainianB.getInstance();
    RussianB rub = RussianB.getInstance();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ConstraintLayout layout = findViewById(R.id.pre_layout);
        layout.setBackgroundColor(getResources().getColor(R.color.black, null));
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

        textView = findViewById(R.id.pre_text);
        final ImageView preImg = findViewById(R.id.preview);

        final ImageView preImgBlack = findViewById(R.id.preview_black);

        AlphaAnimation preOpenBlack = new AlphaAnimation(0, 1);
        preOpenBlack.setDuration(10000);
        preOpenBlack.setStartOffset(900);

        preImgBlack.startAnimation(preOpenBlack);

        preOpenBlack.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                preImg.setVisibility(View.INVISIBLE);
                preImgBlack.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.INVISIBLE);
                Intent i = new Intent(PreviewActivity1888.this, ChestActivity.class);
                startActivity2(i);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        startText(getString(R.string.preview_phrase));


    }
    private void startText(final String str) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DelayedPrinter.Word word = new DelayedPrinter.Word(70, str);
                word.setOffset(100);
                DelayedPrinter.printText(word, textView);
            }

        }, 2000);
    }
    public void startActivity2(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim_levels, R.anim.exit_anim);
    }
}
