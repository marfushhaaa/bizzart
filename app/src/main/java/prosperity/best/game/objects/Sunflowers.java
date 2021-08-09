package prosperity.best.game.objects;

public class Sunflowers extends Obj{
    private static Sunflowers instancesunflowers;
    public static Sunflowers getInstancesunflowers() {
        if (instancesunflowers == null) {
            instancesunflowers = new Sunflowers();
        }
        return instancesunflowers;
    }
}
