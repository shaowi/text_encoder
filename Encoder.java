public class Encoder {
    private static Encoder instance;
    private char offsetCharacter = 'B'; // Character to offset the encoded text(must exist as one of the key character
                                        // in the reference table)

    private Encoder() {
    }

    public static Encoder getInstance() {
        if (instance == null) {
            instance = new Encoder();
        }
        return instance;
    }

    private int wrapIndex(int index, int totalCharacters) {
        return ((index % totalCharacters) + totalCharacters) % totalCharacters;
    }

    public String encode(String plainText) {
        ReferenceTable referenceTable = ReferenceTable.getInstance();
        int offsetValue = referenceTable.getIndex(offsetCharacter);
        StringBuilder encodedText = new StringBuilder();
        int plainTextLength = plainText.length();

        // Add the offset character to the front of the encoded text
        encodedText.append(offsetCharacter);

        for (int i = 0; i < plainTextLength; i++) {
            char character = plainText.charAt(i);
            if (character == ' ') {
                encodedText.append(' ');
                continue;
            }

            int curIndex = referenceTable.getIndex(character);
            int encodedIndex = wrapIndex(curIndex - offsetValue, referenceTable.getTotalCharacters());
            Character encodedChar = referenceTable.getCharacter(encodedIndex);
            if (encodedChar == null) {
                throw new IllegalArgumentException("Invalid character in plain text");
            }
            encodedText.append(encodedChar);
        }
        return encodedText.toString();
    }
}
