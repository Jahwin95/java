package rpg.decorator;

import rpg.core.Character;

public abstract class CharacterDecorator extends Character {
    protected Character decoratedCharacter;

    public CharacterDecorator(Character decoratedCharacter) {
        // Call the parent constructor with the decorated character's stats
        super(decoratedCharacter.getName(), 
              decoratedCharacter.getStrength(), 
              decoratedCharacter.getAgility(), 
              decoratedCharacter.getIntelligence());
        
        this.decoratedCharacter = decoratedCharacter;
    }

    @Override
    public int getPowerLevel() {
        return decoratedCharacter.getPowerLevel();
    }

    @Override
    public String getDescription() {
        return decoratedCharacter.getDescription();
    }
    
    @Override
    public int getTotalStatPoints() {
        return decoratedCharacter.getTotalStatPoints();
    }
}