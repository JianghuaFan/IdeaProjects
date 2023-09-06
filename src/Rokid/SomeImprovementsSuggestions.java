package Rokid;

public class SomeImprovementsSuggestions {
    public enum AeCompMode {
        GLOBAL(0),
        LOWER_TRIANGLE(1),
        CENTER(2);

        private final int value;

        AeCompMode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        AeCompMode aeCompMode = AeCompMode.GLOBAL; // Set the initial value
    }
}
