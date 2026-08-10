package rpg.battleUnit.enemy;

public class Golem extends Enemy {
	private int defence;
	public Golem(String name, int hp, int speed, int power) {
		super(name, hp, speed, power);
		// TODO 自動生成されたコンストラクター・スタブ
		this.defence = getRandom().nextInt(10) + 1; //1～10の値がランダムで格納される
	}
	
	
	public void takeDamage(int damage) {
		damage -= this.defence; //喰らうダメージをdefence分削減する。
		if (damage < 0) {
			damage = 1;
		}
		super.takeDamage(damage);
	}
	
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}

}
