class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        boolean allEvenPossible = true;
        for (int i = 0; i < n; i++) {
            boolean canBeEven = false;
            if (nums1[i] % 2 == 0) canBeEven = true;
            if (!canBeEven) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        int diff = nums1[i] - nums1[j];
                        if (diff % 2 == 0) {
                            canBeEven = true;
                            break;
                        }
                    }
                }
            }
            if (!canBeEven) {
                allEvenPossible = false;
                break;
            }
        }
        if (allEvenPossible) return true;
        boolean allOddPossible = true;
        for (int i = 0; i < n; i++) {
            boolean canBeOdd = false;
            if (nums1[i] % 2 != 0) canBeOdd = true;
            if (!canBeOdd) {
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        int diff = nums1[i] - nums1[j];
                        if (diff % 2 != 0) {
                            canBeOdd = true;
                            break;
                        }
                    }
                }
            }
            if (!canBeOdd) {
                allOddPossible = false;
                break;
            }
        }
        return allOddPossible;
    }
}