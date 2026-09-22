package encryptorV2.dataConverter;

import encryptorV2.dataIntegrator.characterCodec.CharacterCodecService;

public class CharConverter {

    private static CharacterCodecService ccs = new CharacterCodecService();
    private static String cc = ccs.getCharacterCodec();

    public static int convertToInt(char c) {

        int integer = cc.indexOf(c);

        return integer;
    }

    public static int[] convertToInt(char[] chars) {

        int[] integers = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            integers[i] = convertToInt(chars[i]);
        }

        return integers;
    }

}
