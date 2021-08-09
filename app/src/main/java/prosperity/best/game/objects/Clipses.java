package prosperity.best.game.objects;

import android.widget.ImageView;

public class Clipses extends Obj{
    private static Clipses instanceClipses;
    public static Clipses getInstanceClipses() {
        if (instanceClipses == null) {
            instanceClipses = new Clipses();
        }
        return instanceClipses;
    }

    public ImageView getPasteClips() {
        return pasteClips;
    }

    public void setPasteClips(ImageView pasteClips) {
        this.pasteClips = pasteClips;
    }

    ImageView pasteClips;
}
