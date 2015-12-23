package com.pli.project.algorithm.os.Sync;

/**
 * Created by lipeng on 2015/12/21.
 */

class PrintDemo1 {

    public void print() {
        for(int i=0; i<100; i++) {
            for(int j=0; j<5; j++)
                System.out.print(0);
            System.out.println();
        }
    }

}

public class NoSync implements Runnable{

    PrintDemo1 print = new PrintDemo1();

    public NoSync(PrintDemo1 print) {
        this.print = print;
    }

    public void run() {
        print.print();
    }

    public static void main(String[] args) {
        PrintDemo1 printDemo1 = new PrintDemo1();
        Thread t0 = new Thread(new NoSync(printDemo1));
        Thread t1 = new Thread(new NoSync(printDemo1));
        t0.start();
        t1.start();
    }


}
