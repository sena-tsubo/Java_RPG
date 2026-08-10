package rpg;

import rpg.battleUnit.ally.Hero;
import rpg.battleUnit.enemy.Enemy;
import rpg.battleUnit.enemy.Golem;
import rpg.battleUnit.enemy.Slime;
public class Main {

	public static void main(String[] args) {
		Slime slime = new Slime("すらいむ",120,15,10);
		//左辺の式の型指定を(多態性)を使用してどの敵モブでも動くようにして
		Enemy enemy = new Golem("ゴーレム",130, 12, 10); 
		Hero hero = new Hero("客先常駐" , 150, 15,15,100);
		int count = 1;
		while(enemy.isAlive() && hero.isAlive()) {
			System.out.println(count++ + "ターン目===");
			if (enemy.getSpeed() > hero.getSpeed()) {
				enemy.attack(hero);
				hero.attack(enemy);
			} else {
				hero.attack(enemy);
				enemy.attack(hero);
			}
		}
		System.out.println("＝＝＝＝　バトル終了　＝＝＝＝");
		if(enemy.isAlive()) {
			System.out.println("スライムの勝利");
		} else {
			System.out.println(hero.getName() + "の勝利");
		}
	}

}
