public class MinhaLista {
    private int[] elementos;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;


    public MinhaLista() {
        this.elementos = new int[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    public void add(int elemento) {
        if (tamanho == elementos.length) {
            redimensionar();
        }
        elementos[tamanho] = elemento;
        tamanho++;
    }


    private void redimensionar() {
        int novaCapacidade = elementos.length * 2;
        int[] novoArray = new int[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[i];
        }
        elementos = novoArray;
    }

    public int get(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        return elementos[indice];
    }


    public int size() {
        return tamanho;
    }

    public int[] toArray() {
        int[] array = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            array[i] = elementos[i];
        }
        return array;
    }
}