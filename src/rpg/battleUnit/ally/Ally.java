package rpg.battleUnit.ally;

import java.util.Scanner;

import rpg.battleUnit.BattleUnit;
import rpg.battleUnit.enemy.Enemy;

public abstract class Ally extends BattleUnit {
	private Scanner sc;
	
	public Ally(String name, int hp, int speed, int power) {
		super(name, hp, speed, power);
		
		this.setSc(new Scanner(System.in));
	}
	
	
	public int attackSelect() {
		System.out.println("攻撃を選択してください");
		System.out.println("1.攻撃");
		System.out.println("2.魔法");
		System.out.println("3.アイテム");
		int select = this.sc.nextInt();
		
		if (select > 3 || select < 1) {
			System.out.println("無効な値です。もう一度選択してください。");
			attackSelect();
		}
		return select;
	}
	
	/*複数の敵の中から攻撃対象を１体選択して攻撃をする*/
	public void attack(Enemy[] enemies, int enemyCount) {
		System.out.println("どの敵に攻撃しますか？");
		//生きている敵を一覧表示する
		for (int i = 0; i < enemyCount;i++) {
			if ( enemies[i].isAlive()) {
				System.out.println("+------------" +( i + 1) + "-----------+" );
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


	
	

	public void displayStatus() {
		System.out.println("===味方キャラクター情報===");
		System.out.println("名前" + this.getName());
		System.out.println("素早さ" + this.getSpeed());
		System.out.println("攻撃力" + this.getPower());
		System.out.println("体力" + this.getHp());
	}

	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

}
