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
import prosperity.best.game.objects.Chest;

public class ZoomWall4Fragment extends Fragment {
    BucketWithDirtyWater bucket = BucketWithDirtyWater.getInstancebucket();
    Chest chest = Chest.getInstanceChest();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zoom_wall4, null);
        final AlphaAnimation openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        final AlphaAnimation closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2600);
        closeTxt.setDuration(200);
        final ImageView back = view.findViewById(R.id.back_butt5);
        backToWall(back, new Wall4Fragment());
        final ImageView bucketImg = view.findViewById(R.id.bucket_img);
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
        bucketImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ChestActivity)getActivity()).addObj(bucket, bucketImg);
                ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.water), 0);
                ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.dirty_water), 2000);
            }
        });
        if (chest.getObjects().contains(bucket)){
            bucketImg.setVisibility(View.INVISIBLE);
        }
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
