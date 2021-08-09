package prosperity.best.game.menu;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import prosperity.best.game.R;
import prosperity.best.game.menu.vangogh1888.Menu1888;

public class FirstActivity extends Activity{
    private int splashTime = 5000;
    ImageView fBlack, fMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        fBlack = findViewById(R.id.first_black);
        fMain = findViewById(R.id.first_corridor);
        final Animation fScale = AnimationUtils.loadAnimation(this, R.anim.f_scale);
        final Animation fAlpha = AnimationUtils.loadAnimation(this, R.anim.f_alpha);

        fMain.startAnimation(fAlpha);

        fAlpha.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                fBlack.startAnimation(fScale);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(FirstActivity.this, Menu1888.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ConstraintLayout layout = findViewById(R.id.first_anim_layout);
        layout.setBackgroundColor(getResources().getColor(R.color.black, null));
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.open_anim, R.anim.exit_anim);
    }
}