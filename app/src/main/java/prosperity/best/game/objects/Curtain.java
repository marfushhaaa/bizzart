package prosperity.best.game.objects;

import android.widget.ImageView;

public class Curtain {
    private static Curtain instancecurtain;
    public static Curtain getInstancecurtain() {
        if (instancecurtain == null) {
            instancecurtain = new Curtain();
        }
        return instancecurtain;
    }
    boolean isOpened = false;

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public ImageView getCurtainImg() {
        return curtainImg;
    }

    public void setCurtainImg(ImageView curtainImg) {
        this.curtainImg = curtainImg;
    }

    ImageView curtainImg;
}
