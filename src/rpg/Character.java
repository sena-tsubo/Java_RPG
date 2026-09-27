package rpg;
//基底クラス
public abstract class Character {
	private String name;
	private String role;
	public Character(String name) {
		//Character c = new Character("aaa");
		this.name = name;
		this.role = "アンノウン"; //商人、敵、判別するための変数
	}
	
	public Character() {
		
	}
	
//	public abstract void kkk();
	
	//Character c = new Character()
	//c.name 
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
