package classic;

import java.util.Set;

class Dfs {
  class Node {
    int id = 0;
    Set<Node> adjacents;
  }

  void search(Node root, boolean[] visited) {
    if (root == null) {
      return;
    }
    visited[root.id] = true;
    for (Node n : root.adjacents) {
      if (!visited[n.id]) {
        search(n, visited);
      }
    }
  }

  void visit(Node root) {}
}
