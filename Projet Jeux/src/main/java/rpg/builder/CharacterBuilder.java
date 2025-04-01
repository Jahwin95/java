package rpg.builder;

import rpg.core.Character;
import rpg.settings.GameSettings;

public class CharacterBuilder {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    public CharacterBuilder() {
        // Default values
        this.name = "Unknown";
        this.strength = 1;
        this.agility = 1;
        this.intelligence = 1;
    }

    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CharacterBuilder setStrength(int strength) {
        this.strength = Math.max(1, strength); // Ensure minimum value of 1
        return this;
    }

    public CharacterBuilder setAgility(int agility) {
        this.agility = Math.max(1, agility); // Ensure minimum value of 1
        return this;
    }

    public CharacterBuilder setIntelligence(int intelligence) {
        this.intelligence = Math.max(1, intelligence); // Ensure minimum value of 1
        return this;
    }

    // Build method that creates a new Character
    public Character build() throws IllegalStateException {
        Character character = new Character(name, strength, agility, intelligence);
        
        // Validate character against game rules
        if (!GameSettings.getInstance().isValid(character)) {
            throw new IllegalStateException("Character stats exceed maximum allowed points: " + 
                                          GameSettings.getInstance().getMaxStatPoints());
        }
        
        return character;
    }
}