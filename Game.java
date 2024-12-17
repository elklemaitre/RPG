public class Game {
    private team playerTeam;
    private team enemyTeam;

    public Game(team playerTeam, team enemyTeam) {
        this.playerTeam = playerTeam;
        this.enemyTeam = enemyTeam;
    }

    public void play() {
        while (!playerTeam.isLoose() && !enemyTeam.isLoose()) {
            Battler playerBattler = playerTeam.getBattlers().get(0);
            Battler enemyBattler = enemyTeam.getBattlers().get(0);

            System.out.println(playerBattler.getName() + " attaque " + enemyBattler.getName());
            playerBattler.attack(enemyBattler);
            System.out.println(enemyBattler.getName() + " a maintenant " + enemyBattler.getHp() + " HP");

            if (!enemyTeam.isLoose()) {
                System.out.println(enemyBattler.getName() + " attaque " + playerBattler.getName());
                enemyBattler.attack(playerBattler);
                System.out.println(playerBattler.getName() + " a maintenant " + playerBattler.getHp() + " HP");
            }

            System.out.println("Appuyez sur Entrée pour continuer...");
            new java.util.Scanner(System.in).nextLine();
        }

        team winnerTeam = getWinnerTeam();
        if (winnerTeam != null) {
            System.out.println("Le vainqueur est: " + winnerTeam.getBattlers().get(0).getName());
        } else {
            System.out.println("C'est un match nul!");
        }
    }

    public team getWinnerTeam() {
        if (playerTeam.isLoose() && enemyTeam.isLoose()) {
            return null; // Match nul
        } else if (playerTeam.isLoose()) {
            return enemyTeam;
        } else {
            return playerTeam;
        }
    }
}
