package union.find;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet<T> {
    class Node {
        T data;
        Node parent;
        int rank;

        Node(T data) {
            this.data = data;
            this.parent = this;
            this.rank = 0;
        }
    }

    private Map<T, Node> map = new HashMap<>();

    public void makeSet(T data) {
        Node node = new Node(data);
        map.put(data, node);
    }

    public Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public T findSet(T data) {
        Node node = findSet(map.get(data));
        return node.data;
    }

    public void union(Node node1, Node node2) {
        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        if (parent1.data.equals(parent2.data)) {
            return;
        }

        if (parent1.rank == parent2.rank) {
            parent1.rank += 1;
            parent2.parent = parent1;
        } else if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }

    public void union(T data1, T data2) {
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);
        union(node1, node2);
    }
}
