import java.util.Scanner;
import java.util.Random;
public class Game {
    private String name;
    private Enemy[] enemies;
    private Player player;
    //...
    public Game(String name, Enemy[] enemies, Player player) {
        this.name = name;
        this.enemies = enemies;
        this.player = player;
    }
    public void start() {
        System.out.println("Приветствуем тебя в нашей игре! Твои атаки:");
        Attack[] att = player.getAttacks();
        for (int j = 0; j < att.length; ++j) {
            System.out.println(player.getAttacks()[j].name + " - название. Урон - " + player.getAttacks()[j].damage);
        }
        for(int i = 0; i < this.enemies.length; ++i) {
            int b = enemies[i].getAttacks().length;
            System.out.println("Враг: "+enemies[i].getTitle());
            System.out.println("Атаки: ");
            for (int j = 0; j < b; ++j) {
                String s = enemies[i].getAttacks()[j].name;
                System.out.println(s + " - название. Урон - " + enemies[i].getAttacks()[j].damage);
            }
            while (enemies[i].health != 0) {
                System.out.println("Используйте свою атаку!");
                int damage = 0;
                Boolean flag = false;
                while (flag == false) {
                    Scanner in = new Scanner(System.in);
                    String string = in.nextLine();
                    for (int j = 0; j < player.getAttacks().length; ++j) {  // Ищем атаку игрока
                        String s = player.getAttacks()[j].name;
                        boolean qwerty = string.equals(s);
                        Attack play = player.getAttacks()[j];
                        if (qwerty) {
                            enemies[i].health -= play.damage;
                            damage = play.damage;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Вы ввели неправильное название атаки. Попробуйте еще раз");
                    } else {
                        System.out.println("Вы нанесли урон: " + damage + ".");
                        if (string.equals("Ultimate move") == true) {
                            System.out.println("За применение этого удара с вас было снято 40 хп");
                            player.health -= 40;
                        }
                        if (enemies[i].health <= 0) {
                            System.out.println("Вы победили этого врага!");
                            break;
                        } else {
                            System.out.println("Оставшееся здоровье врага - " + enemies[i].health);
                        }
                    }
                }
                if (enemies[i].health > 0) {
                    Random rand = new Random();
                    int dmg = enemies[i].getAttacks()[rand.nextInt(b)].damage;
                    player.health -= dmg;
                    System.out.println("Вам нанесли урон: " + dmg + ".");
                    System.out.println("Оставшееся ваше здоровье: " + player.health + ".");
                    if (player.health <= 0) {
                        System.out.println("YOU DIED");
                        System.out.println("Спасибо, что играли в нашу 'Fight with bandits'!");
                        return;
                    }
                } else {
                    break;
                }
            }
        }
        if (player.health >= 0) {
            System.out.println("Победа!");
            System.out.println("Спасибо, что играли в нашу 'Fight with bandits'!");
        } else {
            System.out.println("Поражение");
            System.out.println("Спасибо, что играли в нашу 'Fight with bandits'!");
        }
    }
}

class Enemy {
    private String name;
    private Attack[] attacks;
    int health;

    public Attack[] getAttacks() {
        return attacks;
    }
    public String getTitle() {
        return name;
    }
    public Enemy(String name, Attack[] attacks, int health) {
        this.name = name;
        this.attacks = attacks;
        this.health = health;
    }
}
class Attack {
    String name;
    int damage;

    public String getName() {
        return name;
    }
    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
}

class Player {
    int health;
    private Attack[] attacks;
    public Attack[] getAttacks() {
        return attacks;
    }
    public int getHealth() {
        return health;
    }
    public Player(int health, Attack[] attacks) {
        this.health = health;
        this.attacks = attacks;
    }
}
