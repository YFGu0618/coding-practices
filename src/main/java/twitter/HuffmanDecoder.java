package twitter;

/**
 * Twitter OA 2018-2019: The Huffman Decoder
 *
 * @author Yifan Gu
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HuffmanDecoder {

  static String decode(String[] dict, String input) {
    if (input == null || input.length() < 1) {
      return "";
    }
    Map<String, String> codec = new HashMap<>();
    int minCodeLen = Integer.MAX_VALUE;
    for (String d : dict) {
      String[] parts = d.split("\\s+");
      if (parts[0].equals("newline")) {
        codec.put(parts[1], "\n");
      } else {
        codec.put(parts[1], parts[0]);
      }
      minCodeLen = Math.min(minCodeLen, parts[1].length());
    }
    StringBuilder sb = new StringBuilder();
    int left = 0;
    int right = 1;
    while (left < right && right < input.length()) {
      if (right - left + 1 < minCodeLen) {
        right++;
        continue;
      }
      String c = input.substring(left, right);
      if (codec.containsKey(c)) {
        sb.append(codec.get(c));
        left = right;
        right = left + 1;
      } else {
        right++;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) throws IOException {
    String[] dict = {
      "a 100100", "b 100101", "c 110001", "d 100000", "newline 1111111", "p 111110", "q 000001"
    };
    String input = "1111100000011001001111111100101110001100000";
    System.out.print(decode(dict, input));
  }
}
