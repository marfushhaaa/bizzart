package prosperity.best.game.menu;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import prosperity.best.game.R;
import prosperity.best.game.objects.Towel;

public class PictureActivityIGNORE extends Activity {
    ImageView buttonback, room;
    Towel towel = Towel.getInstancetowel();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picture_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        ConstraintLayout layout = findViewById(R.id.picture_layout);
        layout.setBackgroundColor(getResources().getColor(R.color.black, null));
        room = findViewById(R.id.picture_view);
        TextView textView = findViewById(R.id.textView2);
        TextView textView2 = findViewById(R.id.textView4);
        if (towel.isClicked()){
            room.setImageResource(R.drawable.painter_vinsent1);
            textView.setText(R.string.about_picture);
            textView2.setVisibility(View.VISIBLE);
        }
        buttonback = findViewById(R.id.b_back);

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PictureActivityIGNORE.this, MenuActivityIGNORE.class);
                finish();
                startActivity(intent);

            }
        });

    }

    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim, R.anim.exit_anim);
    }
}
