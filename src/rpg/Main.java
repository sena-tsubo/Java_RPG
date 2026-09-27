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
	
	/**
	 * 敵が一人でも生きているかを確認します。
	 * @return 一人でも生きていればtrue、全員倒れていればfalseを返します。
	 */
	public static boolean isEnemiesAlive() {
		// 配列内の敵を一体ずつチェック
		for (int i = 0; i < currentEnemyIndex; i++) {
			// 一体でも生きていれば、その時点でtrueを返す
			if (enemies[i].isAlive()) {
				return true;
			}
		}
		// ループが最後まで終わった（生きている敵がいなかった）場合、falseを返す
		return false;
	}
	
	/**
	 * 味方が一人でも生きているかを確認します。
	 * @return 一人でも生きていればtrue、全員倒れていればfalseを返します。
	 */
	public static boolean isAlliesAlive() {
		// 配列内の味方を一人ずつチェック
		for (int i = 0; i < currentAllyIndex; i++) {
			// 一人でも生きていれば、その時点でtrueを返す
			if (allies[i].isAlive()) {
				return true;
			}
		}
		// ループが最後まで終わった（生きている味方がいなかった）場合、falseを返す
		return false;
	}
	
	//のちのち引数を定義します！
	public static void battle() {
		allies[0] = new Hero("勇者" , 200 , 20 , 10 ,100);
		currentAllyIndex++;
		allies[0].displayStatus();
		spawnEnemies();

		int turnCount = 1;
		//どちらかが全滅するまでループする
		while(isAlliesAlive() && isEnemiesAlive()) {
		    System.out.println(turnCount + "ターン目===");
		    
		    //味方のターン
		    for (int i = 0; i < currentAllyIndex; i++) {
		        if(allies[i].isAlive()) {
		            System.out.println(allies[i].getName() + "のターン");
		            allies[i].attack(enemies, currentEnemyIndex);
		            if (!isEnemiesAlive()) {
		                break;
		            }
		        }
		    }
		    
		    if (!isEnemiesAlive()) {
		        break;
		    }
		    
		    //敵のターン
		    for (int i = 0; i < currentEnemyIndex; i++) {
		        if (enemies[i].isAlive()) {
		            System.out.println(enemies[i].getName() + "のターン");
		            // 生きている味方をランダムに選択
		            Random random = new Random();
		            int targetIndex;
		            do {
		                targetIndex = random.nextInt(currentAllyIndex);
		            } while (!allies[targetIndex].isAlive());
		            
		            enemies[i].attack(allies[targetIndex]);
		            if(!isAlliesAlive()) {
		                break;
		            }
		        }
		    }
		    turnCount++;
		    System.out.println(" ");
		}

		System.out.println("＝＝＝＝　バトル終了　＝＝＝＝");
		if(isAlliesAlive()) {
		    System.out.println("勇者たちの勝利！");
		} else {
		    System.out.println("勇者たちは敗北した...");
		}
	}

}
