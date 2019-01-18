package 顺序表;

import java.util.Scanner;

class Data {
    String key;
    String name;
    int age;
}
class SLType {
    static final int MAXLEN = 100;
    Data[] ListData = new Data[MAXLEN+1];
    int ListLen;

    void SLInit(SLType SL) {
        SL.ListLen = 0;
    }

    int SLLength(SLType SL) {
        return SL.ListLen;
    }

    int SLInsert(SLType SL, int n, Data data) {
        if(SL.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能插入结点！");
            return 0;
        }
        if(n<1 || n>SL.ListLen-1) {
            System.out.println("插入元素序号错误，不能插入元素！");
            return 0;
        }
        for (int i = SL.ListLen; i >= n; i--) {
            SL.ListData[i+1] = SL.ListData[i];
        }
        SL.ListData[n] = data;
        SL.ListLen++;
        return 1;
    }

    int SLAdd(SLType SL, Data data) {
        if(SL.ListLen >= MAXLEN) {
            System.out.println("顺序表已满，不能再添加结点了！");
            return 0;
        }
        SL.ListData[++SL.ListLen] = data;
        return 1;
    }

    int SLDelete(SLType SL, int n) {
        if(n<1 || n>SL.ListLen+1) {
            System.out.println("删除结点序号错误，不能删除结点！");
            return 0;
        }
        for (int i = n; i < SL.ListLen; i++) {
            SL.ListData[i+1] = SL.ListData[i];
        }
        SL.ListLen--;
        return 1;
    }

    Data SLFindByNum(SLType SL, int n) {
        if(n<1 || n>SL.ListLen+1) {
            System.out.println("结点序号错误，不能返回结点！");
            return null;
        }
        return SL.ListData[n];
    }

    int SLFindByKey(SLType SL, String key) {
        for (int i = 1; i <= SL.ListLen; i++) {
            if(SL.ListData[i].key.compareTo(key) == 0) {
                return i;
            }
        }
        return 0;
    }

    int SLAll(SLType SL) {
        for (int i = 1; i <= SL.ListLen; i++) {
            System.out.println(SL.ListData[i].key + "," + SL.ListData[i].name + "," + SL.ListData[i].age);
        }
        return 0;
    }
}
public class SequenceList {
    public static void main(String[] args) {
        SLType SL = new SLType();
        Data pdata;
        String key;
        int i;
        System.out.println("顺序表操作演示！");
        SL.SLInit(SL);
        System.out.println("初始化顺序表完成！");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("输入添加的结点（学号 姓名 年龄）：");
            Data data = new Data();
            data.key = sc.next();
            data.name = sc.next();
            data.age = sc.nextInt();

            if(data.age == 0) {
                break;
            } else {
                if(SL.SLAdd(SL, data) == 0) {
                    break;
                }
            }
        }
        System.out.println("顺序表中的结点顺序为：");
        SL.SLAll(SL);

        System.out.println("要取出结点的序号：");
        i = sc.nextInt();
        pdata = SL.SLFindByNum(SL, i);
        if(pdata != null) {
            System.out.println("第" + i + "个结点为：（" + pdata.key + "," + pdata.name + "," + pdata.age + "）");
        }

        System.out.println("要查找结点的关键字：");
        key = sc.next();
        i = SL.SLFindByKey(SL, key);
        pdata = SL.SLFindByNum(SL, i);
        if(pdata != null) {
            System.out.println("第" + i + "个结点为：（" + pdata.key + "," + pdata.name + "," + pdata.age + "）");
        }
    }
}

