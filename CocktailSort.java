public class CocktailSort {

    static long iteracoes = 0;
    static long trocas = 0;

    public static void cocktailSort(int tamanho, int[] vetor) {
        boolean trocou = true;
        int inicio = 0;
        int fim = tamanho - 1;
        int temp;

        while (trocou) {
            iteracoes++;
            trocou = false;

            for (int i = inicio; i < fim; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    temp = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }

            if (!trocou) {
                break;
            }

            trocou = false;
            fim--;

            for (int i = fim; i > inicio; i--) {
                if (vetor[i] < vetor[i - 1]) {
                    temp = vetor[i];
                    vetor[i] = vetor[i - 1];
                    vetor[i - 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }

            inicio++;
        }
    }

    public static void printVetor(String titulo, int[] v) {
        System.out.print(titulo + ": ");
        for (int x : v) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        int[][] vetores = {vetor1, vetor2, vetor3};

        for (int n = 0; n < vetores.length; n++) {
            System.out.println("\n-----");
            System.out.println("Ordenando vetor " + (n + 1));

            int[] atual = vetores[n].clone();
            printVetor("Vetor original", atual);

            // reset métricas
            iteracoes = 0;
            trocas = 0;

            cocktailSort(atual.length, atual);

            printVetor("Vetor final ordenado", atual);
            System.out.println("Iteracoes: " + iteracoes);
            System.out.println("Trocas: " + trocas);
            System.out.println("-----\n");
        }
    }
}
