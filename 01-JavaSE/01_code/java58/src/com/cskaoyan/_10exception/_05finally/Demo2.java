package com.cskaoyan._10exception._05finally;

/**
 * @author Common-zhou
 * @since 2024-03-19 15:02
 */
public class Demo2 {
    public static void main(String[] args) {

        // - try代码块如果有return
        //   - 程序会先执行完finally代码块，回过头执行try中的return
        // - catch代码块中如果有return，并且catch正常捕获异常执行
        //   - 程序会先执行完finally代码块后，再回去执行catch中return，从catch代码块中结束方法
        // - finally代码中有return
        //   - 不会影响finally代码块执行
        // - 如果finally和catch中都有return
        //   - 程序会直接从finally代码块中的return结束方法
        // - 如果try中的异常不能正常捕获,但是finally中有return
        //   - 注意此时程序会跳过这个异常，不会抛出异常给JVM报错


        // 在finally里面，就做一件事。释放资源。 不要利用finally来做业务逻辑。
        // 也尽量不要用try-catch 来做业务功能。 这样，业务代码和异常代码会混在一起。 到时候一团麻。

        int num = test1();

        System.out.println("num = " + num);

    }

    private static int test1() {

        try {
            test2(1);
            System.out.println("test2 after");
            return 1;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return 10;
        } finally {
            System.out.println("finally");
        }

    }

    private static void test2(int num) {

        if (num == 0) {
            return;
        }

        if (num == 1) {
            throw new NullPointerException();
        } else if (num == 2) {
            throw new IllegalArgumentException();
        } else if (num == 3) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            throw new RuntimeException();
        }


    }
}
