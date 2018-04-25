package main;

public class Quest {
	String description;
	Item givenItem;
	Item reward;
	String completionDialogue;
	ItemType itemNeeded;
	boolean completed;
	
	public Quest(String description, Item givenItem, ItemType itemNeeded, String completionDialogue) {
		this.description = description;
		this.givenItem = givenItem;
		this.itemNeeded = itemNeeded;
		this.completionDialogue = completionDialogue;
	}
}