package matrizdinamica;

import vetordinamico.ListaDinamica;

public class MatrizDinamica<T> {

    private ListaDinamica<ListaDinamica> matriz;

    public MatrizDinamica() {
        this(5);
    }

    public MatrizDinamica(int tamanho) {
        this.matriz = new ListaDinamica<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            ListaDinamica<T> auxiliar = new ListaDinamica<>(5);
            this.matriz.add(auxiliar);
        }
    }

    public boolean criarDimensao(int index, int tamanhoDimensao) {
        if (index < 0 || index > this.matriz.size()) {
            return false;
        } else {
            int tamanho = matriz.get(index).size();
            if (tamanhoDimensao > tamanho) {
                tamanho = tamanhoDimensao - tamanho;
                matriz.get(index).resize(tamanho);
            }
            return true;
        }
    }

    public void adicionarElemento(int dimensaoA, int dimensaoB, T element) {
        this.matriz.get(dimensaoA).add(dimensaoB, element);
    }

    public void adicionarElemento(int dimensaoA, T element) {
        this.matriz.get(dimensaoA).add(element);
    }

    public void removerElemento(int dimensaoA, int dimensaoB) {
        this.matriz.get(dimensaoA).remove(dimensaoB);
    }

    public void limpar() {
        matriz.clear();
    }

    public boolean contem(int dimensaoA, T element) {
        return this.matriz.get(dimensaoA).contains(element);
    }

    public boolean contem(int dimensaoA, int dimensaoB, T element) {
        T elemAux = (T) this.matriz.get(dimensaoA).get(dimensaoB);
        return elemAux.equals(element);
    }

    public boolean contem(T element) {
        for (int i = 0; i < this.matriz.size(); i++) {
            if (this.matriz.get(i).contains(element)) {
                return true;
            }
        }
        return false;
    }

    public T getElemento(int dimensaoA, int dimensaoB) {
        return (T) this.matriz.get(dimensaoA).get(dimensaoB);
    }

    public ListaDinamica<T> getElemento(int dimensaoA) {
        return this.matriz.get(dimensaoA);
    }

    public boolean estaVazio() {
        return this.matriz.isEmpty();
    }

    public boolean estaVazio(int dimensaoA) {
        return this.matriz.get(dimensaoA).isEmpty();
    }

    public int tamanho() {
        return this.matriz.size();
    }

    public int tamanho(int dimensaoA) {
        return this.matriz.get(dimensaoA).size();
    }

    @Override
    public String toString() {
        return "matriz=" + matriz;
    }

}
