import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    // Função para ordenar o array usando o algoritmo QuickSort
    public static void quickSort(int[] array, int esquerda, int direita, int [] contador) {
        if (esquerda < direita) {
            // Chamo a função repartir() para dividir o array e obter o índice do pivô
            int pivoIndice = repartir(array, esquerda, direita, contador);
            // Chama recursivamente a função quickSort() para ordenar as duas metades do array em relação ao pivô
            quickSort(array, esquerda, pivoIndice - 1, contador);
            quickSort(array, pivoIndice + 1, direita, contador);
        }
    }

    // Função auxiliar para o QuickSort: particiona o array e retorna o índice do pivô
    public static int repartir(int[] array, int esquerda, int direita, int[] contador) {
        // Escolhe o último elemento do array como pivô
        int pivo = array[direita];
        // Inicializa o índice do menor elemento como o primeiro elemento
        int i = esquerda - 1;
        // Percorre o array até o penúltimo elemento (o último é o pivô)
        for (int j = esquerda; j <= direita - 1; j++) {
            contador[0]++; // incremento o contador de comparações
            // Se o elemento atual é menor que o pivô, incrementa o índice do menor elemento e troca o elemento atual com o menor elemento
            if (array[j] < pivo) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                contador[1]++; // incremento o contador de trocas
            }
        }
        // Troca o pivô com o primeiro elemento maior que ele (ou seja, o elemento no índice i+1)
        int temp = array[i + 1];
        array[i + 1] = array[direita];
        array[direita] = temp;
        contador[1]++; // incremento o contador de trocas
        // Retorna o índice do pivô após a troca
        return i + 1;
    }

    // Função para gerar um array com 1000 elementos aleatórios
    public static int[] gerarArrayRandomico() {
        int[] array = new int[1000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    // Função principal para rodar o algoritmo e medir o tempo de execução
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int n = tc.nextInt();
        int[] array = new int[n];
        System.out.println("Digite 1 para inserir os elementos manualmente");
        System.out.println("Digite 2 para gerar um array com 1000 elementos aleatórios");
        int choice = tc.nextInt();


        if (choice == 1) {
            for (int i = 0; i < n; i++) {
                System.out.printf("Digite o %dº número: ", i + 1);
                array[i] = tc.nextInt();
            }
        } else if (choice == 2) {
            // Gera um array com 1000 elementos aleatórios
            array = gerarArrayRandomico();
        } else {
            System.out.println("Opção inválida!");
            return;
        }

        int[] contador = {0, 0}; // Inicializo os contadores de comparações e trocas como zero
        System.out.println("Array antes da ordenação: " + Arrays.toString(array)); // imprimo o array passado pelo usuário
        // Medição do tempo de execução
        long inicio = System.currentTimeMillis();// inicio o cronometro
        quickSort(array, 0, array.length - 1, contador); // Chama o algoritmo de ordenação
        long fim = System.currentTimeMillis();// finaliza o cronometro
        long tempoDeExecucao = fim - inicio;  // subtraio o inicio e o fim do cronometro pra descobrir o tempo gasto
        System.out.println("Array ordenado: " + Arrays.toString(array)); // imprimo o array ordenado
        System.out.printf("Tempo levado para ordenar o array: " + tempoDeExecucao + " milissegundos"); // imprimo o tempo de execução
        System.out.println("Número de comparações: " + contador[0]); // imprimo o numero de comparações
        System.out.println("Número de trocas: " + contador[1]); // imprimo o numero de trocas
    }
}
