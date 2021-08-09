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

import androidx.annotation.Nullable;

import prosperity.best.game.R;
import prosperity.best.game.objects.BucketWithDirtyWater;
import prosperity.best.game.objects.Chest;
import prosperity.best.game.objects.Cow;
import prosperity.best.game.objects.Sunflowers;

public class Wall4Fragment extends Fragment {
    Chest chest = Chest.getInstanceChest();
    Cow cow = Cow.getInstanceCow();
    Sunflowers sunflowers = Sunflowers.getInstancesunflowers();
    BucketWithDirtyWater bucket = BucketWithDirtyWater.getInstancebucket();
    ImageView blackHuman;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wall4_activity, null);
        ImageView right = view.findViewById(R.id.butt_right4);
        ImageView left = view.findViewById(R.id.butt_left4);
        ImageView bucketImg = view.findViewById(R.id.water_with_paintings);
        changeFragment(new ZoomWall4Fragment(), bucketImg);
        blackHuman = view.findViewById(R.id.black_human);
        if (cow.isClicked()){
            blackHuman.setVisibility(View.VISIBLE);
            blackHuman.setEnabled(true);
        }
        if (!cow.isClicked()){
            blackHuman.setVisibility(View.INVISIBLE);
            blackHuman.setEnabled(false);
        }
        if (chest.getObjects().contains(bucket) || bucket.isClicked()){
            bucketImg.setVisibility(View.INVISIBLE);
        }
        final AlphaAnimation openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        final AlphaAnimation closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2900);
        closeTxt.setDuration(200);
        openTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                blackHuman.setEnabled(false);
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
                blackHuman.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                blackHuman.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        sunflowers.setImageId(R.drawable.sunflowers_in_chest);
        sunflowers.setDefaultImage(blackHuman);
        if (chest.getObjects().contains(sunflowers) || sunflowers.isClicked()){
            blackHuman.setVisibility(View.INVISIBLE);
        }
        blackHuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!chest.getObjects().contains(sunflowers)){
                    blackHuman.setImageResource(R.drawable.black_with_eyes);
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.who), 0);
                    blackHuman.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            blackHuman.setImageResource(R.drawable.black_with_sunflowers);
                            ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.sunflowers_question), 0);
                            blackHuman.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    ((ChestActivity)getActivity()).addObj(sunflowers, blackHuman);
                                }
                            });
                        }
                    });
                }

            }
        });
        changeFragment(new Wall3Fragment(), left);
        changeFragment(new Wall1Fragment(), right);
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
