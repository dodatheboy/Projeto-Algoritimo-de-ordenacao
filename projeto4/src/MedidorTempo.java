public class MedidorTempo {

    public static long medirTempo(Ordenador ordenador, int[] array) {

        int[] arrayClone = array.clone();
        long tempoInicial = System.nanoTime();
        ordenador.ordenar(arrayClone);
        long tempoFinal = System.nanoTime();
        return tempoFinal - tempoInicial;
    }

    public static double converterParaMilissegundos(long nanoSegundos) {
        return nanoSegundos / 1_000_000.0;
    }
}