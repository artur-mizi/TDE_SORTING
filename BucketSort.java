public class BucketSort {

    static int iteracoes = 0;
    static int trocas = 0;
    static final int M = 10;

    public static void bucketSort(int[] vetor, int min, int max) {
        if (vetor == null || vetor.length == 0) return;
        if (max == min) return;

        int div = (max - min) / M;
        if (div == 0) div = 1;

        int[][] buckets = new int[M][vetor.length];
        int[] bucketSizes = new int[M];

        for (int value : vetor) {
            int i = (value - min) / div;
            if (i < 0) i = 0;
            else if (i >= M) i = M - 1;
            buckets[i][bucketSizes[i]++] = value;
            trocas++;
        }

        int index = 0;
        for (int i = 0; i < M; i++) {
            if (bucketSizes[i] > 0) {
                iteracoes++;

                int[] bucketArray = new int[bucketSizes[i]];
                for (int j = 0; j < bucketSizes[i]; j++) {
                    bucketArray[j] = buckets[i][j];
                }

                int bucketMin = bucketArray[0];
                int bucketMax = bucketArray[0];
                for (int j = 1; j < bucketArray.length; j++) {
                    if (bucketArray[j] < bucketMin) bucketMin = bucketArray[j];
                    if (bucketArray[j] > bucketMax) bucketMax = bucketArray[j];
                }

                if (bucketArray.length > 1 && bucketMax != bucketMin) {
                    bucketSort(bucketArray, bucketMin, bucketMax);
                }

                for (int v : bucketArray) vetor[index++] = v;
            }
        }
    }

    public static int[] minMax(int[] v) {
        int min = v[0], max = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] < min) min = v[i];
            if (v[i] > max) max = v[i];
        }
        return new int[]{min, max};
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

            int[] atual = vetores[n];
            int[] mm = minMax(atual);

            printVetor("Vetor original", atual);
            bucketSort(atual, mm[0], mm[1]);
            printVetor("Vetor ordenado", atual);

            System.out.println("Iteracoes: " + iteracoes);
            System.out.println("Trocas: " + trocas);
            System.out.println("-----\n");

            iteracoes = 0;
            trocas = 0;
        }
    }
}
