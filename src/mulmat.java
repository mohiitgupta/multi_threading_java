import java.util.Scanner;
public class mulmat {
    public static void main(String args[])
    {
        int row;
        int col;
        int a1=3,a2=3,a3=3,a4=3,i,j;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the order of First Matrix : ");
        try
        {
                a1= scan.nextInt();
                a2= scan.nextInt();
        }catch(Exception e){}
        
        int A[][]=new int[a1][a2];
        System.out.println("Enter the First Matrix : ");
        for(i=0;i<a1;i++)
        {
                for(j=0;j<a2;j++)
                {
                        try
                        {
                                A[i][j]= scan.nextInt();
                        }catch(Exception e){}
                }
        }
        System.out.print("Enter the order of Second Matrix : ");
        try
        {
                a3= scan.nextInt();
                a4= scan.nextInt();
        }catch(Exception e) {}
        int B[][]=new int[a3][a4];
        int C[][]=new int[a1][a4];
        
        if(a2!=a3)
        {
        	System.out.println("Invalid Multiplication");
        	System.exit(0);
        }
        
        System.out.println("Enter the Second Matrix : ");
        for(i=0;i<a3;i++)
        {
                for(j=0;j<a4;j++)
                {
                        try
                        {
                                B[i][j]= scan.nextInt();
                        }catch(Exception e){}
                }
        }
        int threadcount = 0;   
              Thread[] thrd = new Thread[a1*a4];
               

                try
                {
                   for(row = 0 ; row < a1; row++)
                   {
                        for (col = 0 ; col < a4; col++ )
                        {
                                // creating thread for multiplications
                             thrd[threadcount] = new Thread(new calc1(row, col, A, B, C));
                             thrd[threadcount].start(); //thread start
                             
                             thrd[threadcount].join(); // joining threads
                              threadcount++;
                        }
                        
                   }
                  
                }
                catch (InterruptedException ie){}
                
                // printing matrix A
                System.out.println(" A Matrix : ");
               for(row = 0 ; row < a1; row++)
                {
                        for (col = 0 ; col < a2; col++ )
                        {
                            System.out.print("  "+A[row][col]);
                        }
                        System.out.println();
                 }
                
                // printing matrix B
                System.out.println(" B Matrix : ");
                for(row = 0 ; row < a3; row++)
                {
                        for (col = 0 ; col < a4; col++ )
                        {
                            System.out.print("  "+B[row][col]);
                        }
                        System.out.println();
                 }
                
                // printing resulting matrix C after multiplication
                System.out.println(" Resulting C Matrix : ");
                for(row = 0 ; row < a1; row++)
                {
                        for (col = 0 ; col < a4; col++ )
                        {
                            System.out.print("  "+C[row][col]);
                        }
                        System.out.println();
                 }
    }
}

class calc1 implements Runnable
{
    private int row, col;
    private int A[][];
    private int B[][];
    private int C[][];
    
    public calc1(int row, int col, int A[][], int B[][], int C[][] )
    {
        this.row = row;
        this.col = col;
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    @Override
    public void run()
    {
       
       //int i;
       //for(i=0;i<col;i++)
    	//	{
           // C[row][i]=0;
            for(int k = 0; k < B.length; k++)
             C[row][col] += A[row][k] * B[k][col];
            //}                
    }
}