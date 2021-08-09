package prosperity.best.game.objects;

public class UkrainianB extends LanguageButtons{

    private static UkrainianB Instance;
    public static UkrainianB getInstance(){
        if (Instance == null){
            Instance = new UkrainianB();
        }
        return Instance;
    }
}
