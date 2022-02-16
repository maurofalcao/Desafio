package Desafio.Desafio_1;

import java.util.Scanner;

class Desafio_1 {
  public static void main(String[] args) {

    /** Instancia a classe Scanner para entrada de dados pelo teclado. */
    Scanner entrada = new Scanner(System.in);

    System.out.print("Digite a altura da escada: ");

    /**
     * Instancia um objeto escada definido em Escada.java através da classe Escada
     */
    Escada escada = new Escada();
    /** Captura a altura da escada informada pelo usuário. */
    escada.altura = entrada.nextInt();
    entrada.close();

    /**
     * Percorre um laço para imprimir cada lance da escada.
     * Utiliza o método MontarDegrau da classe Escada para
     * preencher cada degrau de acordo com as especificações
     * de base e altura.
     */
    for (int base = 1; base <= escada.altura; base += 1) {
      String s = escada.MontarDegrau(base);
      System.out.println(s);
    }
  }

}