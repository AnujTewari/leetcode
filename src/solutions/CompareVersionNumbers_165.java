package solutions;

/**
 * https://leetcode.com/problems/compare-version-numbers/
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise
 * return 0.
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character.
 * The . character does not represent a decimal point and is used to separat
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 */
public class CompareVersionNumbers_165 {
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0;
        while (i < nums1.length || i < nums2.length) {
            int n1 = 0, n2 = 0;
            if (i < nums1.length) {
                n1 = Integer.parseInt(nums1[i]);
            }
            if (i < nums2.length) {
                n2 = Integer.parseInt(nums2[i]);
            }
            if (n1 > n2) {
                return 1;
            } else if (n1 < n2) {
                return -1;
            }
            ++i;
        }
        return 0;
    }
}
