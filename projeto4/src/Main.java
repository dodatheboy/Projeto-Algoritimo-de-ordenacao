import java.io.IOException;


public class Main {


    private static final String CAMINHO_DADOS = "src/conjuntosDeDados/";

    private static final String[] ARQUIVOS = {
            "aleatorio_100",
            "aleatorio_1000",
            "aleatorio_10000",
            "crescente_100",
            "crescente_1000",
            "crescente_10000",
            "decrescente_100",
            "decrescente_1000",
            "decrescente_10000"
    };

    private static final String[] ALGORITMOS = {"Bubble Sort", "Insertion Sort", "Quick Sort"};

    private static final Ordenador[] ORDENADORES = {
            new BubbleSort(),
            new InsertionSort(),
            new QuickSort()
    };

    public static void main(String[] args) {
        System.out.println("=======================================================================");
        System.out.println("RELATÓRIO DE ANÁLISE DE ALGORITMOS DE ORDENAÇÃO");
        System.out.println("=======================================================================\n");

        System.out.printf("%-25s | %-12s | %-15s | %-10s%n", "Conjunto de Dados", "Bubble Sort", "Insertion Sort", "Quick Sort");
        System.out.println("-----------------------------------------------------------------------");

        for (String arquivo : ARQUIVOS) {
            try {
                int[] array = LeitorCSV.lerArquivo(CAMINHO_DADOS + arquivo + ".csv");

                double tempoBubbleSort = 0;
                double tempoInsertionSort = 0;
                double tempoQuickSort = 0;

                for (int i = 0; i < ORDENADORES.length; i++) {
                    long tempoNano = MedidorTempo.medirTempo(ORDENADORES[i], array);
                    double tempoMilissegundos = MedidorTempo.converterParaMilissegundos(tempoNano);

                    switch (ALGORITMOS[i]) {
                        case "Bubble Sort":
                            tempoBubbleSort = tempoMilissegundos;
                            break;
                        case "Insertion Sort":
                            tempoInsertionSort = tempoMilissegundos;
                            break;
                        case "Quick Sort":
                            tempoQuickSort = tempoMilissegundos;
                            break;
                    }
                }

                System.out.printf("%-25s | %-12.2f | %-15.2f | %-10.2f%n",
                        arquivo, tempoBubbleSort, tempoInsertionSort, tempoQuickSort);

            } catch (IOException e) {
                System.err.println("Erro ao ler o arquivo " + arquivo + ".csv: " + e.getMessage());
            }
        }

        System.out.println("\n=======================================================================");
    }
}