package prosperity.best.game.fragmentsVersion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import prosperity.best.game.R;
import prosperity.best.game.objects.Chest;
import prosperity.best.game.objects.Cow;
import prosperity.best.game.objects.Towel;

public class Wall1Fragment extends Fragment {
    Chest chest = Chest.getInstanceChest();
    Towel towel = Towel.getInstancetowel();
    Cow cow = Cow.getInstanceCow();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wall1_fragment, null);
        ImageView buttonCow = view.findViewById(R.id.gods_cow2);
        ImageView right = view.findViewById(R.id.butt_right);
        ImageView left = view.findViewById(R.id.butt_left);
        ImageView towelImg = view.findViewById(R.id.towel);
        if (chest.getObjects().contains(cow) || cow.isClicked()) {
            buttonCow.setVisibility(View.INVISIBLE);
        }
        if (chest.getObjects().contains(towel) || towel.isClicked()){
            towelImg.setVisibility(View.INVISIBLE);
        }
        changeFragment(new ZoomCowFragment(), buttonCow);
        changeFragment(new Wall2Fragment(), right);
        changeFragment(new Wall4Fragment(), left);
        changeFragment(new ZoomWall1Fragment(), towelImg);
        return  view;
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
