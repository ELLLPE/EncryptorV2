package encryptorV2;

import org.junit.jupiter.api.Test;

import encryptorV2.dataIntegrator.characterCodec.*;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterCodecTest {

    @Test
    public void testCharacterCodecService() {
        CharacterCodecService service = new CharacterCodecService();

        // Test getting the character codec
        String initialCodec = service.getCharacterCodec();
        assertNotNull(initialCodec, "Initial character codec should not be null");

        // Test setting a new character codec
        String newCodec = "newCharacterCodec";
        service.setCharacterCodec(newCodec);
        String updatedCodec = service.getCharacterCodec();
        assertEquals(newCodec, updatedCodec, "Updated character codec should match the new value");

    }

}
