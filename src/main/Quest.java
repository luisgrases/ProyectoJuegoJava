package main;

public class Quest {
	String description;
	Item givenItem;
	Item reward;
	ItemType itemNeeded;
	boolean completed;
	
	public Quest(String description, Item givenItem) {
		this.description = description;
		this.givenItem = givenItem;
//		this.reward = reward;
//		this.itemNeeded = itemNeeded;
	}
}