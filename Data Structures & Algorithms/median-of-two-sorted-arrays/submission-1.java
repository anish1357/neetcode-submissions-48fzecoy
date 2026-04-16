class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Let A be the smaller array (we will binary search on A)
        int[] A = nums1;
        int[] B = nums2;

        // Ensure A is always the smaller array to keep binary search efficient
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        // Total number of elements across both arrays
        int total = A.length + B.length;

        // Number of elements that should be in the left partition
        // (+1 handles odd length so left side gets the extra element)
        int half = (total + 1) / 2;

        // Binary search boundaries on array A
        int l = 0, r = A.length;

        while (l <= r) {

            // Partition index for A (midpoint of current search range)
            int i = l + (r - l) / 2;

            // Partition index for B such that left partition size = half
            int j = half - i;

            // Elements just left of partition in A
            // If partition is at start, treat as -infinity
            int Aleft = (i > 0) ? A[i - 1] : Integer.MIN_VALUE;

            // Elements just right of partition in A
            // If partition is at end, treat as +infinity
            int Aright = (i < A.length) ? A[i] : Integer.MAX_VALUE;

            // Elements just left of partition in B
            int Bleft = (j > 0) ? B[j - 1] : Integer.MIN_VALUE;

            // Elements just right of partition in B
            int Bright = (j < B.length) ? B[j] : Integer.MAX_VALUE;

            // Check if we found correct partition:
            // All elements in left partitions <= all in right partitions
            if (Aleft <= Bright && Bleft <= Aright) {

                // If total length is odd → median is max of left side
                if (total % 2 == 1) {
                    return Math.max(Aleft, Bleft);
                }

                // If even → median is average of middle two values
                return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
            }

            // If A's left element is too big,
            // move partition in A to the left
            else if (Aleft > Bright) {
                r = i - 1;
            }

            // Otherwise, move partition in A to the right
            else {
                l = i + 1;
            }
        }

        // This case should never occur for valid sorted inputs
        throw new IllegalArgumentException("Input arrays are not sorted properly");
    }
}