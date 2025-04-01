package rpg.decorator;

import rpg.core.Character;

public class FireResistance extends CharacterDecorator {
    
    public FireResistance(Character decoratedCharacter) {
        super(decoratedCharacter);
    }
    
    @Override
    public int getPowerLevel() {
        // Fire resistance adds 20 to power level
        return super.getPowerLevel() + 20;
    }
    
    @Override
    public String getDescription() {
        return super.getDescription() + " + Fire Resistance ability";
    }
}