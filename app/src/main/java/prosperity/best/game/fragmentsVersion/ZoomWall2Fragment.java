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
import prosperity.best.game.objects.BucketWithDirtyWater;
import prosperity.best.game.objects.Candle;
import prosperity.best.game.objects.Chest;
import prosperity.best.game.objects.Sunflowers;
import prosperity.best.game.objects.Towel;
import prosperity.best.game.objects.YellowVase;

public class ZoomWall2Fragment extends Fragment {
    YellowVase yellowVase = YellowVase.getInstancevase();
    Candle candle = Candle.getInstancecandle();
    Towel towel = Towel.getInstancetowel();
    BucketWithDirtyWater bucket = BucketWithDirtyWater.getInstancebucket();
    Sunflowers sunflowers = Sunflowers.getInstancesunflowers();
    Chest chest = Chest.getInstanceChest();
    ImageView yellowVaseImg;
    AlphaAnimation openTxt;
    AlphaAnimation closeTxt;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zoom_wall2, null);
        final ImageView candleImg = view.findViewById(R.id.candle_view);
        yellowVaseImg = view.findViewById(R.id.yellow_vase);
        final ImageView vaseFlowers = view.findViewById(R.id.vaze_flowers);
        ImageView yellowBack = view.findViewById(R.id.yellow_back);
        final ImageView back = view.findViewById(R.id.back_butt3);
        ImageView yellowBackButt = view.findViewById(R.id.bInvisible);
        openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2600);
        closeTxt.setDuration(200);
        openTxt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                yellowVaseImg.setEnabled(false);
                vaseFlowers.setEnabled(false);
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
                yellowVaseImg.setEnabled(false);
                vaseFlowers.setEnabled(false);
                back.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                yellowVaseImg.setEnabled(true);
                vaseFlowers.setEnabled(true);
                back.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        if (candle.isJ() == true){
            candleImg.setVisibility(View.INVISIBLE);
        }
        if (yellowVase.isEmptyWater()){
            ((ChestActivity)getActivity()).useObj(yellowVaseImg, bucket, new ZoomWall2Fragment(), getString(R.string.okay_there_is_water));
        }
        if (bucket.isClicked()){
            yellowVase.setEmptyWater(false);
        }
        if (!yellowVase.isEmptyWater() && yellowVase.isEmptyFlowers()){
            ((ChestActivity)getActivity()).useObj(yellowVaseImg, sunflowers, new ZoomWall2Fragment(),
                    getString(R.string.if_backgr));
            if (sunflowers.isClicked()){
                yellowVase.setEmptyFlowers(false);
                yellowVaseImg.setVisibility(View.INVISIBLE);
                yellowVaseImg.setEnabled(false);
                vaseFlowers.setVisibility(View.VISIBLE);
            }
        }
        if (!yellowVase.isEmptyFlowers()){
            yellowVaseImg.setVisibility(View.INVISIBLE);
            yellowVaseImg.setEnabled(false);
            vaseFlowers.setVisibility(View.VISIBLE);
            ((ChestActivity)getActivity()).useObj(yellowBackButt, towel, new ZoomWall2Fragment(),
                    getString(R.string.true_naturmort));
            if (towel.isClicked()){
                yellowBack.setVisibility(View.VISIBLE);
                back.setEnabled(false);
                ((ChestActivity)getActivity()).blackEnd.startAnimation( ((ChestActivity)getActivity()).preOpenBlack );
                ((ChestActivity)getActivity()).chest2.startAnimation(((ChestActivity)getActivity()).preOpenBlack2);
            }
        }
//        if (!yellowVase.isEmptyFlowers()){
//
//        }

        candleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                candleImg.setVisibility(View.INVISIBLE);
                candle.setJ(true);
                candle.getCandleButton().setImageResource(R.drawable.candlemain);
            }
        });

        yellowVaseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yellowVase.isEmptyWater() && !chest.getObjects().contains(sunflowers)){
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.beautiful_vaze), 0);
                }
                if (yellowVase.isEmptyWater() && chest.getObjects().contains(sunflowers)){
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.needed_water), 0);
                }
                if (!yellowVase.isEmptyWater()){
                    ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.needed_water), 0);
                }

            }
        });


        backToWall(back, new Wall2Fragment());
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
