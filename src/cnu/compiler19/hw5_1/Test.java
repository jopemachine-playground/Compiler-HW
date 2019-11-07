package cnu.compiler19.hw5_1;

public class Test {

    public static int sum(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }

    public static int sum_recursive(int n){
        if(n == 1) return 1;
        return n + sum(n-1);
    }

    public static void main(String[] args){
        System.out.println(sum(100));
    }

}
