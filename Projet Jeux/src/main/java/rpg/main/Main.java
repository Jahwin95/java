package rpg.main;

import rpg.builder.CharacterBuilder;
import rpg.core.Character;
import rpg.core.Party;
import rpg.dao.CharacterDAO;
import rpg.decorator.FireResistance;
import rpg.decorator.Invisibility;
import rpg.decorator.Telepathy;
import rpg.settings.GameSettings;

public class Main {
    public static void main(String[] args) {
        System.out.println("RPG Character Generator Demo");
        System.out.println("===========================");
        
        // Initialize DAO
        CharacterDAO characterDAO = new CharacterDAO();
        
        try {
            // Create basic characters using builder pattern
            Character warrior = new CharacterBuilder()
                    .setName("Aragorn")
                    .setStrength(10)
                    .setAgility(8)
                    .setIntelligence(6)
                    .build();
            
            Character mage = new CharacterBuilder()
                    .setName("Gandalf")
                    .setStrength(5)
                    .setAgility(7)
                    .setIntelligence(15)
                    .build();
            
            Character rogue = new CharacterBuilder()
                    .setName("Legolas")
                    .setStrength(7)
                    .setAgility(12)
                    .setIntelligence(8)
                    .build();
            
            // Decorate characters with special abilities
            Character invisibleRogue = new Invisibility(rogue);
            Character fireResistantWarrior = new FireResistance(warrior);
            Character telepathicMage = new Telepathy(mage);
            
            // Save characters to DAO
            characterDAO.save(warrior);
            characterDAO.save(mage);
            characterDAO.save(rogue);
            characterDAO.save(invisibleRogue);
            characterDAO.save(fireResistantWarrior);
            characterDAO.save(telepathicMage);
            
            // Display character information
            System.out.println("\nCharacter Data:");
            System.out.println("--------------");
            displayCharacter(warrior);
            displayCharacter(mage);
            displayCharacter(rogue);
            
            // Display decorated character information
            System.out.println("\nDecorated Character Data:");
            System.out.println("------------------------");
            displayCharacter(invisibleRogue);
            displayCharacter(fireResistantWarrior);
            displayCharacter(telepathicMage);
            
            // Create a party
            Party fellowship = new Party("The Fellowship");
            fellowship.addCharacter(invisibleRogue);
            fellowship.addCharacter(fireResistantWarrior);
            fellowship.addCharacter(telepathicMage);
            
            // Display party information
            System.out.println("\nParty Information:");
            System.out.println("-----------------");
            System.out.println(fellowship.getDescription());
            
            // Sort party by power level
            fellowship.sortByPowerLevel();
            System.out.println("\nParty Sorted by Power Level:");
            System.out.println("---------------------------");
            System.out.println(fellowship.getDescription());
            
            // Sort party by name
            fellowship.sortByName();
            System.out.println("\nParty Sorted by Name:");
            System.out.println("--------------------");
            System.out.println(fellowship.getDescription());
            
            // Test game rules validation
            System.out.println("\nGame Rules Validation:");
            System.out.println("---------------------");
            try {
                Character invalidCharacter = new CharacterBuilder()
                        .setName("Invalid")
                        .setStrength(20)
                        .setAgility(20)
                        .setIntelligence(20)
                        .build();
                System.out.println("Character validation successful: " + invalidCharacter.getName());
            } catch (IllegalStateException e) {
                System.out.println("Character validation failed: " + e.getMessage());
            }
            
            // Simulate combat between characters
            System.out.println("\nCombat Simulation:");
            System.out.println("-----------------");
            System.out.println(GameSettings.getInstance().simulateCombat(fireResistantWarrior, telepathicMage));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void displayCharacter(Character character) {
        System.out.println(character.getDescription());
    }
}