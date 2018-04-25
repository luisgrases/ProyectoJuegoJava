package main;

public class Item {
	ItemType type;
	Coordinates coordinates;
	
	public Item(ItemType type) {
		this.type = type;
	}
}

enum ItemType {
	BOAT,
	ROPE,
	MACHETE,
	LIGHTER,
	POTION,
	SWORD,
	BOOTS,
	DRAGON_HEAD
}