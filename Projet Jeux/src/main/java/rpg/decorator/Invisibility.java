package rpg.decorator;

import rpg.core.Character;

public class Invisibility extends CharacterDecorator {
    
    public Invisibility(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    
    @Override
    public int getPowerLevel() {
        // Invisibility increases power level by 30%
        return (int)(super.getPowerLevel() * 1.3);
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + Invisibility ability";
    }
}