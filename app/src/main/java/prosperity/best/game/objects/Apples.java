package prosperity.best.game.objects;

public class Apples extends Obj{
    private static Apples instanceapples;
    public static Apples getInstanceApples() {
        if (instanceapples == null) {
            instanceapples = new Apples();
        }
        return instanceapples;
    }
}
