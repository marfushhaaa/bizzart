package prosperity.best.game.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.menu.vangogh1888.PreviewActivity1888;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.LanguageButtons;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.Towel;
import prosperity.best.game.objects.UkrainianB;

public class MenuActivityIGNORE extends AppCompatActivity {
ImageView author, picture, play, room;
    Towel towel = Towel.getInstancetowel();
    TextView en, ru, ua;
    EnglishB enb = EnglishB.getInstance();
    UkrainianB uab = UkrainianB.getInstance();
    RussianB rub = RussianB.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_ignore);
        Window w = getWindow();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ConstraintLayout layout = findViewById(R.id.menu_layout);
        layout.setBackgroundColor(getResources().getColor(R.color.black, null));
        room = findViewById(R.id.room);
        play = findViewById(R.id.buttonPlay);
//        ActionBar actionBar = getSupportActionBar(); actionBar.hide();


        en = findViewById(R.id.en_);
        ru = findViewById(R.id.ru_);
        ua = findViewById(R.id.ua_);
        rub.setLanguage(ru);
        enb.setLanguage(en);
        uab.setLanguage(ua);
        Locale locale_ru = new Locale("ru");
        Locale locale_en = new Locale("en");
        Locale locale_ua = new Locale("uk");

        changeLanguage(rub, locale_ru);
        changeLanguage(enb, locale_en);
        changeLanguage(uab, locale_ua);

        if (rub.getCounter() == 0 && uab.getCounter() == 0){
            enb.setCounter(1);
            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        }

        if (rub.getCounter() == 1){
            rub.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
        }
        else if (uab.getCounter() == 1){
            uab.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
        }
        else if (enb.getCounter() == 1){
            enb.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
        }

        if (towel.isClicked()){
            room.setImageResource(R.drawable.room_main);
            play.setEnabled(false);
            play.setVisibility(View.INVISIBLE);
        }
        author = findViewById(R.id.bAuthor);


//        author.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MenuActivity.this, AuthorActivity.class);
//                finish();
//                startActivity(intent);
//
//            }
//        });
        picture = findViewById(R.id.bPicture);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivityIGNORE.this, PictureActivityIGNORE.class);
                finish();
                startActivity(intent);


            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivityIGNORE.this, PreviewActivity1888.class);
                finish();
                startActivity2(intent);

            }
        });
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim, R.anim.exit_anim);
    }
    public void startActivity2(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim_levels, R.anim.exit_anim);
    }
    public void changeLanguage(final LanguageButtons languageButton, final Locale locale){
        final List<LanguageButtons> langbutts = new ArrayList<LanguageButtons>(3);
        langbutts.add(0, enb);
        langbutts.add(1, uab);
        langbutts.add(2, rub);
        languageButton.getLanguage().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < langbutts.size(); i++) {
                    if (langbutts.get(i).getCounter() == 1){
                        langbutts.get(i).getLanguage().setTextColor(getResources().getColor(R.color.lang_unselected));
                        langbutts.get(i).setCounter(0);
                        break;
                    }
                }
                Locale.setDefault(locale);
                Configuration configuration = new Configuration();
                configuration.locale = locale;
                getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
                languageButton.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
                languageButton.setCounter(1);
                Intent mIntent = getIntent();
                finish();
                startActivity(mIntent);
            }
        });

    }
}