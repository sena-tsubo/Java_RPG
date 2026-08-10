package rpg.battleUnit;

import rpg.Character;
import rpg.battleUnit.battleInterface.Battlable;
//戦いをするクラスの親クラス
public abstract class BattleUnit extends Character implements Battlable {
	private int hp;
	private int speed;
	private int power;
	private int maxHp;
	private int maxSpeed;
	private int maxPower;
	private int mp;
	private int maxMp;
	public BattleUnit(String name ,int hp, int speed, int power) {
		super(name);
		setHp(hp);
		setSpeed(speed);
		this.power = power;
		this.maxHp = this.hp;
		this.maxSpeed = this.speed;
		this.maxPower = this.power;
	}
	
	public void takeDamage(int damage) {
		this.hp -= damage;
		if (this.hp  < 0) {
			this.hp = 0; //もしダメージ受けてHPがマイナスになる場合には強制的に０にする。
		}
		System.out.println(this.getName() + "は" + damage + "喰らった残り  " + this.hp + " / " + this.maxHp);
	}
	
	public void attack(BattleUnit u) {
		if (isAlive()) {
			System.out.println(this.getName() + "は"+ u.getName() + "に対して攻撃を行った");
			u.takeDamage(this.power);	
		} else {
			System.out.println(getName() + "は倒れた");
		}
	}
	
	public void heal(BattleUnit u , int healAmount) {
		System.out.println(u.getName()+"は" + healAmount + "回復した");
		u.hp = Math.min(u.hp + healAmount, u.maxHp);
	}
	
	public boolean isAlive() {
		return  this.hp > 0;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		if (hp > 0) {
			this.hp = hp; //hpが１より大きい値であるどうか
		} else {
			this.hp = 1;
		}
		
	}
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		if (speed > 0) {
			this.speed = speed;
		} else {
			this.speed = 1;
		}
	}
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getMaxPower() {
		return maxPower;
	}
	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getMaxMp() {
		return maxMp;
	}

	public void setMaxMp(int maxMp) {
		this.maxMp = maxMp;
	}


}
