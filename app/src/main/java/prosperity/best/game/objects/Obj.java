package prosperity.best.game.objects;

import android.widget.ImageView;

public class Obj {
    private ImageView defaultImage;

    public ImageView getImageInChest() {
        return imageInChest;
    }

    public void setImageInChest(ImageView imageInChest) {
        this.imageInChest = imageInChest;
    }

    private ImageView imageInChest;
    private boolean clicked = false;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    //картинка объекта который я добавляю
    private int imageId;


    public ImageView getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(ImageView defaultImage) {
        this.defaultImage = defaultImage;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

}
