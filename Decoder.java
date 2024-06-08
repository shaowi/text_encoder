public class Decoder {
    private static Decoder instance;

    private Decoder() {
    }

    public static Decoder getInstance() {
        if (instance == null) {
            instance = new Decoder();
        }
        return instance;
    }

    public String decode(String encodedText) {
        ReferenceTable referenceTable = ReferenceTable.getInstance();
        char offsetCharacter = encodedText.charAt(0);
        int offsetValue = referenceTable.getIndex(offsetCharacter);
        StringBuilder decodedText = new StringBuilder();
        int encodedTextLength = encodedText.length();

        for (int i = 1; i < encodedTextLength; i++) {
            char character = encodedText.charAt(i);
            if (character == ' ') {
                decodedText.append(' ');
                continue;
            }

            int curIndex = referenceTable.getIndex(character);
            int decodedIndex = (curIndex + offsetValue) % referenceTable.getTotalCharacters();
            Character decodedChar = referenceTable.getCharacter(decodedIndex);
            if (decodedChar == null) {
                throw new IllegalArgumentException("Invalid character in encoded text");
            }
            decodedText.append(decodedChar);
        }
        return decodedText.toString();
    }

}
