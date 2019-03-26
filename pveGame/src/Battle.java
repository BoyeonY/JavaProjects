
public class Battle {
	

	private Characters user;
	private boolean isAttack;
	private Characters enemy;	
	private Object[][] itemList;
	private boolean isDone;
	private boolean winner;
	private String battleResult;
	


	public Battle() {
		this.itemList = Item.itemList;
		this.isDone = false;
		this.winner = false;
	}
	
	
	public String[][] getItemList(){
		String[][] itemList = new String[4][4];
		for(int i=0; i<4; i++) {
			itemList[i][0] = (String)this.itemList[i][0];
			itemList[i][1] = String.valueOf((int)this.itemList[i][1]);
			itemList[i][2] = String.valueOf((int)this.itemList[i][2]);
			itemList[i][3] = String.valueOf((int)this.itemList[i][3]);
		}
		return itemList;
	}

	public void initBattle(User_setting us) {
		if(user==null) {
			this.user = new PlayableCharacter(200, us.getInit_intell(), us.getInit_dex(), us.getInit_stren(), us.getCurrent_gold(), us.getUserName(), us.getCharacter());
			this.enemy = new NonPlayableCharacter(200);
		}
		this.user.setItem(new Item(us.getItem()));
		this.isAttack = true;
	}
	
	
	public String getBattleResult() {
		return battleResult;
	}


	public void setBattleResult(String battleResult) {
		this.battleResult = battleResult;
	}

	public int getUserHp() {
		return this.user.getHealth_point();
	}
	
	public int getEnemyHp() {
		return this.enemy.getHealth_point();
	}
	
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}


	public String getBattle() {
	
		int attackP = 0;
		int defenseP = 0;
		int damage = 0;
		if(isAttack) {
			attackP = user.att();
			defenseP = enemy.def();
			
			
			damage = attackP - defenseP;
			if(damage>0) {
				enemy.setDamaged(damage);
				this.battleResult = user.getCh_name()+" hits "+damage;
			}else {
				this.battleResult = user.getCh_name()+"'s attack is blocked";
			}
			if(enemy.getHealth_point()<=0) {
				this.battleResult = user.getCh_name() + "              WIN!!!!";
				this.battleResult = "You got 200 golds";
				this.isDone = true;
				this.winner = true;
			}
			isAttack = false;
		}else {
			attackP = enemy.att();
			defenseP = user.def();
			damage = attackP - defenseP;
			if(damage>0) {
				user.setDamaged(damage);
				this.battleResult = enemy.getCh_name()+" hits "+damage;
			}else {
				this.battleResult = enemy.getCh_name()+"'s attack is blocked";
			}
			if(user.getHealth_point()<=0) {
				this.battleResult = enemy.getCh_name() + "           WIN!!!!";
				this.isDone = true;
			}
			isAttack = true;
		}
		return this.battleResult+"\n";
	}
	
	public boolean userWin() {
		return this.winner;
	}
		
	
	public void reset() {
		this.user = null;
		this.enemy = null;
		this.winner = false;
		this.isDone = false;
		this.battleResult = "";
	}
	public void reGame() {
		this.user.setHealth_point(200);
		this.enemy.setHealth_point(200);
		this.winner = false;
		this.isDone = false;
		this.battleResult = "";
	}
	
}

