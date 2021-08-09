package prosperity.best.game.objects;

public class BucketWithDirtyWater extends Obj{
    private static BucketWithDirtyWater instancebucket;
    public static BucketWithDirtyWater getInstancebucket() {
        if (instancebucket == null) {
            instancebucket = new BucketWithDirtyWater();
        }
        return instancebucket;
    }
}
