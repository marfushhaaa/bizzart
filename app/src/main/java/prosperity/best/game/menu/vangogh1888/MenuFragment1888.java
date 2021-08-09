package prosperity.best.game.menu.vangogh1888;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.Towel;
import prosperity.best.game.objects.UkrainianB;

public class MenuFragment1888 extends Fragment {

    EnglishB enb = EnglishB.getInstance();
    UkrainianB uab = UkrainianB.getInstance();
    RussianB rub = RussianB.getInstance();
    TextView en, ru, ua;
    Towel towel = Towel.getInstancetowel();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment_1888, null);
        ImageView room = view.findViewById(R.id.main_menu);
        ImageView author = view.findViewById(R.id.bAuthor2);
        ImageView pic = view.findViewById(R.id.bPicture2);
        ImageView play = view.findViewById(R.id.buttonPlay2);
        ImageView clock = view.findViewById(R.id.old_clock);
        ImageView year = view.findViewById(R.id.img_1888);
        ImageView nextYear = view.findViewById(R.id.next_year_1888);

        //появление кнопки играть
        if (!towel.isClicked()){
            ((Menu1888)getActivity()).showPlaybutt(clock, play, year);
        }

        //меняем комнату на завершенную, когда пройден уровень
        if (towel.isClicked()){
            room.setImageResource(R.drawable.main_vincent);
            play.setVisibility(View.INVISIBLE);
            play.setEnabled(false);
            year.setVisibility(View.VISIBLE);
            nextYear.setVisibility(View.VISIBLE);
            nextYear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Menu1888)getActivity()).nextYear();
                }
            });
        }

        //меняем языки
        Locale locale_ru = new Locale("ru");
        Locale locale_en = new Locale("en");
        Locale locale_ua = new Locale("uk");
        en = view.findViewById(R.id.en_2);
        ru =  view.findViewById(R.id.ru_2);
        ua =  view.findViewById(R.id.ua_2);
        rub.setLanguage(ru);
        enb.setLanguage(en);
        uab.setLanguage(ua);
        ((Menu1888)getActivity()).changeLanguage(enb, locale_en);
        ((Menu1888)getActivity()).changeLanguage(rub, locale_ru);
        ((Menu1888)getActivity()).changeLanguage(uab, locale_ua);

        if (rub.getCounter() == 1){
            rub.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
            ((Menu1888)getActivity()).changeLanguage(rub, locale_ru);

        }
        else if (uab.getCounter() == 1){
            uab.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
            ((Menu1888)getActivity()).changeLanguage(uab, locale_ua);
        }
        else if (enb.getCounter() == 1){
            enb.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
            ((Menu1888)getActivity()).changeLanguage(enb, locale_en);
        }

        //смотреть инфу про автора
        author.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Menu1888)getActivity()).authorButt();
            }
        });

        //смотреть инфу про картину
        pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Menu1888)getActivity()).pictureButt();
            }
        });

        //играть
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Menu1888)getActivity()).playButt();
            }
        });
        return view;

    }
}
