package prosperity.best.game.fragmentsVersion;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import prosperity.best.game.R;
import prosperity.best.game.objects.Candle;
import prosperity.best.game.objects.Curtain;

public class DiaryFragment extends Fragment {
    Candle candle = Candle.getInstancecandle();
    Curtain curtain = Curtain.getInstancecurtain();
    int touchCounter2 = 0;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zoom_diary_activity, null);
        final ImageView bLetter = view.findViewById(R.id.letter_button);
        final ImageView diaryView = view.findViewById(R.id.diary_view);
        final ImageView back = view.findViewById(R.id.back_butt2);
        final AlphaAnimation openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        final AlphaAnimation closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2300);
        closeTxt.setDuration(200);
        if (candle.isJ() == true){
            candle.getCandleButton().setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (touchCounter2 == 0 && candle.isJ() == true){
                    diaryView.setImageResource(R.drawable.diary_with_letter_and_light_darktheme);
                    touchCounter2++;
                }
                    else if (touchCounter2 == 1){
                    diaryView.setImageResource(R.drawable.diary_with_letter_darktheme);
                    touchCounter2--;
                    }
            }
            });
        }
        openTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                bLetter.setEnabled(false);
                candle.getCandleButton().setEnabled(false);
                back.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        closeTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                bLetter.setEnabled(false);
                candle.getCandleButton().setEnabled(false);
                back.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bLetter.setEnabled(true);
                candle.getCandleButton().setEnabled(true);
                back.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bLetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!curtain.isOpened() && touchCounter2 == 0){
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.dark1), 0);
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.dark2), 1700);
                }
                else if (curtain.isOpened() && touchCounter2 == 0){
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.cant_see), 0);
                }
                if (touchCounter2 == 1){
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.letter1), 0);
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.letter2), 2000);
                }


            }
        });

        backToWall(back, new ZoomDiaryFragment());
        return view;
    }
    private void backToWall(final ImageView img, final Fragment fragment){
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.walls, fragment);
                transaction.commit();
            }
        });
    }
}
