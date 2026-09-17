package rpg.battleUnit.enemy;

import rpg.battleUnit.BattleUnit;

public class Goblin extends Enemy {
	private int powerUpRate;
	private int powerUpTrun;
	private int powerUpCount;
	public Goblin(String name, int hp, int speed, int power) {
		super(name, hp, speed, power);
		this.powerUpRate = 50; //50%攻撃力アップ
		this.powerUpTrun = 3;//攻撃力アップターンを格納
		this.powerUpCount = 1; //攻撃力アップは1回のみです
	}
	
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (powerUpFlag()) {
			//このエラーはカプセル化のため出現しています。直してください。
			setPower( (int) (this.getPower() + this.getPower() * (this.powerUpRate * 0.01)) );
			System.out.println(this.getName() + "攻撃力が上がった");
			this.powerUpCount--;
		}
	}
	
	public void attack(BattleUnit u) {
		if (this.powerUpCount <= 0 ) {
			System.out.println("最初のifブロックは動いています。" + this.powerUpCount);
			this.powerUpTrun--;
			if(this.powerUpTrun <= 0) {
				System.out.println(this.getName() + "の怒りがおさまった");
				this.setPower(this.getMaxPower());
			}
		}
		super.attack(u);
	}
	
	private boolean powerUpFlag() {
		//ゴブリンの体力が2/1かどうかを判定する。パワーアップのフラグがたったらカウントをー１する。
		return this.getMaxHp() / 2 > this.getHp() && this.powerUpCount > 0; 
	}

}
