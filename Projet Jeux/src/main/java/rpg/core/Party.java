package rpg.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Party {
    private String partyName;
    private List<Character> members;

    public Party(String partyName) {
        this.partyName = partyName;
        this.members = new ArrayList<>();
    }

    // Add a character to the party
    public void addCharacter(Character character) {
        if (character != null) {
            members.add(character);
        }
    }

    // Remove a character from the party
    public boolean removeCharacter(String characterName) {
        return members.removeIf(character -> character.getName().equals(characterName));
    }

    // Calculate total power of the party
    public int getTotalPower() {
        return members.stream()
                .mapToInt(Character::getPowerLevel)
                .sum();
    }

    // Get all party members
    public List<Character> getMembers() {
        return new ArrayList<>(members);
    }

    // Sort party members by power level (descending)
    public void sortByPowerLevel() {
        Collections.sort(members, Comparator.comparing(Character::getPowerLevel).reversed());
    }

    // Sort party members by name (alphabetically)
    public void sortByName() {
        Collections.sort(members, Comparator.comparing(Character::getName));
    }

    // Get party description
    public String getDescription() {
        StringBuilder description = new StringBuilder("Party: " + partyName + " (Total Power: " + getTotalPower() + ")\n");
        description.append("Members:\n");
        
        for (Character character : members) {
            description.append("- ").append(character.getDescription()).append("\n");
        }
        
        return description.toString();
    }
}