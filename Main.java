public class Main {
    public int fatorial (int n) throws Exception
    {
        if (n < 0) throw new Exception("Não existe fatorial de número negativo");
        if (n ==0) return 1;
        
        return n * fatorial(n-1);
    }

    public int somaAnt(int n){

        if (n == 0) 
            return 0;

        return n + somaAnt(n - 1);
    }

    public static boolean isNegativo (int a, int b)
    {
        if (a==0) return true;
        if (b==0) return false;
        return isNegativo(++a, --b);
    }
    public static boolean isNegativo (int x)
    {
        if (x==0) return false;
        return isNegativo (x,x);
    }

    public int soma(int a, int b){
        if(b == 0) 
            return a;
        if(isNegativo(b)) return soma(--a, ++b); //se b é negativo ent subtrair de a e por em b
        return soma(++a, --b);
    }

    public int subtracao (int a, int b){
        if (b==0)
            return a;
        if (isNegativo(b)) return subtracao(++a, ++b);
        return subtracao(--a, --b);
    }

    public int modulo(int x){
        if (isNegativo(x)){
            return subtracao(0, x);
        }

        return x;
    }

    public int multiplicacao(int a, int b){
        if (b == 0) return 0;
        if (b == 1) return a;
        if (isNegativo(b)){
            if(isNegativo(a)){
                return multiplicacao(modulo(a), modulo(b));
            }
            return subtracao(0, multiplicacao(modulo(a), modulo(b)));
        }
        b--;
        return soma(a, multiplicacao(a, b));
    }
    public int divisao(int x, int y) throws Exception
    {
			if(y == 0) throw new Exception("Não pode dividir por 0");
			if(y == 1) return x;
			if(isMaior(modulo(y), modulo(x))) return 0;
			
			if(isNegativo(x) == isNegativo(y))
			{
				return soma(divisao(subtracao(x,y),y),1);
			}
			return subtracao(divisao(soma(x,y),y),1);
	}

    public boolean isMenor(int x, int y){
        return isNegativo(subtracao(x, y));
    }

    public boolean isMaior(int x, int y){
        if(x==y) return false;
        if(isMenor(x, y)) return false;
        return true;
    }

    public static void main(String[] args) throws Exception{
        Main m = new Main();
        System.out.println(m.fatorial(5));
        System.out.println(m.somaAnt(2));
        System.out.println(m.isNegativo(1));
        System.out.println(m.isNegativo(-2));
        System.out.println(m.subtracao(-2, 3));
        System.out.println(m.modulo(20));
        System.out.println(m.multiplicacao(2, 3));
        System.out.println(m.divisao(5, 2));
        

    }
}