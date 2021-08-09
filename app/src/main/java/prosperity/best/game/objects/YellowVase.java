package prosperity.best.game.objects;

public class YellowVase {
    private static YellowVase instancevase;
    public static YellowVase getInstancevase() {
        if (instancevase == null) {
            instancevase = new YellowVase();
        }
        return instancevase;
    }

    public boolean isEmptyWater() {
        return emptyWater;
    }

    public void setEmptyWater(boolean emptyWater) {
        this.emptyWater = emptyWater;
    }

    private boolean emptyWater = true;

    public boolean isEmptyFlowers() {
        return emptyFlowers;
    }

    public void setEmptyFlowers(boolean emptyFlowers) {
        this.emptyFlowers = emptyFlowers;
    }

    private boolean emptyFlowers = true;
}
