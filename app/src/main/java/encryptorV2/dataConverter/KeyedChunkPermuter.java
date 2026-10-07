package encryptorV2.dataConverter;

import java.security.SecureRandom;

public class KeyedChunkPermuter {

    /**
     * Generates a secure random long value based on the provided key.
     * 
     * @param key
     * @return
     */
    private long secureRandom(long key) {
        SecureRandom random = new SecureRandom();
        random.setSeed(key);
        return random.nextLong();
    }

    public String KeyedChunkPermuter(String plaintext, long key) {

        int pLength = plaintext.length();

        long pRand = secureRandom(pLength);
        long kRand = secureRandom(key);

        int chunkSize = Math.max((int) (pRand % pLength), (int) (kRand % pLength));

        int numChunks = (int) Math.ceil((double) pLength / chunkSize);

        return plaintext;
    }

}
