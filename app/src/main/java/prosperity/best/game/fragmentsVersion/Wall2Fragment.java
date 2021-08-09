package prosperity.best.game.fragmentsVersion;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import prosperity.best.game.R;
import prosperity.best.game.objects.Candle;
import prosperity.best.game.objects.Chest;
import prosperity.best.game.objects.Clipses;
import prosperity.best.game.objects.Cow;
import prosperity.best.game.objects.Curtain;
import prosperity.best.game.objects.Sunflowers;

public class Wall2Fragment extends Fragment {
    Chest chest = Chest.getInstanceChest();
    Cow cow = Cow.getInstanceCow();
    Candle candle = Candle.getInstancecandle();
    Curtain curtain = Curtain.getInstancecurtain();
    Clipses clips = Clipses.getInstanceClipses();
    Sunflowers sunflowers = Sunflowers.getInstancesunflowers();
    AlphaAnimation openTxt;
    AlphaAnimation closeTxt;
    ImageView closedCurtain;
    static  String TAG = "log";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wall2_activity, null);
        ImageView right = view.findViewById(R.id.butt_right2);
        ImageView left = view.findViewById(R.id.butt_left2);
        ImageView table = view.findViewById(R.id.table);
        final ImageView candleImg = view.findViewById(R.id.candle);
        final ImageView pasteCow = view.findViewById(R.id.paste_cow);
        ImageView wall = view.findViewById(R.id.wall2_img);
        closedCurtain = view.findViewById(R.id.closed_curtain);
        clips.setPasteClips(closedCurtain);
        curtain.setOpened(false);
        openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2300);
        closeTxt.setDuration(200);
        openTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                closedCurtain.setEnabled(false);
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
                closedCurtain.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                closedCurtain.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        cow.setPasteCow(pasteCow);
        cow.getPasteCow().setEnabled(false);
        if (!curtain.isOpened()){
            ((ChestActivity)getActivity()).useObj(clips.getPasteClips(), clips, new Wall2Fragment(), getString(R.string.lighter));{
                if (clips.isClicked()){
                    curtain.setOpened(true);
                    ((ChestActivity)getActivity()).shadow.setVisibility(View.INVISIBLE);
                    closedCurtain.setImageResource(R.drawable.opened_curtaine);
                }
            }

        }
        if (curtain.isOpened()){
            closedCurtain.setImageResource(R.drawable.opened_curtaine);
            cow.getPasteCow().setEnabled(true);
            ((ChestActivity)getActivity()).useObj(cow.getPasteCow(), cow, new Wall2Fragment(), getString(R.string.free_ladybug));
            if (!chest.getObjects().contains(cow)){
                pasteCow.setEnabled(false);
            }
        }
        if (sunflowers.isClicked()){
            wall.setImageResource(R.drawable.wall2_3);
        }
        closedCurtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!curtain.isOpened()){
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.curtain_question), 0);
                }

            }
        });
        changeFragment(new ZoomWall2Fragment(), table);
        if (candle.isJ() == true){
            candleImg.setVisibility(View.INVISIBLE);
        }
        changeFragment(new Wall1Fragment(), left);
        changeFragment(new Wall3Fragment(), right);
        return view;
    }
    public void changeFragment(final Fragment fragment, ImageView button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.walls, fragment);
                transaction.commit();
            }
        });

    }

}
