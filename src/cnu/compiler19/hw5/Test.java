package cnu.compiler19.hw5;

public class Test {
    public static int sum(int n){
        if(n == 1) return 1;
        return n + sum(n-1);
    }

    public static void main(String[] args){
        System.out.println(sum(100));
    }

}
