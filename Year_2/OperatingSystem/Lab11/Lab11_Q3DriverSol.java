package Lab11;

import java.util.Random;

public class Lab11_Q3DriverSol {
    public static void main(String[] args) {
        int numPopper = 1; 
        int numPusher = 1;
        int numTurns = 10;
        StackForConcurrent stack = new StackForConcurrent();
        Pusher[] pushArr = new Pusher[numPusher];
        Popper[] poppArr = new Popper[numPopper];
        for (int i = 0; i < numPusher; i++) {
            pushArr[i] = new Pusher(numTurns, stack);
            poppArr[i] = new Popper(numTurns, stack);
            pushArr[i].start();
            poppArr[i].start();
        }
        for (int i = 0; i < numPusher; i++) {
            try {
                pushArr[i].join();
                poppArr[i].join();
            } catch (InterruptedException ie) {}
        }
    }
}

class Pusher extends Thread {
    int turns;
    StackForConcurrent concurStack;

    Pusher(int t, StackForConcurrent s) {
        turns = t;
        concurStack = s;
    }

    // constructor
    /* Q5 */ void run() {
        Random rand = new Random();
        try {
            sleep(rand.nextInt(100));
        } catch (InterruptedException ie) {
        }
        for (int i = 0; i < turns; i++)
            concurStack.push(i);
    } // run
}

class Popper extends Thread {
    int turns;
    StackForConcurrent concurStack;

    Popper(int t, StackForConcurrent s) {
        turns = t;
        concurStack = s;
    }

    public void run() {
        int x = -1;
        for (int j = 0; j < turns; j++) {
            x = concurStack.pop();
            System.out.println("got " + x + " stack size = " + concurStack.size);
        }
    } // run
}