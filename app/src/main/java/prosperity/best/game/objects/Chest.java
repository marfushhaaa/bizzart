package prosperity.best.game.objects;

import android.util.Log;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Chest {
    private List<Obj> objects = new ArrayList<>(5);
    private static final String TAG = "myLogs";
    private Chest(){}

    private static Chest instanceChest;
    public static Chest getInstanceChest() {
        if (instanceChest == null) {
            instanceChest = new Chest();
        }
        return instanceChest;
    }

    public ImageView[] getChestImages() {
        return chestImages;
    }

    public void setChestImages(ImageView[] chestImages) {
        this.chestImages = chestImages;
    }

    ImageView[] chestImages;

    public List<Obj> getObjects() {
        return objects;
    }


    public void addObject(Obj obj) {
        objects.add(obj);
        Log.d(TAG, "добавлен объект с индексом " + objects.indexOf(obj));

    }
}
