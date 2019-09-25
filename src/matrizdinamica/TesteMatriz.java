package matrizdinamica;


public class TesteMatriz {
    
    public static void main(String[] args) {
        MatrizDinamica<String> matriz = new MatrizDinamica<>();
        matriz.criarDimensao(0, 10);
        matriz.adicionarElemento(0, "teste1");
        matriz.adicionarElemento(0, "teste2");
        matriz.adicionarElemento(1, "teste3");
        System.out.println(matriz);
    }
}

