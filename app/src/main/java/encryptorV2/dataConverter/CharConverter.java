package encryptorV2.dataConverter;

import encryptorV2.dataIntegrator.characterCodec.CharacterCodecService;

public class CharConverter {

    private static CharacterCodecService ccs = new CharacterCodecService();
    private static String cc = ccs.getCharacterCodec();

    /**
     * Converts a character to an integer using the character codec.
     *
     * @param c the character to convert
     * @return the corresponding integer from the character codec
     */
    public static int convertToInt(char c) {

        int integer = cc.indexOf(c);

        return integer;
    }

    /**
     * Converts an array of characters to an array of integers using the character
     * codec.
     *
     * @param chars the array of characters to convert
     * @return an array of integers corresponding to the input characters
     */
    public static int[] convertToInt(char[] chars) {

        int[] integers = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            integers[i] = convertToInt(chars[i]);
        }

        return integers;
    }

    /**
     * Converts an integer to a character using the character codec.
     *
     * @param i the integer to convert
     * @return the corresponding character from the character codec
     */
    public static char convertToChar(int i) {

        char character = cc.charAt(i);

        return character;
    }

    /**
     * Converts an array of integers to an array of characters using the character
     * codec.
     *
     * @param ints the array of integers to convert
     * @return an array of characters corresponding to the input integers
     */
    public static char[] convertToChar(int[] ints) {

        char[] characters = new char[ints.length];

        for (int i = 0; i < ints.length; i++) {
            characters[i] = convertToChar(ints[i]);
        }

        return characters;
    }

}
