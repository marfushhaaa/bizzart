package prosperity.best.game.objects;

import android.widget.ImageView;

public class Cow extends Obj {
    private static Cow instanceCow;
    public static Cow getInstanceCow() {
        if (instanceCow == null) {
            instanceCow = new Cow();
        }
        return instanceCow;
    }
    public ImageView getPasteCow() {
        return pasteCow;
    }
    public void setPasteCow(ImageView pasteCow) {
        this.pasteCow = pasteCow;
    }
    ImageView pasteCow;
}
