package util;

public class UnbalancedTreeMap {
    private int size;
    BinaryNode<OrderedKeyValue> root;
    public UnbalancedTreeMap() {
        size = 0;
        root = null;
    }
    public int get(String key) {
        BinaryNode<OrderedKeyValue> temp = root;
        while (temp != null) {
            int comp = temp.element.key.compareTo(key);
            if (comp == 0)
                return temp.element.value;
            if (comp > 0)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return 0;
    }

    public int put(String key, int value) {
        if (root == null) {
            root = new BinaryNode<OrderedKeyValue>(new OrderedKeyValue(key, value));
            size++;
            return 0;
        }
        BinaryNode<OrderedKeyValue> parent = null, child = root;
        do {
            int comp = child.element.key.compareTo(key);
            if (comp == 0) {
                int rv = child.element.value;
                child.element.value = value;
                return rv;
            }
            if (comp > 0) {
                parent = child;
                child = child.left;
            } else {
                parent = child;
                child = child.right;
            }
        } while (child != null);
        if (parent.element.key.compareTo(key) > 0)
            parent.left = new BinaryNode<OrderedKeyValue>(new OrderedKeyValue(key, value));
        else
            parent.right = new BinaryNode<OrderedKeyValue>(new OrderedKeyValue(key, value));
        size++;
        return 0;
    }

    public String[] keySet() {
        OrderedKeyValue[] keyvalues = inOrderList(root);
        String[] rv = new String[size];
        int i = 0;
        for (OrderedKeyValue kv : keyvalues)
            rv[i++] = kv.key;
        return rv;
    }

    private OrderedKeyValue[] inOrderList(BinaryNode<OrderedKeyValue> root) {
        if (root == null)// base case
            return new OrderedKeyValue[]{};
        OrderedKeyValue[] leftList = inOrderList(root.left);
        OrderedKeyValue[] rightList = inOrderList(root.right);
        OrderedKeyValue[] rv = new OrderedKeyValue[1 + leftList.length + rightList.length];
        for (int i = 0; i < rv.length; i++)
            if (i < leftList.length)
                rv[i] = leftList[i];
            else if (i > leftList.length)
                rv[i] = rightList[i - leftList.length - 1];
            else
                rv[i] = root.element;
        return rv;
    }
}
