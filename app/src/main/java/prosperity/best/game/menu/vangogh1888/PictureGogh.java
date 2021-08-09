package prosperity.best.game.menu.vangogh1888;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.Towel;
import prosperity.best.game.objects.UkrainianB;

public class PictureGogh extends Fragment {
    Towel towel = Towel.getInstancetowel();
    TextView name, about;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.picture_fragment, null);
        ImageView back = view.findViewById(R.id.back_picture);
        ImageView room = view.findViewById(R.id.picture);
        name = view.findViewById(R.id.name_sunflowers);

        about = view.findViewById(R.id.about_sunflowers);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Menu1888)getActivity()).changeFragment(new MenuFragment1888());
            }
        });
        if (towel.isClicked()) {
            room.setImageResource(R.drawable.painter_vinsent1);
            about.setText(R.string.about_picture);
            name.setText(R.string.name_sunflowers);
        }
        return view;
    }

}
