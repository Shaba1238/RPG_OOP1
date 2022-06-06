package players;

import java.util.Random;

public class Hunter extends Hero {
    public static int savedamage;

    public Hunter(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {


        if (this.getHealth() > 0 && boss.getHealth() > 0) {

            if (boss.getHealth() - (this.getDamage() + (boss.getDamage() / 3)) < 0) {
                boss.setHealth(0);
            } else {
                savedamage = this.getDamage() + (boss.getDamage() / 3);

            }

        }

    }

}
