public class RabinKarp {
    private final static int d = 256;

    public void Search(String input, String pattern, int prime) {
        int inputLength = input.length();
        int patternLength = pattern.length();
        int inputHash = 0;
        int patternHash = 0;
        int h = 1;

        for (int i = 0; i < patternLength - 1; i++)
            h = (h * d) % prime;

        for (int i = 0; i < patternLength; i++) {
            inputHash = (inputHash * d + input.charAt(i)) % prime;
            patternHash = (patternHash * d + pattern.charAt(i)) % prime;
        }

        for (int i = 0; i <= (inputLength - patternLength); i++) {
            if (patternHash == inputHash) {
                for (int j = 0; j < patternLength - 1; j++) {
                    if (input.charAt(i + j) != pattern.charAt(j))
                        break;

                    if (j == patternLength)
                        System.out.println("Pattern found at index " + i);
                }
            }

            if (i < inputLength - patternLength) {
                inputHash = (d * (inputHash - input.charAt(i) * h) +
                            input.charAt(i + patternLength)) % prime;
                if (inputHash < 0)
                    inputHash += prime;
            }
        }
    }
}
