package encryptorV2.dataIntegrator.characterCodec;

import encryptorV2.dataIntegrator.SaveManager;

class CharacterCodecRepository {

    private static final String PATH = "java/encryptorV2/data/characterCodec.json";

    public CharacterCodec loadCharacterCodec() {
        CharacterCodec characterCodec = SaveManager.load(PATH, CharacterCodec.class);
        if (characterCodec == null) {
            throw new RuntimeException("No CharacterCodec found at path: " + PATH);
        }
        return characterCodec;
    }

    public void saveCharacterCodec(CharacterCodec characterCodec) {
        SaveManager.save(PATH, characterCodec);
    }

}

public class CharacterCodecService {

    private final CharacterCodec characterCodec;

    public CharacterCodecService() {
        this.characterCodec = new CharacterCodecRepository().loadCharacterCodec();
    }

    public String getCharacterCodec() {
        return characterCodec.getCharacterCodec();
    }

    public void setCharacterCodec(String characterCodec) {
        this.characterCodec.setCharacterCodec(characterCodec);
        new CharacterCodecRepository().saveCharacterCodec(this.characterCodec);
    }

}
