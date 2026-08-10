package rpg.battleUnit.ally;

import rpg.battleUnit.BattleUnit;
import rpg.magic.Magic;

public class Hero extends Ally {
	//勇者が持っている魔法一覧
	private Magic[] magicArray;
	private int currentIndex;
	public Hero(String name, int hp, int speed, int power,int mp) {
		super(name, hp, speed, power);
		this.setMp(mp);
		this.magicArray = new Magic[5]; //勇者は最大5個の魔法を持てる[ , , , , ]
		this.currentIndex = 0;
		this.initialMagicArray();
	}
	
	public void attack(BattleUnit u) {
		int select = attackSelect();
		switch(select) {
			case 1 -> {
				super.attack(u);
			}
			
			case 2 -> {
				if (this.magicArray[2].useMagicFlag(this)) {
					this.magicArray[2].useMagic(this, u);
				} else {
					super.attack(u);
				}
				
			}
			
			case 3 -> {
				System.out.println("アイテム:仮の設定です。後々実装いたします。");
				super.attack(u);
			}
		}
	}
	
	//初期で勇者が持っている魔法を入れる
	public void initialMagicArray() {
		// damage name mpCost hpCost
		Magic fireBoll = new Magic(25, "ファイアーボール", 20,0);
		magicArray[this.currentIndex++] = fireBoll;
		Magic iceBoll = new Magic(20 , "アイスボール",15,0);
		magicArray[this.currentIndex++] = iceBoll;
		Magic horobi = new Magic(50 , "滅び" , 40 , 0);
		magicArray[this.currentIndex++] = horobi;
	}
	
	public void addMagic(int d , String n,int mpCost, int hpCost) {
		magicArray[currentIndex++] =new Magic(d,n,mpCost,hpCost);
	}
	
	public Magic[] getMagicArray() {
		return magicArray;
	}
	
	public void setMagicArray(Magic[] magicArray) {
		this.magicArray = magicArray;
	}
	
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	

}
