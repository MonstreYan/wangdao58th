package com.cskaoyan._19collection._01ds;

/**
 * 是否有环
 *
 * @author Common-zhou
 * @since 2024-03-29 09:34
 */
public class HomeWorkHasCircle {
    public static void main(String[] args) {
        Node<String> headNode = NodeUtil.initNode(new String[]{"zs", "ls", "wu", "zl"});

        headNode.next.next.next.next = headNode.next;

        // headNode.next.next.next.next = null;

        boolean isCircle = hasCircle(headNode);

        System.out.println("isCircle = " + isCircle);
    }

    private static boolean hasCircle(Node<?> headNode) {
        Node<?> fastNode = headNode;
        Node<?> slowNode = headNode;


        while (true) {
            if (fastNode == null || fastNode.next == null) {
                // 走到末尾了，说明没有环。因为有环的话，不可能为null。
                return false;
            }

            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (fastNode == slowNode) {
                return true;
            }

        }

    }

}
