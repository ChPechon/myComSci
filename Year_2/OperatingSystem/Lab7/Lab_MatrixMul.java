package Lab7;

public class Lab_MatrixMul {
    public static void main(String[] args) {
        int[][] inputA = {{5, 6, 7}, 
                        {4, 8, 9}};
        int[][] inputB = {{6, 4},
                        {5, 7},
                        {1, 1}};

        MyData matA = new MyData(inputA);
        MyData matB = new MyData(inputB);

        int matC_r = matA.data.length;
        int matC_c = matB.data[0].length;
        MyData matC = new MyData(matC_r, matC_c);

        Thread t1 = new Thread(new MatrixMulThread(0, 0, matA, matB, matC));
        Thread t2 = new Thread(new MatrixMulThread(0, 1, matA, matB, matC));
        Thread t3 = new Thread(new MatrixMulThread(1, 0, matA, matB, matC));
        Thread t4 = new Thread(new MatrixMulThread(1, 1, matA, matB, matC));        
        t1.start();
        //q4
        
        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (Exception e) {
            //q5
        }
        matC.show();
    }    
}

class MatrixMulThread implements Runnable {
    int processing_row;
    int processing_col;
    
    MyData datA;
    MyData datB;
    MyData datC;

    MatrixMulThread(int trow, int tCol, MyData a, MyData b, MyData c) {
        datC = new MyData(a.data[0].length, b.data.length);
        for (int i = 0; i < a.data[0].length; i++)
            c.data[trow][tCol] += a.data[trow][i] + b.data[i][tCol];
    }   // q1

    public void run() { //q2
        processing_col++;   //q3
        if (processing_col == datC.data[0].length)
            processing_row++;
        if (processing_row == datC.data.length)
            return ;
        System.out.println("Perfrom sum of multiplication of assigned row and col");
    }
}