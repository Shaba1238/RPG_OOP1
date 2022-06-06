package players;

import java.util.Random;

public class Warrior extends Hero {

    public static int savedamage;
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0&& boss.getHealth() > 0) {


                    Random rand =new Random();
                    int coef =rand.nextInt(2 ,5);
                    if (boss.getHealth() - this.getDamage()*coef< 0) {
                        boss.setHealth(0);
                    }
                    else {
                    savedamage=this.getDamage()*coef;
                    }




        }

    }
}
