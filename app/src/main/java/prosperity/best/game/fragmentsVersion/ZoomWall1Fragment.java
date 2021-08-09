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
import prosperity.best.game.objects.Chest;
import prosperity.best.game.objects.Towel;

public class ZoomWall1Fragment extends Fragment {
    Towel towel = Towel.getInstancetowel();
    Chest chest = Chest.getInstanceChest();
    ImageView towelButt;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zoom_wall1, null);
        final AlphaAnimation openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        final AlphaAnimation closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2300);
        closeTxt.setDuration(200);
        final ImageView back = view.findViewById(R.id.back_butt4);
        backToWall(back, new Wall1Fragment());

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

        towelButt = view.findViewById(R.id.towel_img);
        towelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ChestActivity)getActivity()).addObj(towel, towelButt);
                ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.hm_yellow_towel), 0);
            }
        });

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
