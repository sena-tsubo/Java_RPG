package rpg;
//基底クラス
public abstract class Character {
	private String name;
	private String role;
	public Character(String name) {
		this.name = name;
		this.role = "アンノウン"; //商人、敵、判別するための変数
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}	
	
}
