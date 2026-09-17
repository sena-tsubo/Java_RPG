package rpg;

import java.util.Random;

import rpg.battleUnit.ally.Ally;
import rpg.battleUnit.ally.Hero;
import rpg.battleUnit.enemy.Enemy;
import rpg.battleUnit.enemy.Goblin;
import rpg.battleUnit.enemy.Golem;
import rpg.battleUnit.enemy.Slime;
public class Main {
	//敵キャラクターを格納する配列を用意する。要素数は3
	static Enemy[] enemies = new Enemy[3]; 
	//味方キャラクターを格納する配列を用意する。要素数は3
	static Ally[] allies = new Ally[3];
	//敵・味方の配列の添え字を管理する。最初は空なので、0とする。
	static int currentAllyIndex = 0;
	static int currentEnemyIndex = 0;
	public static void main(String[] args) {
		battle();
	}
	
	public static void spawnEnemies() {
	    Random random = new Random();
	    int spawnCount = random.nextInt(3)+1; // 1, 2, 3

	    for (int i = 0; i < spawnCount; i++) {
	        // 配列の最大サイズを超えて敵を生成しないように制御
	        if (currentEnemyIndex >= enemies.length) {
	            break; 
	        }

	        int enemyType = random.nextInt(3) + 1; // 1, 2, 3
	        
	        // Switch式を使用して、敵のインスタンス生成のみを行う（コードの重複を排除）
	        Enemy newEnemy = switch (enemyType) {
	            case 1 -> new Slime("すらいむ", 120, 15, 10);
	            case 2 -> new Goblin("ごぶりん", 130, 15, 10);
	            default -> new Golem("ご-れむ", 130, 15, 10);
	        };

	        // 配列に格納し、そのインスタンスのステータスを表示する
	        enemies[currentEnemyIndex] = newEnemy;
	        enemies[currentEnemyIndex].displayStatus();
	        
	        // 次の敵を格納するためにインデックスを1つ進める
	        currentEnemyIndex++;
	    }
	    
	    System.out.println("敵の数は" + spawnCount);
	}
	
	public static boolean isEnemiesAlive() {
		int count = 0;
		for (int i = 0; i < currentEnemyIndex; i++) {
			if(!enemies[i].isAlive()) {
				count++;
			}
		}
		return count < currentEnemyIndex;
	}
	
	public static boolean isAlliesAlive() {
		int count = 0;
		for (int i = 0; i < currentAllyIndex; i++) {
			if(!allies[i].isAlive()) {
				count++;
			}
		}
		
		return count < currentAllyIndex;
	}
	
	public static boolean enemyArrayoutOf(int enemy) {
		return enemy < currentEnemyIndex;
	}
	
	public static boolean allyArrayoutOf(int ally) {
		return ally < currentAllyIndex;
	}
	
	//のちのち引数を定義します！
	public static void battle() {
		allies[0] = new Hero("勇者" , 200 , 20 , 10 ,100);
		currentAllyIndex++;
		allies[0].displayStatus();
		spawnEnemies();
		int enemy = 0; //どの敵のターンか調べている。
		int ally = 0; //どの味方のターンか調べている。
		while(isAlliesAlive() && isEnemiesAlive()) {
			System.out.println("戦闘開始");
			
		}
		//左辺の式の型指定を(多態性)を使用してどの敵モブでも動くようにして
//		Enemy enemy = new Goblin("ゴブリン",130, 12, 5); 
//		Hero hero = new Hero("勇者" , 150, 15,10,100);
//		int count = 1;
//		while(enemy.isAlive() && hero.isAlive()) {
//			System.out.println(count++ + "ターン目===");
//			if (enemy.getSpeed() > hero.getSpeed()) {
//				enemy.attack(hero);
//				hero.attack(enemy);
//				System.out.println(" ");
//			} else {
//				hero.attack(enemy);
//				enemy.attack(hero);
//				System.out.println(" ");
//			}
//		}
//		System.out.println("＝＝＝＝　バトル終了　＝＝＝＝");
//		if(enemy.isAlive()) {
//			System.out.println("スライムの勝利");
//		} else {
//			System.out.println(hero.getName() + "の勝利");
//		}
	}

}
