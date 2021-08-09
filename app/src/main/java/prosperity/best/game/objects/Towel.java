package prosperity.best.game.objects;

public class Towel extends Obj{
    private static Towel instancetowel;
    public static Towel getInstancetowel() {
        if (instancetowel == null) {
            instancetowel = new Towel();
        }
        return instancetowel;
    }

}
