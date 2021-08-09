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
import prosperity.best.game.objects.Clipses;

public class ZoomDiaryFragment extends Fragment {
    Clipses clips = Clipses.getInstanceClipses();
    Chest chest = Chest.getInstanceChest();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zoom_diary_wall, null);
        final ImageView back = view.findViewById(R.id.back_buttdiary);
        ImageView diary = view.findViewById(R.id.b_to_diary);
        final ImageView clipsImg = view.findViewById(R.id.clipses);
        final AlphaAnimation openTxt = new AlphaAnimation(0, 1);
        openTxt.setDuration(200);
        final AlphaAnimation closeTxt = new AlphaAnimation(1, 0);
        closeTxt.setStartOffset(2400);
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
        if (chest.getObjects().contains(clips) || clips.isClicked()){
            clipsImg.setVisibility(View.INVISIBLE);
        }
        clipsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ChestActivity)getActivity()).addObj(clips, clipsImg);
                ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.wow), 0);
                ((ChestActivity)getActivity()).startText(openTxt, closeTxt, getString(R.string.its_clipses), 1300);
            }
        });
        backToWall(diary, new DiaryFragment());
        backToWall(back, new Wall3Fragment());
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
