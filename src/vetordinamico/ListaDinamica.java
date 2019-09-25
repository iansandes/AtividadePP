package vetordinamico;

public class ListaDinamica<T> {

    private T[] lista;
    private int tamanho;
    private boolean duplic;

    public ListaDinamica() {
        this.duplic = true;
        this.tamanho = 0;
        this.lista = (T[]) new Object[10];
    }

    public ListaDinamica(int tamanho) {
        this();
        this.lista = (T[]) new Object[tamanho];
    }

    public ListaDinamica(boolean duplic) {
        this();
        this.duplic = duplic;
    }

    public boolean add(T element) {
        if (this.tamanho == this.lista.length) {
            this.aumentarTamanho();
        }
        if (!this.duplic) {
            if (this.verificarDuplicado(element)) {
                return false;
            }
        }
        this.lista[tamanho++] = element;
        return true;
    }

    public void add(int index, T element) {
        if (this.tamanho == this.lista.length) {
            this.aumentarTamanho();
        }
        if (!this.duplic) {
            if (this.verificarDuplicado(element)) {
            } else {
                for (int i = this.tamanho; i >= 0; i--) {
                    if (i == index) {
                        this.lista[i] = element;
                        this.tamanho++;
                        break;
                    }
                    this.lista[i] = this.lista[i - 1];
                }
            }
        } else {
            for (int i = this.tamanho; i >= 0; i--) {
                if (i == index) {
                    this.lista[i] = element;
                    this.tamanho++;
                    break;
                }
                this.lista[i] = this.lista[i - 1];
            }
        }
    }

    private void aumentarTamanho() {
        T[] vetorAuxiliar = (T[]) new Object[this.lista.length * 2];
        for (int i = 0; i < this.tamanho; i++) {
            vetorAuxiliar[i] = this.lista[i];
        }
        this.lista = vetorAuxiliar;
    }

    private boolean verificarDuplicado(T element) {
        if (this.tamanho == 0) {
            return false;
        }
        for (int i = 0; i < this.tamanho; i++) {
            if (this.lista[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.lista = (T[]) new Object[10];
        this.tamanho = 0;
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.lista[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= this.tamanho) {
            return null;
        }
        return this.lista[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.lista[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.tamanho == 0;
    }

    public int lastIndexOf(T element) {
        for (int i = this.tamanho - 1; i >= 0; i--) {
            if (this.lista[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public T remove(int index) {
        if (index < 0 || index >= this.tamanho) {
            return null;
        }
        T aux = this.lista[index];
        for (int i = index; i < this.tamanho - 1; i++) {
            this.lista[i] = this.lista[i + 1];
        }
        this.lista[this.tamanho - 1] = null;
        this.tamanho--;
        return aux;
    }

    public int size() {
        return this.tamanho;
    }

    public void resize(int length) {
        T[] vetorAuxiliar = (T[]) new Object[this.lista.length + length];
        for (int i = 0; i < this.tamanho; i++) {
            vetorAuxiliar[i] = this.lista[i];
        }
        this.lista = vetorAuxiliar;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.tamanho; i++) {
            s.append(this.lista[i]);
            if (i == (this.tamanho - 1)) {
                break;
            }
            s.append(", ");
        }
        s.append("]");
        return s.toString();
    }

}
