package encryptorV2.dataConverter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Permutes the chunks of the plaintext based on the provided key.
     * @param plaintext
     * @param key
     * @return
     */
    public String runKeyedChunkPermuter(String plaintext, long key) {

        int pLength = plaintext.length();

        long pRand = secureRandom(pLength);
        long kRand = secureRandom(key);

        List<String> chunks = new ArrayList<>();
        for (int i = pLength; i > 0; i--) {
            System.out.println("i: " + i);

            int chunkSize = 0;

            if (i == pLength) {
                chunkSize = Math.abs(Math.min((int) (pRand % (i)), (int) (kRand % (i)))) % (i - 1);
            } else {
                chunkSize = Math.abs(Math.min((int) (pRand % (i)), (int) (kRand % (i))));
            }

            chunks.add(plaintext.substring(pLength - i, (pLength - i) + chunkSize + 1));
            i -= chunkSize;
        }
        
        for (String chunk : chunks) {
            System.out.println("chunk: " + chunk);
        }

        System.out.println("chunks.size(): " + chunks.size());

        StringBuilder chunkedText = new StringBuilder();
        int i = 0;
        while (chunks.size() > 0) {
            i++;
            int chunkToAppendIndex = Math.abs((int) (secureRandom(Math.max(pRand, kRand) + i))) % chunks.size();
            chunkedText.append(chunks.get(chunkToAppendIndex));
            chunks.remove(chunkToAppendIndex);
        }

        return chunkedText.toString();
    }

}
