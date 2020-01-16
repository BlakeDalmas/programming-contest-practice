/*
Blake Dalmas, Kaitlyn Kottlowski, Brooke Schoen

1.6.1 The 3n+1 Problem
PC/UVa IDs: 110101/100
*/

import java.util.*;

class threeNPlusOne {

    public static void main(String args[]) {
        threeNPlusOne problem = new threeNPlusOne();
        problem.begin();
    }

    // The 3n+1 Algorithm.
    // If n is even, divide by 2.
    // If n is odd, multiply by 3 and add 1.
    static int oddEvenAdd(int n) {
        if (n % 2 == 0) return (int)(n / 2);
        return (n * 3) + 1;
    }

    void begin() {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            int i = scan.nextInt(); // lower range
            int j = scan.nextInt(); // upper range
            int maximumCycleLength = -1; // max cycles (result)

            for (int n = i; n <= j; n++) {
                int currentN = n; // Changing n would mess up the loop so this is copied.
                int currentCycleLength = 1; // Current cycles. (Assumes original n counts so starts at 1.)

                // n = 1 terminating condition
                while (currentN > 1) {
                    currentN = oddEvenAdd(currentN);
                    currentCycleLength++;
                }

                // Update max if current cycle length is larger.
                if (maximumCycleLength == -1 || currentCycleLength > maximumCycleLength) {
                    maximumCycleLength = currentCycleLength;
                }
            }

            System.out.println(i + " " + j + " " + maximumCycleLength);
        }
    }
}
