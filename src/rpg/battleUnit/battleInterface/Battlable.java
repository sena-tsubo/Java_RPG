package rpg.battleUnit.battleInterface;

import rpg.battleUnit.BattleUnit;

public interface Battlable {
	//public abstract takeDamage(int damage)
	void takeDamage(int damage); //ダメージを受けた時のインターフェース
	void attack(BattleUnit unit); //引数はのちのち指定します。
	boolean isAlive(); //hpが０より大きい場合にtrueを返す。
	void heal(BattleUnit unit,int h); //引数はのちのち指定します。
	void displayStatus(); //全ステータスを表示します。
}
