package rpg.battleUnit.enemy;

import rpg.battleUnit.BattleUnit;

public class Slime extends Enemy {

	public Slime(String name, int hp, int speed, int power) {
		super(name, hp, speed, power);
		this.setAttackPattern(1);
	}
	
	public void attack(BattleUnit u) {
		int pattern  = attackPatternNum();
		int randomHealNum = getRandom().nextInt(20) + 10;
		switch(pattern) {
			case 0 -> {
				super.attack(u);
			}
			
			case 1 -> {
				heal(this,randomHealNum); //自分自身を呼び出す。
			}
		}
	}
	
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (this.getHp() < this.getMaxHp() / 3) {
			this.setAttackPattern(getAttackPattern() + 1);
		}
	}

}
