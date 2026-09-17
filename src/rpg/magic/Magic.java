package rpg.magic;

import rpg.battleUnit.BattleUnit;

public class Magic {
	private int damage;
	private String name;
	private int mpCost;
	private int hpCost; //hpも消費して使用する魔法が出てきた場合に
	//引数なしの場合。
	public Magic() {
		this.setDamage(10);
		this.name = "魔法XXX";
		this.mpCost = 5;
		this.setHpCost(0);
	}
	
	public Magic(int damage ,String name, int mpCost, int hpCost) {
		this.setDamage(damage);
		this.name = name;
		this.mpCost = mpCost;
		this.setHpCost(hpCost);
	}
	
	public void useMagic(BattleUnit u ,BattleUnit target) {
		u.setMp(Math.max(u.getMp() - this.mpCost, 0)); //maxメソッドを使用してーの値にならないように修正
		
		System.out.println(u.getName() + "は" + this.name + "を唱えた");
		System.out.println("====残りMP====\n");
		System.out.println(u.getMp() + "/" + u.getMaxMp());
		//敵にダメージを与えるためのメソッド。
		target.takeDamage(this.damage);
	}
	
	public boolean useMagicFlag(BattleUnit u) {
		if(u.isAlive() && u.getMp() >= this.mpCost) {
			return true;
		}
		System.out.println("魔法を使用することはできません。");
		return false;
	}

	public int getDamage() {
		return damage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMpCost() {
		return mpCost;
	}

	public void setMpCost(int mpCost) {
		this.mpCost = mpCost;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHpCost() {
		return hpCost;
	}

	public void setHpCost(int hpCost) {
		this.hpCost = hpCost;
	}
}
