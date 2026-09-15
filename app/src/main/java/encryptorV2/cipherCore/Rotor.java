package encryptorV2.cipherCore;

public class Rotor {

    private final int[] foward; // wiring
    private final int[] backward; // inverse wiring
    private int position; // current offset
    private int size; // size of the rotor

    /**
     * Constructs a Rotor with the specified wiring.
     * 
     * @param wiring The wiring for the rotor.
     */
    public Rotor(int[] wiring) {
        this.foward = wiring.clone();
        this.backward = invert(wiring);
        this.position = 0;
        this.size = wiring.length;
    }

    /**
     * Encodes an input signal through the forward wiring of the rotor.
     * 
     * @param input The input signal.
     * @return The encoded signal.
     */
    public int encodeFoward(int input) {
        int shifted = (input + position) % size;
        int whired = foward[shifted];
        return (whired - position + size) % size;
    }

    /**
     * Encodes an input signal through the backward wiring of the rotor.
     * 
     * @param input The input signal.
     * @return The encoded signal.
     */
    public int encodeBackward(int input) {
        int shifted = (input + position) % size;
        int whired = backward[shifted];
        return (whired - position + size) % size;
    }

    public void step(int amount) {
        position = (position + amount) % size;
    }

    /**
     * Inverts the wiring of the rotor.
     * 
     * @param wiring The original wiring.
     * @return The inverted wiring.
     */
    private int[] invert(int[] wiring) {
        int[] inverse = new int[wiring.length];
        for (int i = 0; i < wiring.length; i++) {
            inverse[wiring[i]] = i;
        }
        return inverse;
    }

}
