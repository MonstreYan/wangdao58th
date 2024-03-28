package com.cskaoyan._19collection._01ds;

import org.junit.Test;

/**
 * User链表。
 * 1.计算一下，有多少内蒙的同学。
 * 2.删除所有的河南的同学。
 * 整一个新节点。 如果不是河南的，就链上去。最终所有的河南的同学都被干掉了
 * 3.往长风老师前面，插入一个新学生。
 * <p>
 * Node<String>
 * <p>
 * 链表的插入数据流程: 先找到要插入数据的前一个位置。创建一个新的节点，将新节点的next指向 前一个位置的next。
 * 将前一个位置的next， 指向新建的节点。
 * 链表的删除数据流程
 * 链表的查找数据流程
 * <p>
 * 数组的插入流程： 从后，往前将数据依次挪动一格。 挪动到需要插入的位置，然后将新的数据插入。
 * 1 2 3 4 5 6
 * <p>
 *
 * 1.ArrayList  LinkedList有什么区别。
 * 2.数组和链表有什么区别。
 *
 * @author Common-zhou
 * @since 2024-03-28 16:40
 */
public class Demo3Linked {

    @Test
    public void test1() {
        // 创建一个链表。 里面有5个同学。

        // 1 常旭 18 内蒙古
        // 2 陈健 17 安徽
        // 3 丹丹 15 广西
        // 4 王鑫 15 内蒙古
        // 5 娅骊 15 贵州

        // User[] users = new User[]{new User(1, "常旭", 18, "内蒙古"), new User(1, "常旭", 18, "内蒙古"), new User(1, "常旭", 18, "内蒙古"), new User(1, "常旭", 18, "内蒙古"), new User(1, "常旭", 18, "内蒙古")};
        User[] users = new User[5];
        users[0] = new User(1, "常旭", 18, "内蒙古");
        users[1] = new User(2, "陈健", 18, "安徽");
        users[2] = new User(3, "丹丹", 15, "广西");
        users[3] = new User(4, "王鑫", 15, "内蒙古");
        users[4] = new User(5, "娅骊", 15, "贵州");
        Node<User> headNode = NodeUtil.initNode(users);

        NodeUtil.printNode(headNode);

        // 插入数据。 想往陈健同学的前面，插入  景天。

        Node<User> preNode = null;
        Node<User> currentNode = headNode;

        // 1.先找到陈健同学的前一个。
        while (currentNode != null && currentNode.next != null) {
            // Condition '"陈健".equals(currentNode.next.data)' is always 'false'
            if ("陈健".equals(currentNode.next.data.name)) {
                preNode = currentNode;
                break;
            }
        }

        System.out.println(preNode.data);

        Node<User> newNode = new Node<>();
        newNode.data = new User(6, "景天叔叔", 35, "hunan");

        newNode.next = preNode.next;
        preNode.next = newNode;

        NodeUtil.printNode(headNode);
    }


    @Test
    public void test2Delete() {
        // 创建一个链表。 里面有5个同学。

        User[] users = new User[7];
        users[0] = new User(1, "常旭", 18, "内蒙古");
        users[1] = new User(2, "陈健", 18, "安徽");
        users[2] = new User(3, "长风", 18, "河南");
        users[3] = new User(4, "王鑫", 15, "内蒙古");
        users[4] = new User(5, "娅骊", 15, "贵州");
        users[5] = new User(6, "丹丹", 15, "广西");
        users[6] = new User(7, "景天", 20, "河南");
        Node<User> headNode = NodeUtil.initNode(users);

        NodeUtil.printNode(headNode);

        // 删除一个叫 长风。

        if ("长风".equals(headNode.data.name)) {
            headNode = headNode.next;
            NodeUtil.printNode(headNode);
            return;
        }


        // 找到 长风 的前一个学生。
        Node<User> preNode = findPreNodeByUserName(headNode, "长风");

        if (preNode == null) {
            return;
        }
        preNode.next = preNode.next.next;

        NodeUtil.printNode(headNode);

    }


    @Test
    public void test2Delete2() {

        User[] users = new User[7];
        users[0] = new User(1, "常旭", 18, "内蒙古");
        users[1] = new User(2, "陈健", 18, "安徽");
        users[2] = new User(3, "长风", 18, "河南");
        users[3] = new User(4, "王鑫", 15, "内蒙古");
        users[4] = new User(5, "娅骊", 15, "贵州");
        users[5] = new User(6, "丹丹", 15, "广西");
        users[6] = new User(7, "景天", 20, "河南");
        Node<User> headNode = NodeUtil.initNode(users);

        NodeUtil.printNode(headNode);

        if ("常旭".equals(headNode.data.name)) {
            headNode = headNode.next;
            NodeUtil.printNode(headNode);
            return;
        }

        Node<User> preNode = findPreNodeByUserName(headNode, "常旭");

        if (preNode == null) {
            return;
        }
        preNode.next = preNode.next.next;

        NodeUtil.printNode(headNode);

    }

    private Node<User> findPreNodeByUserName(Node<User> headNode, String name) {

        Node<User> currentNode = headNode;

        while (currentNode != null && currentNode.next != null) {
            if (name.equals(currentNode.next.data.name)) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

}

class User {
    int id;
    String name;
    int age;
    String address;

    public User(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + '}';
    }
}
