package prosperity.best.game.menu.vangogh1889;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.menu.vangogh1888.Menu1888;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.Towel;
import prosperity.best.game.objects.UkrainianB;

public class MenuFragment1889 extends Fragment {

    EnglishB enb = EnglishB.getInstance();
    UkrainianB uab = UkrainianB.getInstance();
    RussianB rub = RussianB.getInstance();
    TextView en, ru, ua;
    Towel towel = Towel.getInstancetowel();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_fragment_1889, null);
        ImageView backyear = view.findViewById(R.id.next_year_1889);
//        ImageView author = view.findViewById(R.id.bAuthor2);
//        ImageView pic = view.findViewById(R.id.bPicture2);
        TextView hint = view.findViewById(R.id.hint_1889);
        ImageView clock = view.findViewById(R.id.old_clock89);
//        ImageView year = view.findViewById(R.id.img_1888);
//        ImageView nextYear = view.findViewById(R.id.next_year_1888);
//
        //появление кнопки играть, в данном случае просто надписи
            ((Menu1889)getActivity()).showPlaybutt(clock, hint);
//
//        //меняем комнату на завершенную, когда пройден уровень
//        if (towel.isClicked()){
//            room.setImageResource(R.drawable.main_vincent);
//            play.setVisibility(View.INVISIBLE);
//            play.setEnabled(false);
//            year.setVisibility(View.VISIBLE);
//            nextYear.setVisibility(View.VISIBLE);
//        }

        backyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Menu1889)getActivity()).nextYear();
            }
        });
        //меняем языки
        Locale locale_ru = new Locale("ru");
        Locale locale_en = new Locale("en");
        Locale locale_ua = new Locale("uk");
        en = view.findViewById(R.id.en_89);
        ru =  view.findViewById(R.id.ru_89);
        ua =  view.findViewById(R.id.ua_89);
        rub.setLanguage(ru);
        enb.setLanguage(en);
        uab.setLanguage(ua);
        ((Menu1889)getActivity()).changeLanguage(enb, locale_en);
        ((Menu1889)getActivity()).changeLanguage(rub, locale_ru);
        ((Menu1889)getActivity()).changeLanguage(uab, locale_ua);

        if (rub.getCounter() == 1){
            rub.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
            ((Menu1889)getActivity()).changeLanguage(rub, locale_ru);

        }
        else if (uab.getCounter() == 1){
            uab.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
            ((Menu1889)getActivity()).changeLanguage(uab, locale_ua);
        }
        else if (enb.getCounter() == 1){
            enb.getLanguage().setTextColor(getResources().getColor(R.color.lang_selected));
            ((Menu1889)getActivity()).changeLanguage(enb, locale_en);
        }

//        //смотреть инфу про автора
//        author.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((Menu1888)getActivity()).authorButt();
//            }
//        });
//
//        //смотреть инфу про картину
//        pic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((Menu1888)getActivity()).pictureButt();
//            }
//        });
//
//        //играть
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ((Menu1888)getActivity()).playButt();
//            }
//        });
        return view;

    }
}
