package prosperity.best.game.objects;

public class RussianB extends LanguageButtons{

    private static RussianB Instance;
    public static RussianB getInstance(){
        if (Instance == null){
            Instance = new RussianB();
        }
        return Instance;
    }
}
