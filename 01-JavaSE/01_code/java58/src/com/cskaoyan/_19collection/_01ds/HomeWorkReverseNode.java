package com.cskaoyan._19collection._01ds;

/**
 * 反转链表
 *
 * @author Common-zhou
 * @since 2024-03-29 09:44
 */
public class HomeWorkReverseNode {


    public static void main(String[] args) {
        Node<String> headNode = NodeUtil.initNode(new String[]{"a", "b", "c", "d", "e", "f"});


        Node<String> newHeadNode = reverseNode(headNode);


        NodeUtil.printNode(newHeadNode);
    }

    private static Node<String> reverseNode(Node<String> headNode) {

        // 头插法： 每次从头插入。
        Node<String> dummpNode = new Node<>();


        while (true) {

            if (headNode == null) {
                break;
            }

            Node<String> tmpNode = headNode.next;

            headNode.next = dummpNode.next;
            dummpNode.next = headNode;

            headNode = tmpNode;
        }
        return dummpNode.next;


    }

}
