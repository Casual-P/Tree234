package com.example.tree234;

public class Node {
    private static final int ORDER = 4;
    private final Node[] childArray = new Node[ORDER];
    private final Data[] dataArray = new Data[ORDER - 1];
    private Node parent;
    private int numElems = 0;


    public void dispNode() {
        for (Data data : dataArray) {
            if (data != null)
                data.dispData();
        }
    }

    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null)
            child.setParent(this);
    }

    public Node disconnectChild(int childNum) {
        Node temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

    public Data removeData() {
        Data temp = dataArray[numElems - 1];
        dataArray[numElems - 1] = null;
        numElems--;
        return temp;
    }

    public int getNumElems() {
        return numElems;
    }

    public void setNumElems(int numElems) {
        this.numElems = numElems;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isFull() {
        return (numElems == (ORDER - 1));
    }

    public boolean isLeaf() {
        return childArray[0] == null;
    }

    public Data getData(int index) {
        return dataArray[index];
    }

    public int insertItem(Data newData) {
        int newId = newData.getId();
        numElems++;
        for (int i = ORDER - 2; i >= 0; i--) {
            if (dataArray[i] != null) {
                if (newId < dataArray[i].getId())
                    dataArray[i + 1] = dataArray[i];
                else {
                    dataArray[i + 1] = newData;
                    return i + 1;
                }
            }
        }
        dataArray[0] = newData;
        return 0;
    }

    public void deleteItem(int key) {
        for (int i = 0; i < dataArray.length; i++) {
            if (dataArray[i] != null)
                if(dataArray[i].getId() == key)
                    dataArray[i] = null;
        }
    }

    public int find(int key) {
        for (Data data : dataArray) {
            if (data != null)
                if (data.getId() == key)
                    return data.getId();
        }
        return -1;
    }

    public Data findData(int key) {
        for (Data data : dataArray) {
            if (data != null)
                if (data.getId() == key)
                    return data;
        }
        return null;
    }
}
