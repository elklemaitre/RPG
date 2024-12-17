import java.util.Random;

public class Battler {
    private String name;
    private int hp;
    private int power;
    private Random random;

    public Battler(String name, int power) {
        this.name = name;
        this.power = power;
        this.random = new Random();
        this.hp = generateRandomHP();
    }

    private int generateRandomHP() {
        return 50 + random.nextInt(51); // HP entre 50 et 100
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getPower() {
        return power;
    }

    public void attack(Battler opponent) {
        if (!opponent.dodge()) {
            opponent.looseHP(this.power);
            System.out.println(opponent.getName() + " a été touché(e) et a maintenant " + opponent.getHp() + " HP.");
        } else {
            System.out.println(opponent.getName() + " a esquivé l'attaque!");
        }
    }

    public void looseHP(int amount) {
        this.hp -= amount;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean isLoose() {
        return this.hp == 0;
    }

    public boolean dodge() {
        return random.nextInt(10) == 0; // 10% de chance d'esquiver
    }
}
