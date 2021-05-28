package com.nong.algorithm;

/**
 * @ClassName: Node
 * @Description: 树节点
 * @author NongZhenQin
 * @date 2018-07-20 13:03:41
 */
public class Node {
    private Node leftChild;
    private Node rightChild;
    private Integer data;

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
