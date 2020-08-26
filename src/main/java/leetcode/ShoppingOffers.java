package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode Solution No.0638.
 *
 * @see <a href="ShoppingOffers">https://leetcode.com/problems/shopping-offers </a>
 * @author Yifan Gu
 */
public class ShoppingOffers {
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    return shopping(price, special, needs, 0);
  }

  private int shopping(
      List<Integer> price, List<List<Integer>> special, List<Integer> needs, int noOffer) {
    int minCost = regularCost(price, needs);
    for (int i = noOffer; i < special.size(); i++) {
      List<Integer> offer = special.get(i);
      List<Integer> tmpNeeds = new ArrayList<>();
      for (int j = 0; j < needs.size(); j++) {
        if (needs.get(j) < offer.get(j)) {
          tmpNeeds = null;
          break;
        }
        tmpNeeds.add(needs.get(j) - offer.get(j));
      }
      if (tmpNeeds != null) {
        minCost =
            Math.min(minCost, offer.get(offer.size() - 1) + shopping(price, special, tmpNeeds, i));
      }
    }
    return minCost;
  }

  private int regularCost(List<Integer> price, List<Integer> needs) {
    int cost = 0;
    for (int i = 0; i < price.size(); i++) {
      cost += price.get(i) * needs.get(i);
    }
    return cost;
  }
}
