import java.util.Random;

public class Item {
	private String itemName;
	private int atk;
	private int def;
	private int gold;
	public static final Object[][] itemList = new Object[][] {
			{"Hammer", 10, 0, 600}
			, {"Armor", 0, 10, 300}
			, {"MagicStaff", 10, 0, 600}
			, {"Spear", 10, 0, 600}
	};
	
	public Item(String itemName) {
		this.itemName = itemName;
		
		for(Object[] item: itemList) {
			if(((String)item[0]).equals(itemName)) {
				this.atk = (int)item[1];
				this.def = (int)item[2];
				this.gold = (int)item[3];
			}
		}
	}

	public String getItemName() {
		return itemName;
	}

	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public int getGold() {
		return gold;
	}
	
	
}