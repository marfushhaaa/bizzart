package prosperity.best.game.fragmentsVersion;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import prosperity.best.game.R;
import prosperity.best.game.objects.Chest;
import prosperity.best.game.objects.Cow;

public class Wall3Fragment extends Fragment {
    Chest chest = Chest.getInstanceChest();
    Cow cow = Cow.getInstanceCow();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wall3_activity, null);
        ImageView right = view.findViewById(R.id.butt_right3);
        ImageView left = view.findViewById(R.id.butt_left3);
        changeFragment(new Wall2Fragment(), left);
        changeFragment(new Wall4Fragment(), right);
        ImageView bDiary = view.findViewById(R.id.bDiary);
        changeFragment(new ZoomDiaryFragment(), bDiary);
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
