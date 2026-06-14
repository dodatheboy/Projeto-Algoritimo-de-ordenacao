import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {

    public static int[] lerArquivo(String caminhoArquivo) throws IOException {
        MinhaLista numeros = new MinhaLista();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                int numero = Integer.parseInt(linha.trim());
                numeros.add(numero);
            }
        }
        return numeros.toArray();
    }
}