package HW_0409;

class Node {
    int key;
    String value;
    Node left;
    Node right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Метод для поиска значения по ключу
    public String find(int key) {
        Node current = root;
        while (current != null) {
            if (key == current.key) {
                return current.value;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null; // Значение не найдено
    }

    // Метод для вставки значения с ключом
    public void insert(int key, String value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node root, int key, String value) {
        if (root == null) {
            root = new Node(key, value);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key, value);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key, value);
        }
        return root;
    }

    // Метод для удаления значения
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // Метод для вывода узла
    public void print(Node node) {
        if (node != null) {
            System.out.println("Key: " + node.key + ", Value: " + node.value);
            print(node.left);
            print(node.right);
        }
    }
}