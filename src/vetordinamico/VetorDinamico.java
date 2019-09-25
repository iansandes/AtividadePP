package vetordinamico;

public class VetorDinamico {

    public static void main(String[] args) {
        ListaDinamica<Integer> lista = new ListaDinamica<>(false);
        lista.add(5);
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(1, 4);
        lista.resize(10);
        System.out.println(lista);

    }
}
