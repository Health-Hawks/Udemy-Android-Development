//import java.util.*;
//
//import sun.awt.SunHints.Value;
//
//public class PermutationTester
//{
//
//    static int [] val;
//    static List <Double> values = new ArrayList<Double>();
//    static int now = -1;
//    static int V = 12;
//    static long count = 0;
//    static long totalCount=0;
//    static int min = 0;
//    static int max = 0;
//    static double mean = 0;
//    static double ssq = 0;
//    static long total = 0;
//    static double stdev = 0;
//    static int flowMax = 0;
//    static int flowMin = 0;
//    static int distMax = 0;
//    static int distMin = 0;
//    static int lower = 0;
//    static int upper = 0;
//    static int n = 1000;
//    static double dx;
//    static int median;
//    static int mode;
//    static int [] h = new int [n];
//    static int [] opt = new int [V+1];
//    static int [][] a = {{0, 1, 2, 3, 1, 2, 3, 4, 2, 3, 4, 5
//    },{1, 0, 1, 2, 2, 1, 2, 3, 3, 2, 3, 4
//    },{2, 1, 0, 1, 3, 2, 1, 2, 4, 3, 2, 3
//    },{3, 2, 1, 0, 4, 3, 2, 1, 5, 4, 3, 2
//    },{1, 2, 3, 4, 0, 1, 2, 3, 1, 2, 3, 4
//    },{2, 1, 2, 3, 1, 0, 1, 2, 2, 1, 2, 3
//    },{3, 2, 1, 2, 2, 1, 0, 1, 3, 2, 1, 2
//    },{4, 3, 2, 1, 3, 2, 1, 0, 4, 3, 2, 1
//    },{2, 3, 4, 5, 1, 2, 3, 4, 0, 1, 2, 3
//    },{3, 2, 3, 4, 2, 1, 2, 3, 1, 0, 1, 2
//    },{4, 3, 2, 3, 3, 2, 1, 2, 2, 1, 0, 1
//    },{5, 4, 3, 2, 4, 3, 2, 1, 3, 2, 1, 0}};
//
//    static int [][] b = {{0,  5,  2,  4,  1,  0,  0,  6,  2,  1,  1,  1
//    },{5,  0,  3,  0,  2,  2,  2,  0,  4,  5,  0,  0
//    },{2,  3,  0,  0,  0,  0,  0,  5,  5,  2,  2,  2
//    },{4,  0,  0,  0,  5,  2,  2, 10,  0,  0,  5,  5
//    },{1,  2,  0,  5,  0, 10,  0,  0,  0,  5,  1,  1
//    },{0,  2,  0,  2, 10,  0,  5,  1,  1,  5,  4,  0
//    },{0,  2,  0,  2,  0,  5,  0, 10,  5,  2,  3,  3
//    },{6,  0,  5, 10,  0,  1, 10,  0,  0,  0,  5,  0
//    },{2,  4,  5,  0,  0,  1,  5,  0,  0,  0, 10, 10
//    },{1,  5,  2,  0,  5,  5,  2,  0,  0,  0,  5,  0
//    },{1,  0,  2,  5,  1,  4,  3,  5, 10,  5,  0,  2
//    },{1,  0,  2,  5,  1,  0,  3,  0, 10,  0,  2,  0}};
//
//    public static void main(String arg [])
//    {
//        //Set up
//        //Get coordinates
//        //Calculate cost, e.g., the distance matrix (for TSP)
//        //Generate permutations, e.g., in TSP these trips, but in other common applications they may be assignments
//        val = new int [V+1];
//        getTotal(V);
//        getMinMax();
//        long start = System.currentTimeMillis();
//        System.out.println(total);
//        for (int i=0; i<=V; i++)
//            val[i]=0;
//        p(0);
//        long end = System.currentTimeMillis();
//        double xsqr = (mean*mean)/count;
//        double undersqrt = (ssq-xsqr)/count;
//        stdev = Math.sqrt(undersqrt);
//        mean = mean/count;//Calulate the mean and standard deviation
//        System.out.println("Runtime: "+ (end-start));
//        System.out.println("Total: "+total);
//        System.out.println("Count: "+count+" TotalCount: "+totalCount);
//        System.out.println("Time Per Permutation: "+((double)(end-start)*1000/total));
//        System.out.println("Mean: "+mean);
//        System.out.println("X^2: "+ssq);
//        System.out.println("(X)^2: "+xsqr);
//        System.out.println("Stdev: "+stdev);
//        System.out.println("Max: "+max);
//        System.out.println("Min: "+min);//Report the max, min, mean, standard deviation.
//
//        for (int i=1; i<=V; i++){
//            System.out.print(opt[i]+" ");
//        }
//        System.out.println("");
//        int sum = 0;
//        for (int i=1;i<=V;i++){
//            for (int j = 1;j<=V;j++){
//                sum += a[i-1][j-1] * b[opt[i]-1][opt[j]-1];
//
//            }
//        }
//        System.out.println("Value: "+sum);
//        for (int i = 0; i < n; i++){
//            System.out.println(i+" "+h[i]);
//        }
//    }
//
//
//    public static void p(int k)
//    {
//        now++;
//        val[k]=now;
//        if (now==V) handleP();
//        for (int i=1; i<=V; i++)
//            if (val[i]==0) p(i);
//        now--;
//        val[k]=0;
//    }
//
//    public static void handleP()
//    {
//        int sum = 0;
//        int xsq = 0;
//        count++;
//        //Process the assignment/path in order to determine and preserve the implications of its cost
//        if ((count%10000000) == 0){
//            System.out.println(count+"\t"+"Remaining: "+(total-count));
//            for (int i=1; i<=V; i++){
//                System.out.print(opt[i]+" ");
//            }
//            System.out.println("**");
//        }
//        for (int i=1;i <= V;i++){
//            for (int j = 1;j<= V;j++){
//                totalCount++;
//                sum += a[i-1][j-1] * b[(val[i])-1][(val[j]-1)];
//                xsq += sum * sum;
//            }
//        }
//
//        if (min == 0){
//            min = sum;
//            for (int i=1; i<=V; i++){
//                opt[i]=val[i];
//            }
//        }
//        else if (min > sum){
//            min = sum;
//            for (int i=1; i<=V; i++){
//                opt[i]=val[i];
//            }
//        }
//        if (max == 0){
//            max = sum;
//        }
//        else if(max<sum){
//            max = sum;
//        }
//        mean +=sum;
//        ssq +=sum*sum;
//        int index =(int)((sum-lower)/dx);
//        h[index]++;
//        //System.out.println("**");
//
//    }
//
//    public static void getTotal (int numbers){
//        total = 1;
//        for (int i=1;i<=V;i++){
//            total*= i;
//        }
//    }
//    public static void getMinMax(){
//        flowMin = a[0][0];
//        flowMax = a[0][0];
//        distMin = b[0][0];
//        distMax = b[0][0];
//
//        for (int i = 0; i<V;i++){
//            for (int j = 0; j<V;j++){
//                if (a[i][j] != 0){
//                    if(flowMin==0){
//                        flowMin = a[i][j];
//                    }
//                    else if (a[i][j]<flowMin){
//                        flowMin = a[i][j];
//                    }
//                    if(a[i][j]>flowMax){
//                        flowMax = a[i][j];
//                    }
//                }
//                if (b[i][j]!=0) {
//                    if(distMin==0){
//                        distMin = b[i][j];
//                    }
//                    else if (b[i][j]<distMin){
//                        distMin = b[i][j];
//                    }
//                    if(b[i][j]>distMax){
//                        distMax = b[i][j];
//                    }
//                }
//
//            }
//
//        }
//
//        upper = V*2*flowMax*distMax;
//        lower = V*2*flowMin*distMin;
//        int testUpper = upper;
//        int testLower = lower;
//        dx = (double)(upper-lower)/(double)n;
//    }
//
//}