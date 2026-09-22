package encryptorV2.dataIntegrator.characterCodec;

import java.io.File;

import encryptorV2.dataIntegrator.SaveManager;

class CharacterCodec {
    private String characterCodec;

    /**
     * Constructs a CharacterCodec with the specified character codec.
     *
     * @param characterCodec the character codec to set
     */
    public CharacterCodec(String characterCodec) {
        this.characterCodec = characterCodec;
    }

    /**
     * Retrieves the character codec.
     *
     * @return the character codec
     */
    public String getCharacterCodec() {
        return characterCodec;
    }

    /**
     * Sets the character codec.
     *
     * @param characterCodec the new character codec to set
     */
    public void setCharacterCodec(String characterCodec) {
        this.characterCodec = characterCodec;
    }
}

class CharacterCodecRepository {

    private static final String PATH = "src/main/java/encryptorV2/data/characterCodec.json";

    /**
     * Loads the CharacterCodec from the specified path.
     *
     * @return the loaded CharacterCodec
     * @throws RuntimeException if no CharacterCodec is found at the specified path
     */
    public CharacterCodec loadCharacterCodec() {
        CharacterCodec characterCodec = SaveManager.load(PATH, CharacterCodec.class);
        if (characterCodec == null) {
            throw new RuntimeException("No CharacterCodec found at path: " + PATH);
        }
        return characterCodec;
    }

    /**
     * Saves the given CharacterCodec to the specified path.
     *
     * @param characterCodec the CharacterCodec to save
     */
    public void saveCharacterCodec(CharacterCodec characterCodec) {
        SaveManager.save(PATH, characterCodec);
    }

}

public class CharacterCodecService {

    private final CharacterCodecRepository repository;
    private final CharacterCodec characterCodec;

    public CharacterCodecService() {
        this.repository = new CharacterCodecRepository();
        this.characterCodec = repository.loadCharacterCodec();
    }

    /**
     * Retrieves the current character codec.
     *
     * @return the current character codec
     */
    public String getCharacterCodec() {
        return characterCodec.getCharacterCodec();
    }

    /**
     * Sets a new character codec and saves it to the repository.
     *
     * @param characterCodec the new character codec to set
     */
    public void setCharacterCodec(String characterCodec) {
        this.characterCodec.setCharacterCodec(characterCodec);
        repository.saveCharacterCodec(this.characterCodec);
    }

}
