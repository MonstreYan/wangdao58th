package com.cskaoyan._19collection._01ds;

/**
 * 链表的工具类。
 * 1.根据一个数组，初始化一个链表出来。
 * 2.将链表，转换为一个字符串，返回。（打印）
 *
 * @author Common-zhou
 * @since 2024-03-28 16:21
 */
public class NodeUtil {
    public static <T> Node<T> initNode(T[] data) {

        Node<T> headNode = new Node<>();
        Node<T> tailNode = headNode;

        for (T element : data) {
            Node<T> tmpNode = new Node<>(element);
            tailNode.next = tmpNode;
            tailNode = tmpNode;
        }

        return headNode.next;
    }

    public static void printNode(Node<?> headNode) {
        // ?
        if (headNode == null) {
            System.out.println("链表为空");
            return;
        }

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


}
