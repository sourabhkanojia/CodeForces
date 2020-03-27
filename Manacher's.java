// Manacher's Algorithm
static int[] L;
    static void manacher(String text){
        int N = text.length();
        if (N == 0)
            return;
        N = 2 * N + 1; // Position count
        L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int diff = -1;

        for (i = 2; i < N; i++) {
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);

            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                    (((i + L[i] + 1) % 2 == 0) ||
                            (text.charAt((i + L[i] + 1) / 2) ==
                                    text.charAt((i - L[i] - 1) / 2)))) { L[i]++; }

            if (L[i] > maxLPSLength) {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }

            if (i + L[i] > R) {
                C = i;
                R = i + L[i];
            }
        }
    }
 /* If you find even length at some index i then
    i=i-1;
    i=i-2;
    i=Math.ceil(i/2.0);
    then i and i+1 will be your center.
    
    If you find odd length at some index i then
    i=i-2;
    i=Math.ceil(i/2.0);
    then i will be your center.
  */
