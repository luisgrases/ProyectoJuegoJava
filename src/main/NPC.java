package main;

public class NPC implements Coordinateable {
	String name;
	Coordinates coordinates;
	Quest quest;
	String dialogue;
	
	public NPC(String name, Coordinates coordinates, String dialogue) {
		this.name = name;
		this.coordinates = coordinates;
		this.dialogue = dialogue;
	}
	
	public Coordinates getCoordinates() {
		return this.coordinates;
	}
	
	public void giveQuestToCharacter(Character character) {
		System.out.println("Necesito que hagas algo por mi: "+ quest.description);
		if(this.quest.givenItem != null) System.out.println("Es probable que necesites este objeto: ");
		character.setQuest(quest);
	}
	
	public void talkToCharacter(Character character) {
		System.out.println(this.dialogue);
		if(!this.quest.completed && character.quest == null) this.giveQuestToCharacter(character);
		if(!this.quest.completed && character.canCompleteQuest()) this.completeQuest(character);
	}
	
	public void completeQuest(Character character) {
		this.quest.completed = true;
		System.out.println(this.quest.completionDialogue);
	}
}
