package com.nong.algorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NodeTest {

    public static void main(String[] args){
        NodeTest nodeTest = new NodeTest();
        Integer[] arr = new Integer[]{1,2,3,4,5,6,7,8,9,0};

        Node node = nodeTest.initBTree(arr);

        nodeTest.trivalBinTree(node);

        nodeTest.preTrival(node);
        System.out.println();
        nodeTest.midTrival(node);
        System.out.println();
        nodeTest.afterTrival(node);
    }

    /**
     * @ClassName: NodeTest
     * @Description: 将一个数字转换为完全二叉树
     * @author NongZhenQin
     * @date 2018-07-20 15:57:09
     */
    public Node initBTree(Integer[] arr){
        if(arr == null || arr.length == 0){
            return null;
        }

        if(arr.length == 1){
            Node node = new Node();
            node.setData(arr[0]);
            return node;
        }

        List<Node> nodeList = new ArrayList<>();
        for(Integer a : arr){
            Node node = new Node();
            node.setData(a);
            nodeList.add(node);
        }

        int temp = 0;
        // 注意这里，数组的下标是从零开始的
        while (temp <= (arr.length - 2) / 2){
            if(2 * temp + 1 < arr.length){
                nodeList.get(temp).setLeftChild(nodeList.get(2 * temp + 1));
            }

            if(2 * temp + 2 < arr.length){
                nodeList.get(temp).setRightChild(nodeList.get(2 * temp + 2));
            }

            temp++;
        }

        return nodeList.get(0);
    }

    /**
     * @ClassName: NodeTest
     * @Description: 层序遍历二叉树，，并分层打印
     * @author NongZhenQin
     * @date 2018-07-20 16:11:18
     */
    public void trivalBinTree(Node root) {
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);
        Node temp = null;
        // 记录当前层需要打印的节点的数量
        int currentLevel = 1;
        // 记录下一层需要打印的节点的数量
        int nextLevel = 0;
        
        while ((temp = nodeQueue.poll()) != null) {
            if (temp.getLeftChild() != null) {
                nodeQueue.add(temp.getLeftChild());
                nextLevel++;

            }
            if (temp.getRightChild() != null) {
                nodeQueue.add(temp.getRightChild());
                nextLevel++;
            }
            System.out.print(temp.getData() + " ");
            currentLevel--;
            if(currentLevel == 0) {
                System.out.println();
                currentLevel = nextLevel;
                nextLevel = 0;
            }
        }
    }

    /**
     * @ClassName: NodeTest
     * @Description: 先序遍历
     * @author NongZhenQin
     * @date 2018-07-20 16:04:15
     */
    public void preTrival(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.getData()+"|");

        preTrival(root.getLeftChild());
        preTrival(root.getRightChild());
    }

    /**
     * @ClassName: NodeTest
     * @Description: 中序遍历
     * @author NongZhenQin
     * @date 2018-07-20 16:13:56
     */
    public void midTrival(Node root){
        if(root == null){
            return;
        }

        midTrival(root.getLeftChild());
        System.out.print(root.getData()+"|");
        midTrival(root.getRightChild());
    }

    /**
     * @ClassName: NodeTest
     * @Description: 后序遍历
     * @author NongZhenQin
     * @date 2018-07-20 16:16:46
     */
    public void afterTrival(Node root){
        if(root == null){
            return;
        }

        midTrival(root.getLeftChild());
        midTrival(root.getRightChild());
        System.out.print(root.getData()+"|");
    }

}
