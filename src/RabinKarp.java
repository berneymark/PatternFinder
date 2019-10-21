public class RabinKarp {
    private static RabinKarp instance = new RabinKarp();
    private final static int D = 256;

    private RabinKarp() {}

    public void search(String input, String pattern, int prime) {
        int inputLength = input.length();
        int patternLength = pattern.length();
        int inputHash = 0;
        int patternHash = 0;
        int h = 1;
        int j = 0;

        for (int i = 0; i < patternLength - 1; i++)
            h = (h * D) % prime;

        /**
         * Calculates hash value of pattern and text.
        **/
        for (int i = 0; i < patternLength; i++) {
            inputHash = (inputHash * D + input.charAt(i)) % prime;
            patternHash = (patternHash * D + pattern.charAt(i)) % prime;
        }

        /**
         * Slides pattern over text one by one.
        **/
        for (int i = 0; i <= (inputLength - patternLength); i++) {
            /**
             * Check the hash values of current window of text and pattern. If
             * the hash values match then only check for characters on by one.
            **/
            if (patternHash == inputHash) {
                /* Check for characters one by one. */
                for (j = 0; j < patternLength; j++) {
                    if (input.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if (j == patternLength)
                    System.out.println("Pattern found at index " + i);
            }

            if (i < inputLength - patternLength) {
                inputHash = (D * (inputHash - input.charAt(i) * h) +
                            input.charAt(i + patternLength)) % prime;
                if (inputHash < 0)
                    inputHash += prime;
            }
        }
    }

    public static RabinKarp getInstance() {
        return instance;
    }
}
