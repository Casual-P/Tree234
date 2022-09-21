package com.example.tree234;

public class Tree234 {
    private Node root;
    public Tree234() {
        this.root = new Node();
    }

    public void insert(Data newData) {
        Node current = root;
        while (true) {
            if (current.isFull()) {
                split(current);
                current = current.getParent();
            } else if (current.isLeaf()) {
                break;
            }else
                current = getNextChild(current, newData.getId());
        }
        current.insertItem(newData);
    }

    public Data find(int key) {
        Node node = findNode(key);
        if (node != null) {
            Data data = node.findData(key);
            System.out.println("Found value: " + data.getId());
            return data;
        }
        System.out.println("Can't found value");
        return null;
    }

    private Node findNode(int key) {
        Node current = root;
        while (current != null) {
            int value = current.find(key);
            if (value == -1) {
                current = getNextChild(current, key);
            } else {
                return current;
            }
        }
        return null;
    }

    private void split(Node current) // Разбиение узла
    {
        Node child2, child3, parent;
        Data dataB, dataC;

        dataC = current.removeData();
        dataB = current.removeData();
        child3 = current.disconnectChild(3);
        child2 = current.disconnectChild(2);

        if (current == root) {
            root = new Node();
            parent = root;
            root.connectChild(0, current);
        } else {
            parent = current.getParent();
        }

        int itemIndex = parent.insertItem(dataB);
        int numElems = parent.getNumElems();
        for (int i = numElems - 1; i > itemIndex; i--) {
            Node temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }

        Node newRight = new Node();
        parent.connectChild(itemIndex + 1, newRight);
        newRight.insertItem(dataC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    public void disp() {
        recDisp(root);
        System.out.println();
    }

    private void recDisp(Node current) {
        if (current != null) {
            int count = 0;
            int numElem = current.getNumElems();
            for (int i = 0; i < numElem + 1; i++) {
                Node next = current.getChild(i);
                recDisp(next);
                if (count == 0) {
                    current.dispNode();
                    count++;
                }
            }
        }
    }


    private Node getNextChild(Node current, int key) {
        int i;
        for (i = 0; i < current.getNumElems(); i++) {
            if (key < current.getData(i).getId()) {
                return current.getChild(i);
            }
        }
        return current.getChild(i);
    }
}
