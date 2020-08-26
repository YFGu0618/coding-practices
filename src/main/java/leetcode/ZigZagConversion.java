package leetcode;

/**
 * LeetCode Solution No.0006.
 *
 * @see <a href="ZigZagConversion">https://leetcode.com/problems/zigzag-conversion </a>
 * @author Yifan Gu
 */
public class ZigZagConversion {
  public static String convert(String s, int numRows) {
    if (s.length() <= numRows || numRows == 1) {
      return s;
    }
    StringBuilder[] converted = new StringBuilder[numRows];
    for (int i = 0; i < numRows; i++) {
      converted[i] = new StringBuilder();
    }
    CycleIdx c = new CycleIdx(numRows - 1);
    for (int i = 0; i < s.length(); i++) {
      converted[c.next()].append(s.charAt(i));
    }
    for (int i = 1; i < converted.length; i++) {
      converted[0].append(converted[i].toString());
    }
    return converted[0].toString();
  }

  static class CycleIdx {
    private int max;
    private int idx;
    private int inc;

    public CycleIdx(int max) {
      this.max = max;
      this.idx = -1;
      this.inc = 1;
    }

    public int next() {
      idx += inc;
      if (idx == 0) {
        inc = 1;
      } else if (idx == max) {
        inc = -1;
      } else if (idx > max) {
        idx = max;
        inc = -1;
      } else if (idx < 0) {
        idx = 0;
        inc = 1;
      }
      return idx;
    }
  }
}
