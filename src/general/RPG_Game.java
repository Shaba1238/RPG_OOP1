package general;

import players.*;

import java.util.Random;

public class RPG_Game {

    public static void startGame() {
        Boss boss = new Boss(1000, 50);
        Warrior warrior = new Warrior(250, 10);
        Magic magic = new Magic(250, 20);
        Random rand =new Random();
        int healPoints =rand.nextInt(20 ,40);
        Medic medic = new Medic(200, 0, healPoints);
        Hunter hunter = new Hunter(100, 20);
        Hero[] heroes = {warrior, medic, hunter, magic};
        printStatistic(boss, heroes);

        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }

    }

    public static void round(Boss boss, Hero[] heroes) {
        heroesApplyAbilities(boss, heroes);
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        //medicApplyAbilities(boss, heroes);
        printStatistic(boss, heroes);
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {


        }


    private static void bossHit(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 ) {
                    if (heroes[i].getHealth() - boss.getDamage() < 0) {
                        heroes[i].setHealth(0);
                    }
                    else {
                        heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
                    }
                }

            }
        }

    }

    private static void heroesApplyAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperAbility(boss, heroes);
            }
        }
    }

    public static void printStatistic(Boss boss, Hero[] heroes) {
        System.out.println("-----------------------");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Warrior) {
                System.out.println("Warrior health: " + heroes[i].getHealth());
            }
            else if (heroes[i] instanceof Medic) {
                System.out.println("Medic health: " + heroes[i].getHealth());
            }
            else if (heroes[i] instanceof Magic) {
                System.out.println("Magic health: " + heroes[i].getHealth());
            }
            else if (heroes[i] instanceof Hunter) {
                System.out.println("Hunter health: " + heroes[i].getHealth());
            }
        }
    }

    public static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!");
            return true;
        }
        boolean isAllHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                isAllHeroesDead = false;
                break;
            }
        }
        if (isAllHeroesDead) {
            System.out.println("Boss won!!");
        }
        return isAllHeroesDead;
    }

}
