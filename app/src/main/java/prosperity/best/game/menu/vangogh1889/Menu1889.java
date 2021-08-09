package prosperity.best.game.menu.vangogh1889;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.menu.vangogh1888.Menu1888;
import prosperity.best.game.menu.vangogh1888.MenuFragment1888;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.LanguageButtons;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.UkrainianB;

public class Menu1889 extends AppCompatActivity {

    EnglishB enb = EnglishB.getInstance();
    UkrainianB uab = UkrainianB.getInstance();
    RussianB rub = RussianB.getInstance();
    AlphaAnimation appear;
    private void add(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.menuframeLayout89, new MenuFragment1889());
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
    }
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim, R.anim.exit_anim);
    }
    public void changeFragment(final Fragment fragment ){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.menuframeLayout89, fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.commit();
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
                changeFragment(new MenuFragment1889());

            }
        });

    }
    public void showPlaybutt(ImageView clock, final TextView hint){
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appear = new AlphaAnimation(0, 1);
                appear.setDuration(300);
                hint.startAnimation(appear);
                hint.setVisibility(View.VISIBLE);
//                year.startAnimation(appear);
//                year.setVisibility(View.VISIBLE);
            }
        });
    }
    public void nextYear(){
        Intent i = new Intent(Menu1889.this, Menu1888.class);
        finish();
        startActivity(i);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity_1889);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        add();

        if (rub.getCounter() == 0 && uab.getCounter() == 0){
            enb.setCounter(1);
            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
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
    }
}
