package rpg.dao;

import rpg.core.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharacterDAO implements DAO<Character> {
    // In-memory storage for simplicity
    private final Map<String, Character> characters = new HashMap<>();

    @Override
    public void save(Character character) {
        if (character != null) {
            characters.put(character.getName(), character);
        }
    }

    @Override
    public Character findByName(String name) {
        return characters.get(name);
    }

    @Override
    public List<Character> findAll() {
        return new ArrayList<>(characters.values());
    }
    
    @Override
    public boolean delete(String name) {
        if (characters.containsKey(name)) {
            characters.remove(name);
            return true;
        }
        return false;
    }
    
    // Helper method to clear all characters (useful for testing)
    public void clear() {
        characters.clear();
    }
}