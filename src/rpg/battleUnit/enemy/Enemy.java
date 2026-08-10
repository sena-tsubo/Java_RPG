package rpg.battleUnit.enemy;

import java.util.Random;

import rpg.battleUnit.BattleUnit;

public abstract class Enemy extends BattleUnit {
	private Random random;
	private int attackPattern;
	public Enemy(String name, int hp, int speed, int power) {
		super(name, hp, speed, power);
		this.setRandom(new Random()); //敵キャラクターの攻撃をランダムにするためのインスタンス
	}
	
	public int attackPatternNum() {
		return  random.nextInt(this.attackPattern); //ランダムで攻撃するときの値を返す変数
	}

	public void displayStatus() {
		System.out.println("===敵キャラクター情報===");
		System.out.println("名前" + this.getName());
		System.out.println("素早さ" + this.getSpeed());
		System.out.println("攻撃力" + this.getPower());
		System.out.println("体力" + this.getHp());
	}

	public Random getRandom() {
		return random;
	}

	public int getAttackPattern() {
		return attackPattern;
	}

	public void setAttackPattern(int attackPattern) {
		this.attackPattern = attackPattern;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

}
