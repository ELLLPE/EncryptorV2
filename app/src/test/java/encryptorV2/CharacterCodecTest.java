package encryptorV2;

import org.junit.jupiter.api.Test;

import encryptorV2.dataIntegrator.characterCodec.*;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterCodecTest {

    @Test
    public void testCharacterCodecService() {
        CharacterCodecService characterCodecService = new CharacterCodecService();

        // Test getting the character codec
        String characterCodec = characterCodecService.getCharacterCodec();
        assertNotNull(characterCodec, "Character codec should not be null");

        // Test setting a new character codec
        String newCharacterCodec = "newCodec";
        characterCodecService.setCharacterCodec(newCharacterCodec);
        String updatedCharacterCodec = characterCodecService.getCharacterCodec();
        assertEquals(newCharacterCodec, updatedCharacterCodec, "Character codec should be updated");
    }
}
