package Desafio.Desafio_3;

import java.util.Arrays;
import java.util.Scanner;

public class Desafio_3 {

  public static void main(String[] args) {

    System.out.println();
    System.out.print("Digite o conjunto de caracteres que será utilizado e pressione <Enter>: ");

    Scanner entrada = new Scanner(System.in);

    Palavra novaPalavra = new Palavra(entrada.nextLine());

    String sAux1 = "";
    String sAux2 = "";

    char cAux1;
    System.out.println("");

    System.out.println("Palavra digitada: " + novaPalavra.palavra + ", Tamanho = " + novaPalavra.tamanho);

    System.out.println("");

    for (int contador = 0; contador < novaPalavra.tamanho; contador += 1) {
      /**
       * Este laço gera a string que será utilizado na criação dos arrays
       * para trabalhar os pares.
       */
      cAux1 = novaPalavra.palavra.charAt(contador);
      // sAux1 = sAux1 + novaPalavra.palavra.substring(contador1);
      sAux1 = sAux1 + cAux1;

      if (contador == (novaPalavra.tamanho - 1))
        continue;
      else
        sAux1 = sAux1 + ";";
    }

    String[] array1 = sAux1.split(";");

    /** Esta variável irá armazenar a quantidade de matches */
    int quantidade = 0;

    /**
     * Este primeiro laço define o tamanho da substring de pesquisa.
     * Por questões de performance limitei o tamanho da substring de
     * pesquisa para o valor 8.
     */
    for (int tamanhosubstr = 1; tamanhosubstr <= novaPalavra.tamanho; tamanhosubstr++) {
      /**
       * Caso seja utilizada uma palavra maior a
       * substring de pesquisa estará limitada aos primeiros 8 caracteres.
       **/
      if (tamanhosubstr > 8)
        break;
      /**
       * Este segundo laço atribui a posição de pesquisa na palavra
       */
      for (int contador1 = 0; contador1 < novaPalavra.tamanho; contador1++) {
        /**
         * Este laço monta pares para validação combinando-os 1 a 1, 2 a 2 e assim por
         * diante (utilizando a variável tamanhosubstr) até o tamanho da palavra
         */
        for (int contador2 = (novaPalavra.tamanho - 1); contador2 >= 0; contador2--) {

          if ((contador1 + tamanhosubstr) > novaPalavra.tamanho) { /** Garantir que não haverá estouro */
            break;
          }

          /** Utilizo esta variável para guardar a substring de pesquisa */
          sAux1 = novaPalavra.palavra.substring(contador1, (contador1 + tamanhosubstr));

          if (tamanhosubstr == 10) {
            /**
             * Aqui verifico se existe um caracter igual a partir da posição definida pela
             * veriável contador1
             */
            if (contador2 == contador1)
              break;

            /** Utilizo esta variável para armazenar a substring que será comparada */
            sAux2 = novaPalavra.palavra.substring(contador2, contador2 + tamanhosubstr);

            if (sAux1.equals(sAux2)) {
              System.out.println("[" + sAux1 + "," + sAux2 + "]");
              quantidade += 1;
            }
          } else {
            /**
             * Aqui serão pesquisadas substrings de tamanho 2 ou mais e
             * montarei uma lista com permutas dos caracteres para pesquisa
             * na palavra digitada
             */
            novaPalavra.permuta = "";
            novaPalavra.MontaListaPermuta(sAux1, "");
            sAux2 = novaPalavra.permuta;

            String[] array2 = sAux2.split(";");
            // boolean encontrado = false;
            for (int i = 0; i < array2.length; i++) {
              int indice = novaPalavra.palavra.indexOf(array2[i], (contador1 + 1));
              if (indice != -1) {
                System.out.println("[" + sAux1 + "," + array2[i] + "]");
                quantidade += 1;
              }
            }
            break;
          }

        }
      }

    }

    System.out.println("");
    System.out.println("Quantidade de anagramas encontrados: " + quantidade);

    entrada.close();
  }

}

/**
 * Palavra digitada: banana, Tamanho = 6
 * Reverso: ananab
 * Array1: [b, a, n, a, n, a]
 * Array2: [a, n, a, n, a, b]
 * 
 * 
 * 
 * 
 */