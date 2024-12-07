public class Main {
    public int fatorial (int n)
    {
        if (n ==0)
            return 1;
        
        return n * fatorial(n-1);
    }

    public int soma(int n){

        if (n ==0) 
            return 0;

        return n + soma(n - 1);
    }

    public 


    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.fatorial(5));
        System.out.println(m.soma(2));
    }
}