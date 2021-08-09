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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import java.util.Locale;

import prosperity.best.game.R;
import prosperity.best.game.objects.EnglishB;
import prosperity.best.game.objects.RussianB;
import prosperity.best.game.objects.Towel;
import prosperity.best.game.objects.UkrainianB;

public class AuthorGogh extends Fragment {
    Towel towel = Towel.getInstancetowel();
    TextView name, about;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.author_fragment,  null);
        ImageView room = view.findViewById(R.id.author);
        ImageView back =  view.findViewById(R.id.back_author);
        name =  view.findViewById(R.id.name_vincent);
        about =  view.findViewById(R.id.about_vincent);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Menu1888)getActivity()).changeFragment(new MenuFragment1888());
            }
        });
        if (towel.isClicked()){
            room.setImageResource(R.drawable.autor_vinsent);
            about.setText(R.string.about_author);
            name.setText(R.string.name_vinsent);
        }

        return view;
    }



}
