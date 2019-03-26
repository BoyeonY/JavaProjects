
public class User_setting {
	private String character;
	private String userName;
	private int init_stren;
	private int init_intell;
	private int init_dex;
	private String item;
	private int current_gold=0;
	private int used_gold=0;
	private int health_point;
	private int enemy_health_point;
	private int default_gold;
	private boolean isDone;
	private String battleResult;
	private int reward=200;
	
	public User_setting() {
		this.default_gold = 500;
		this.current_gold = this.default_gold;
		this.character = "Monster";
		
	}
	
	//get,set 
	public String getCharacter() {
		return character;
	}
	
	
	public void setCharacter(String character) {
		this.character = character;
	}
	public int getInit_stren() {
		return init_stren;
	}
	public void setInit_stren(int init_stren) {
		this.init_stren = init_stren;
	}
	public int getInit_intell() {
		return init_intell;
	}
	public void setInit_intell(int init_intell) {
		this.init_intell = init_intell;
	}
	public int getInit_dex() {
		return init_dex;
	}
	public void setInit_dex(int init_dex) {
		this.init_dex = init_dex;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	public int getUsed_gold() {
		return used_gold;
	}
	public void setUsed_gold(int used_gold) {
		this.used_gold = used_gold;
	}
	public int getCurrent_gold() {
		return current_gold;
	}
	public void setCurrent_gold(int current_gold) {
		this.current_gold = current_gold;
	}
	
	public int current_gold(int dgold,int ugold) {
		this.default_gold = this.default_gold - this.used_gold;
		return default_gold;
	}
	
	public int getHealth_point() {
		return health_point;
	}
	public void setHealth_point(int health_point) {
		this.health_point = health_point;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getEnemy_health_point() {
		return enemy_health_point;
	}

	public void setEnemy_health_point(int enemy_health_point) {
		this.enemy_health_point = enemy_health_point;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public String getBattleResult() {
		return battleResult;
	}

	public void setBattleResult(String battleResult) {
		this.battleResult = battleResult;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}
	
	
}
