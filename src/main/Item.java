package main;

public class Item {
	ItemType type;
	Coordinates coordinates;
}

enum ItemType {
	BOAT,
	ROPE,
	MACHETE,
	LIGHTER,
	POTION,
	SWORD,
	BOOTS;
}