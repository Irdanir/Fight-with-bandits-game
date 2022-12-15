import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Attack[] attacks1 = new Attack[3];
        attacks1[0] = new Attack("Slash", 5);
        attacks1[1] = new Attack("Charge", 7);
        attacks1[2] = new Attack("Punch", 3);
        Attack[] attacks2 = new Attack[3];
        attacks2[0] = new Attack("Curse", 50);
        attacks2[1] = new Attack("Lightning bolt", 15);
        attacks2[2] = new Attack("Fireball", 10);
        Attack[] attacks3 = new Attack[3];
        attacks3[0] = new Attack("Powerful shot", 10);
        attacks3[1] = new Attack("Accurate shot", 12);
        attacks3[2] = new Attack("Usual shot", 7);
        Attack[] attacks_player = new Attack[3];
        attacks_player[0] = new Attack("Ultimate move", 40);
        attacks_player[1] = new Attack("Slash", 9);
        attacks_player[2] = new Attack("Curse", 15);
        Player player = new Player(100, attacks_player);
        Enemy[] enemies = new Enemy[3];
        enemies[0] = new Enemy("Warrior", attacks1, 50);
        enemies[1] = new Enemy("Mage", attacks2, 20);
        enemies[2] = new Enemy("Archer", attacks3, 35);
        Game game1 = new Game("Fight with bandits", enemies, player);
        game1.start();
    }
}

