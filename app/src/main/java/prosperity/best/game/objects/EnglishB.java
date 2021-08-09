package prosperity.best.game.objects;

public class EnglishB extends LanguageButtons{

    private static EnglishB Instance;
    public static EnglishB getInstance(){
        if (Instance == null){
            Instance = new EnglishB();
        }
        return Instance;
    }
}
