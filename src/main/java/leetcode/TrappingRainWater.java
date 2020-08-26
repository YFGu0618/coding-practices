package leetcode;

/**
 * LeetCode Solution No.0042.
 *
 * @see <a href="TrappingRainWater">https://leetcode.com/problems/trapping-rain-water </a>
 * @author Yifan Gu
 */
import java.util.Stack;

public class TrappingRainWater {
  public static int trap(int[] height) {
    // Stack for storing left side pointers
    Stack<Integer> ls = new Stack<>();
    int cap = 0;
    int i = 0;
    while (i < height.length) {
      if (ls.isEmpty() || height[i] <= height[ls.peek()]) {
        ls.push(i++);
      } else {
        int bottom = ls.pop();
        int bottomCap =
            (ls.isEmpty())
                ? 0
                : (Math.min(height[ls.peek()], height[i]) - height[bottom]) * (i - ls.peek() - 1);
        cap += bottomCap;
      }
    }
    return cap;
  }
}
