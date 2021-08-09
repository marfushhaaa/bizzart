package prosperity.best.game.objects;

import android.widget.ImageView;

public class ButtonPlay {
    private static ButtonPlay instance;
    public static ButtonPlay getInstance(){
        if (instance == null){
            instance = new ButtonPlay();
        }
        return  instance;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public int tries = 3;
    public ImageView play;

    public ImageView getPlay() {
        return play;
    }

    public void setPlay(ImageView play) {
        this.play = play;
    }
}
