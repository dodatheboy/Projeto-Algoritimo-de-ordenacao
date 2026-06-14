public class BubbleSort implements Ordenador {

    @Override
    public void ordenar(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            boolean trocou = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    trocar(array, j, j + 1);
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    private void trocar(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}