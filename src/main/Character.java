package main;

import java.util.ArrayList;

public class Character implements Coordinateable {
	String name;
	int level;
	ArrayList<Item> items;
	Coordinates coordinates;
	Map map;
	Quest quest;
	
	public Character(String name, Coordinates coordinates, Map map) {
		this.map = map;
		this.name = name;
		this.coordinates = coordinates;
		this.items = new ArrayList<Item>();
	}
	
	public void setCoordinates(int x, int y) {
		if(map.tiles[y][x].isWalkableForCharacter(this)) {
			this.coordinates = new Coordinates(x, y);
		}
		if(map.tiles[y][x].hasNPC()) this.talkToNPC((NPC) map.tiles[y][x].coordinatable);
		if(map.tiles[y][x].hasAliveMonster()) this.fightMonster((Monster) map.tiles[y][x].coordinatable);
	}
	
	public void talkToNPC(NPC npc) {
		npc.talkToCharacter(this);
	}
	
	public void fightMonster(Monster monster) {
		 monster.die();
		 this.items.add(getMonsterLoot(monster));
	}
	
	public Item getMonsterLoot(Monster monster) {
		System.out.println("Has obtenido " + monster.loot);
		return new Item(monster.loot);
	}
	
	public boolean canCompleteQuest() {
		return (this.quest != null) && this.hasItem(this.quest.itemNeeded);
	}
	
	public void setQuest(Quest quest) {
		this.quest = quest;
		if(quest.givenItem != null) this.addItem(quest.givenItem);
	}
	
	public void addItem(Item item) {
		this.items.add(item);
		System.out.println("Has obtenido un " + item.type);
	}
	
	public void moveUp() {
		this.setCoordinates(this.coordinates.x, this.coordinates.y-1);
	}
	
	public void moveDown() {
		this.setCoordinates(this.coordinates.x, this.coordinates.y+1);
	}
	
	public void moveLeft() {
		this.setCoordinates(this.coordinates.x-1, this.coordinates.y);
	}
	
	public void moveRight() {
		this.setCoordinates(this.coordinates.x+1, this.coordinates.y);
	}
	
	public Coordinates getCoordinates() {
		return this.coordinates;
	}

	public boolean hasItem(ItemType itemType) {
		if(itemType == null) return true;
		for(Item item: this.items) {	
			if(itemType.equals(item.type)) return true;	
		}
		return false;
	}
}


