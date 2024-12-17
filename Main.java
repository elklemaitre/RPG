import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création des combattants pour le joueur et l'ennemi
        System.out.println("Entrez le pseudo du joueur 1:");
        String playerName = scanner.nextLine();
        System.out.println("Entrez la puissance du joueur 1:");
        int playerPower = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        System.out.println("Entrez le pseudo du joueur 2:");
        String enemyName = scanner.nextLine();
        System.out.println("Entrez la puissance du joueur 2:");
        int enemyPower = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        Battler playerBattler = new Battler(playerName, playerPower);
        Battler enemyBattler = new Battler(enemyName, enemyPower);

        team playerTeam = new team();
        team enemyTeam = new team();

        playerTeam.addBattler(playerBattler);
        enemyTeam.addBattler(enemyBattler);

        Game game = new Game(playerTeam, enemyTeam);
        game.play();

        scanner.close();
    }
}
