package rpg.settings;

import rpg.core.Character;

public class GameSettings {
    private static GameSettings instance;
    private final int maxStatPoints;
    
    // Private constructor to prevent direct instantiation
    private GameSettings() {
        // Default maximum stat points
        this.maxStatPoints = 30;
    }
    
    // Get singleton instance
    public static GameSettings getInstance() {
        if (instance == null) {
            synchronized (GameSettings.class) {
                if (instance == null) {
                    instance = new GameSettings();
                }
            }
        }
        return instance;
    }
    
    // Get maximum stat points
    public int getMaxStatPoints() {
        return maxStatPoints;
    }
    
    // Validate if character respects the game rules
    public boolean isValid(Character character) {
        if (character == null) {
            return false;
        }
        
        // Check if total stat points are within the allowed limit
        return character.getTotalStatPoints() <= maxStatPoints;
    }
    
    // Method to simulate a basic combat between two characters
    public String simulateCombat(Character char1, Character char2) {
        StringBuilder result = new StringBuilder();
        
        // Basic combat simulation based on power levels
        int power1 = char1.getPowerLevel();
        int power2 = char2.getPowerLevel();
        
        result.append("Combat: ").append(char1.getName())
              .append(" (Power: ").append(power1)
              .append(") vs ").append(char2.getName())
              .append(" (Power: ").append(power2).append(")\n");
        
        // Determine winner
        if (power1 > power2) {
            result.append(char1.getName()).append(" wins!");
        } else if (power2 > power1) {
            result.append(char2.getName()).append(" wins!");
        } else {
            result.append("It's a tie!");
        }
        
        return result.toString();
    }
}