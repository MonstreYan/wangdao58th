package com.cskaoyan._13thread._15homework;

import java.io.*;
import java.text.DecimalFormat;

/**
 * 使用多线程实现方式一来实现多个文件一起复制功能(3个线程复制3个文件)，并在控制台显示复制的进度，进度以百分比表示
 * 例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，
 * “XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！”
 * 注: 为了更好的显示百分比推荐使用字节流进行复制操作
 * 提示: 进度可以用当前已循环读写的字节和除以文件大小字节
 * <p>
 * 接到需求： 好好理解。 南辕北辙。
 * <p>
 * 在公司里面，理解需求是一门技术活。
 * 一定要弄懂了需求再开始。不要瞎开始。
 * <p>
 * 腾讯会议：
 * 产品。 需求A。按照方式1来实现。   再会的人： 我、后端leader在、产品、 测试、前端
 * <p>
 * 一两天之后。 我开始处理这个需求（大概需要一周完成）
 * 做了三天、四天之后，发现不对经。
 * <p>
 * 对线。   产品、产品leader、后端、后端leader。
 * 3天。
 * <p>
 * 团队的主leader:后端。
 * 产品的leader。 人比较强势。
 * 产品比较狠。
 *
 * @author Common-zhou
 * @since 2024-03-25 09:42
 */
public class Demo1 {
    public static void main(String[] args) {

        File sourceFile = new File("D:\\ev录屏\\58th录屏\\Java58_Day1_03_Java基础知识复习1.mp4");
        File targetFile = new File("C:\\Users\\zhoubing\\Desktop\\tmp\\Java58_copy.mp4");

        new CopyFileThread(sourceFile, targetFile).start();
    }
}


/**
 * 使用多线程实现方式一来实现多个文件一起复制功能(3个线程复制3个文件)，并在控制台显示复制的进度，进度以百分比表示
 * 例如：把文件A复制到E盘某文件夹下，在控制台上显示“XXX文件已复制xx%”，
 * “XXX文件已复制xxx%”……“XXX文件已复制xxx%”，“XXX复制完成！”
 * 注: 为了更好的显示百分比推荐使用字节流进行复制操作
 * 提示: 进度可以用当前已循环读写的字节和除以文件大小字节
 */
class CopyFileThread extends Thread {

    File copySourceFile;
    File targetFile;

    public CopyFileThread(File copySourceFile, File targetFile) {
        this.copySourceFile = copySourceFile;
        this.targetFile = targetFile;
    }

    @Override
    public void run() {

        // 需要什么参数：  成员变量。
        // 源文件 + 复制后文件

        // 百分比怎么算？   已复制的 / 总的。

        long totalLength = copySourceFile.length();

        try (InputStream inputStream = new FileInputStream(copySourceFile); OutputStream outputStream = new FileOutputStream(targetFile);) {

            int copiedLength = 0;

            byte[] bytes = new byte[20480];
            int len = -1;
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
                copiedLength += len;

                // 在Java中，想将一个double类型的数字，保留两位小数，格式化输出
                DecimalFormat df = new DecimalFormat("#.00");
                String formattedRatio = df.format(1.0 * copiedLength / totalLength * 100);

                System.out.println(copySourceFile.getName() + "已复制：" + formattedRatio + "%");
            }
            System.out.println(copySourceFile.getName() + "复制完成");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
