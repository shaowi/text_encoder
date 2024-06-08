import java.util.HashMap;
import java.util.Map;

public class ReferenceTable {
    private static ReferenceTable instance;
    private Map<Character, Integer> referenceTable;

    private ReferenceTable() {
        // Create the reference table mapping here
        Map<Character, Integer> referenceTable = new HashMap<>();
        int numAlphabets = 26;
        int decA = 65;
        char[] symbols = { '(', ')', '*', '+', ',', '-', '.', '/' };
        int i = 0;

        // Add the 26 alphabets to the reference table
        while (i < numAlphabets) {
            referenceTable.put((char) (i + decA), i);
            i += 1;
        }

        // Add the 10 digits to the reference table
        for (int j = 0; j < 10; j++) {
            referenceTable.put((char) ('0' + j), i);
            i += 1;
        }

        // Add the symbols to the reference table
        for (int j = 0; j < symbols.length; j++) {
            referenceTable.put(symbols[j], i);
            i += 1;
        }

        this.referenceTable = referenceTable;
    }

    public static ReferenceTable getInstance() {
        if (instance == null) {
            instance = new ReferenceTable();
        }
        return instance;
    }

    public int getIndex(char character) {
        return referenceTable.get(character);
    }

    public Character getCharacter(int index) {
        for (Map.Entry<Character, Integer> entry : referenceTable.entrySet()) {
            if (entry.getValue() == index) {
                return entry.getKey();
            }
        }
        return null;
    }

    public int getTotalCharacters() {
        return referenceTable.size();
    }

    public void printString() {
        for (Map.Entry<Character, Integer> entry : referenceTable.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
