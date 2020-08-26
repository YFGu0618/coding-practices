package classic;

public class Arithmetics {
  public static void main(String[] args) {
    // System.out.println(extEuclidGcd(25, 11)[2]);
    // System.out.println(lcm(25, 11));
    // System.out.println(primality(717197178));
    System.out.println(Long.MAX_VALUE);
  }

  // Greatest Common Divisor: Euclid
  public static int euclidGcd(int a, int b) {
    if (a < b) {
      return euclidGcd(b, a);
    } else if (b == 0) {
      return a;
    } else {
      return euclidGcd(b, a % b);
    }
  }

  // Greatest Common Divisor: Extended Euclid
  public static int[] extEuclidGcd(int a, int b) {
    if (a < b) {
      return extEuclidGcd(b, a);
    } else if (b == 0) {
      return new int[] {1, 0, a};
    } else {
      int[] res = extEuclidGcd(b, a % b);
      return new int[] {res[1], res[0] - (a / b) * res[1], res[2]};
    }
  }

  // Least Common Multiple
  public static int lcm(int a, int b) {
    return (a * b) / euclidGcd(a, b);
  }

  // Primality
  public static boolean Primality(int n) {
    return false;
  }
}
