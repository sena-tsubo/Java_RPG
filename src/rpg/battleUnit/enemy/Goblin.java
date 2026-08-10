package rpg.battleUnit.enemy;

public class Goblin extends Enemy {
	private int powerUpRate;
	private int powerUpTrun;

	public Goblin(String name, int hp, int speed, int power) {
		super(name, hp, speed, power);
		this.powerUpRate = 50; //50%攻撃力アップ
		this.powerUpTrun = 3;//攻撃力アップターンを格納
	}
	
	public void takeDamage(int damage) {
		super.takeDamage(damage);
		if (powerUpFlag()) {
			//このエラーはカプセル化のため出現しています。直してください。
			setPower( (int) (this.getPower() + this.getPower() * (this.powerUpRate * 0.01)) );
			System.out.println(this.getName() + "攻撃力が上がった");
		}
		
	}
	
	private boolean powerUpFlag() {
		return this.getMaxHp() / 4 > this.getHp(); //ゴブリンの体力が4/1かどうかを判定する。
	}

}
