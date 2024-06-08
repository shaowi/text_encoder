class Main {
    public static void main(String[] args) {
        Encoder encoder = Encoder.getInstance();
        Decoder decoder = Decoder.getInstance();

        String input = "HELLO WORLD";

        String encodedText = encoder.encode(input);
        System.out.println(encodedText);

        String decodedText = decoder.decode(encodedText);
        System.out.println(decodedText);

    }
}
