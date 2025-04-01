package rpg.core;

public class Character {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;

    // Constructor with all parameters
    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    // Calculate power level based on character stats
    public int getPowerLevel() {
        return strength * 2 + agility + intelligence * 3;
    }

    // Get character description
    public String getDescription() {
        return "Character: " + name + " [Strength: " + strength + 
               ", Agility: " + agility + ", Intelligence: " + intelligence + 
               ", Power Level: " + getPowerLevel() + "]";
    }
    
    // Get sum of all stats for validation
    public int getTotalStatPoints() {
        return strength + agility + intelligence;
    }
}