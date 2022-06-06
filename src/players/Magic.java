package players;

import java.util.Random;

public class Magic extends Hero {

    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

            System.out.println("w "+ Warrior.savedamage);
            System.out.println("h "+ Hunter.savedamage);

            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 ){
                    Random rand =new Random();
                    int coef =rand.nextInt(5 ,15);
                    System.out.println("coef "+ coef);

                    if (boss.getHealth() - (heroes[i].getDamage()+coef) < 0) {
                        boss.setHealth(0);
                    }
                    else  {
                        if (heroes[i] instanceof Warrior){
                            boss.setHealth(boss.getHealth() - (Warrior.savedamage+coef));
                        }
                        else if (heroes[i] instanceof Hunter)
                        boss.setHealth(boss.getHealth() - (Hunter.savedamage+coef));
                        else {
                            boss.setHealth(boss.getHealth() - (heroes[i].getDamage()+coef));
                        }
                    }


                }




            }

        }
    }

