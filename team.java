import java.util.List;
import java.util.ArrayList;

public class team {
    private List<Battler> battlers;

    public team() {
        this.battlers = new ArrayList<>();
    }

    public void addBattler(Battler battler) {
        this.battlers.add(battler);
    }

    public List<Battler> getBattlers() {
        return battlers;
    }

    public boolean isLoose() {
        for (Battler battler : battlers) {
            if (!battler.isLoose()) {
                return false;
            }
        }
        return true;
    }
}
