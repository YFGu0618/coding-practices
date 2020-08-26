package classic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Bfs {
  class Node {
    int id = 0;
    Set<Node> adjacents;
  }

  void search(Node root, boolean[] visited) {
    List<Node> queue = new ArrayList<>();
    visited[root.id] = true;
    queue.add(root);
    while (!queue.isEmpty()) {
      Node n = queue.remove(0);
      visit(n);
      for (Node a : n.adjacents) {
        if (!visited[a.id]) {
          visited[a.id] = true;
          queue.add(a);
        }
      }
    }
  }

  void visit(Node root) {}
}
