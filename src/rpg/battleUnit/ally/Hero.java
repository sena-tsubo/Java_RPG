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
				//魔法を選択してもらう
				Magic selectedMagic = this.selectMagic();
				if (selectedMagic.useMagicFlag(this)) {
					selectedMagic.useMagic(this, u);
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

	//魔法一覧を表示して、使いたい魔法を選んでもらうメソッド
	public Magic selectMagic() {
		System.out.println("===魔法一覧===");
		//持っている魔法の数だけ番号をつけて表示する
		for (int i = 0; i < this.currentIndex; i++) {
			Magic m = this.magicArray[i];
			System.out.println((i + 1) + "." + m.getName() + " (MP消費:" + m.getMpCost() + ")");
		}
		System.out.println("使用する魔法の番号を選んでください");
		int select = this.getSc().nextInt();
		//選んだ番号が魔法の数の範囲内かチェックする
		if (select < 1 || select > this.currentIndex) {
			System.out.println("無効な値です。もう一度選択してください。");
			return this.selectMagic();
		}
		//番号は1から始まるので、配列の添字に合わせるため-1する
		return this.magicArray[select - 1];
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
