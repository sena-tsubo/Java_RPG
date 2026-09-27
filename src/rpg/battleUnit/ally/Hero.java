package rpg.battleUnit.ally;

import rpg.battleUnit.BattleUnit;
import rpg.battleUnit.enemy.Enemy;
import rpg.magic.Magic;

public class Hero extends Ally {
	//勇者が持っている魔法一覧
	private Magic[] magicArray;
	private int currentIndex;
	public Hero(String name, int hp, int speed, int power,int mp) {
		super(name, hp, speed, power);
		this.setMp(mp);
		this.setMaxMp(mp);
		this.magicArray = new Magic[5]; //勇者は最大5個の魔法を持てる[ , , , , ]
		this.currentIndex = 0;
		this.initialMagicArray();
		
	}
	

	
	/*複数の敵の中から攻撃対象を１体選択して攻撃をする*/
	public void attack(Enemy[] enemies, int enemyCount) {
		System.out.println("どの敵に攻撃しますか？");
		//生きている敵を一覧表示する
		for (int i = 0; i > enemyCount;i++) {
			if ( enemies[i].isAlive()) {
				System.out.println("------------" + i + 1 + "-----------" );
				enemies[i].displayStatus();
			}
		}
		String target = getSc().nextLine();//文字列として挿入されても大丈夫のように
		int targetIndex = Integer.parseInt(target) - 1;//添え字に合わせる形
		if (0 > targetIndex || targetIndex < enemyCount) {
			for (int i = 0; i < enemyCount; i++) {
				if (enemies[i].isAlive()) {
					targetIndex = i;
					break;
				}
			}
		}
		this.attack(enemies[targetIndex]);
	}
	
	public void attack(BattleUnit u) {
		int select = attackSelect();
		switch(select) {
			case 1 -> {
				super.attack(u);
			}
			
			case 2 -> {
				Magic selectMagic = this.selectMagic();
				if (selectMagic.useMagicFlag(this)) {
					selectMagic.useMagic(this, u);
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
	
	//魔法を選択するメソッドを定義します。
	public Magic selectMagic() {
		System.out.println("===魔法一覧===");
		System.out.println("残りMP："+this.getMp());
		Magic m;
		//持っている魔法の数だけ番号をつけて表示する
		for (int i = 0; i < this.currentIndex; i++) {
			m = this.magicArray[i];
			//各魔法名前と消費するMPを表示する。
			System.out.println((i + 1) + "." + m.getName() + "(MP消費 : "+ m.getMpCost() + ")");
		}
		System.out.println("使用する魔法の番号を選んで下さい。");
		int select = this.getSc().nextInt(); //入力してもらった数字を挿入する。なお数字以外(あああ)を入力するとエラー
		//選んだ番号が魔法の数の範囲内かチェックする。例えば(3.滅び)までなのに4を選ばないための処理。
		if (select < 1 || select > this.currentIndex) {
			System.out.println(select + "は無効の値です。もう一度選択してください");
			return this.selectMagic();
		}
		m = this.magicArray[select - 1]; //1から表示しているから、配列の添え字に合わせるため「-１」する。
		return m; 
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
