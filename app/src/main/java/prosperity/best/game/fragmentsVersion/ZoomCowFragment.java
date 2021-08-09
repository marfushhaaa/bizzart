package prosperity.best.game.fragmentsVersion;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import prosperity.best.game.R;
import prosperity.best.game.objects.Cow;

public class ZoomCowFragment extends Fragment {
    Cow cow = Cow.getInstanceCow();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wall_zoom_cow_activity, null);
        final ImageView cowImg = view.findViewById(R.id.big_cow);
        final ImageView back = view.findViewById(R.id.back_butt);
        final AlphaAnimation openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        final AlphaAnimation closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2600);
        closeTxt.setDuration(200);
        openTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
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
                back.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                back.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cowImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ChestActivity)getActivity()).addObj(cow, cowImg);
                ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.let_ladybug_be_free), 0);

            }
        });
        backToWall(back,new Wall1Fragment());
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
