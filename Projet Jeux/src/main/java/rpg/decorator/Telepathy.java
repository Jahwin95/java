package rpg.decorator;

import rpg.core.Character;

public class Telepathy extends CharacterDecorator {
    
    public Telepathy(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    
    @Override
    public int getPowerLevel() {
        // Telepathy adds 20% plus intelligence bonus to power level
        return (int)(super.getPowerLevel() * 1.2) + getIntelligence() * 2;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + Telepathy ability";
    }
}