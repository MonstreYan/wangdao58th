package com.cskaoyan._19collection._01ds;

import org.junit.Test;

/**
 * 链表的插入流程、删除流程、查找流程
 *
 * @author Common-zhou
 * @since 2024-03-28 15:57
 */
public class Demo2Linked {

    @Test
    public void test1Init() {
        // 茶百道、蜜雪冰城、茶颜悦色、霸王茶姬
        Node<String> firstNode = new Node<>();
        firstNode.data = "茶百道";

        Node<String> secondNode = new Node<>();
        secondNode.data = "蜜雪冰城";

        firstNode.next = secondNode;

        Node<String> thirdNode = new Node<>();
        thirdNode.data = "茶颜悦色";

        secondNode.next = thirdNode;

        Node<String> fourthNode = new Node<>();
        fourthNode.data = "霸王茶姬";

        thirdNode.next = fourthNode;
    }


    /**
     * 往蜜雪冰城后面，插入一个数据。  爷爷不泡茶
     */
    @Test
    public void test2Print() {
        Node<String> firstNode = new Node<>();
        firstNode.data = "茶百道";

        Node<String> secondNode = new Node<>();
        secondNode.data = "蜜雪冰城";

        firstNode.next = secondNode;

        Node<String> thirdNode = new Node<>();
        thirdNode.data = "茶颜悦色";

        secondNode.next = thirdNode;

        Node<String> fourthNode = new Node<>();
        fourthNode.data = "霸王茶姬";

        thirdNode.next = fourthNode;

        Node<String> newNode = new Node<>();
        newNode.data = "爷爷不泡茶";

        newNode.next = secondNode.next;
        secondNode.next = newNode;

        // 打印链表的方式？

        Node<String> headNode = firstNode;

        while (headNode != null) {
            System.out.print(headNode.data);

            if (headNode.next != null) {
                System.out.printf("--->");
            } else {
                System.out.println();
            }

            headNode = headNode.next;
        }
    }


    @Test
    public void test3() {
        // 抽成一个工具类。 我传入一个数组，根据这个数组，创建一个链表出来。

        // 茶百道、蜜雪冰城、茶颜悦色、霸王茶姬

        // Node<String>
    }


    @Test
    public void test4() {
        String[] strings = new String[]{"zs", "ls", "wu", "zl"};
        Node<String> headNode = NodeUtil.initNode(strings);

        System.out.println(headNode);

        NodeUtil.printNode(headNode);
    }




}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
