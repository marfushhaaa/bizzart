package prosperity.best.game.objects;

import android.widget.ImageView;

public class Candle{
    private static Candle instancecandle;
    public static Candle getInstancecandle() {
        if (instancecandle == null) {
            instancecandle = new Candle();
        }
        return instancecandle;
    }

    public ImageView getCandleButton() {
        return candleButton;
    }

    public void setCandleButton(ImageView candleButton) {
        this.candleButton = candleButton;
    }

    ImageView candleButton;

    public boolean isJ() {
        return j;
    }

    public void setJ(boolean j) {
        this.j = j;
    }

    boolean j = false;
}
