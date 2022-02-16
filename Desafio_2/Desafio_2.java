package Desafio.Desafio_2;

import java.util.Scanner;
import java.io.IOException;

public class Desafio_2 {
  public static void main(String[] args) throws IOException, InterruptedException {

    /** Imprime na tela as instruções ao usuário. */
    System.out.println("Uma senha para ser considerada forte necessita:");
    System.out.println(" - Possuir no mínimo 6 caracteres.");
    System.out.println(" - Conter no mínimo 1 digito.");
    System.out.println(" - Conter no mínimo 1 letra em minúsculo.");
    System.out.println(" - Conter no mínimo 1 letra em maiúsculo.");
    System.out.println(" - Conter no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+");
    System.out.println("  ");
    /**
     * Solicita que o usuário pressione a tecla Enter para limpar a tela e
     * continuar.
     */
    System.out.print("Pressione a tecla <Enter> para continuar.");

    Scanner entrada = new Scanner(System.in);
    while (true) {
      String readString = entrada.nextLine();

      /**
       * Enquanto for pressionada tecla diferente de Enter
       * o programa repete a mensagem solicitando ao usuário
       * que seja pressionada a tecla Enter.
       */
      if (!readString.equals("")) {
        limpaTela();
        System.out.print("Digite <Enter> para continuar.");
      } else {
        limpaTela();
        break;
      }
    }

    String senha = "";

    /** Chama o método que solicita a digitação da senha. */
    senha = solicitaSenha();
    System.out.print("\n");

    /**
     * Chama o método que verifica se a senha digitada é válida
     * Imprime mensagem informando os requisitos não atendidos
     * para uma senha forte.
     */
    if (!senhaValida(senha)) {
      System.out.println("A senha informada não é forte.\n");
    } else {
      System.out.println("Voce digitou uma senha forte.\n");
    }

    entrada.close();
  }

  public static void limpaTela() throws IOException, InterruptedException {
    /**
     * Caso o sistema operacional seja Windows, executa comando para limpar o
     * console.
     */
    if (System.getProperty("os.name").contains("Windows"))
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  }

  public static String solicitaSenha() {

    /** Instancia a classe Scanner para pegar a entrado do teclado */
    Scanner readString = new Scanner(System.in);

    System.out.println("Por favor, digite uma senha: ");

    String retorno = "";
    if (readString.hasNextLine()) {
      retorno = readString.next();
    }

    readString.close();
    /** Retorna a senha digitada. */
    return retorno;
  }

  public static boolean senhaValida(String senha) {
    boolean Valida = true;

    /**
     * Realiza as validações de acordo com os requisitos do site e retorna True ou
     * False.
     */
    if (senha.length() < 6) {
      System.out.println("A senha deve conter ao menos 6 caracteres.");
      Valida = false;
    }

    /**
     * Aqui foi utilizada uma expressão regular para uma lista de
     * caracteres Alfa maiúsculos.
     */
    String caracteresMaiusculos = "(.*[A-Z].*)";
    if (!senha.matches(caracteresMaiusculos)) {
      System.out.println("A senha deve conter ao menos um caracter maiusculo.");
      Valida = false;
    }
    /**
     * Aqui foi utilizada uma expressão regular para uma lista de
     * caracteres Alfa minúsculos.
     */
    String caracteresMinusculos = "(.*[a-z].*)";
    if (!senha.matches(caracteresMinusculos)) {
      System.out.println("A senha deve conter ao menos um caracter minusculo.");
      Valida = false;
    }
    /**
     * Aqui foi utilizada uma expressão regular para uma lista de caracteres
     * numericos.
     */
    String caracteresNumericos = "(.*[0-9].*)";
    if (!senha.matches(caracteresNumericos)) {
      System.out.println("A senha deve conter ao menos um número");
      Valida = false;
    }
    /**
     * Definição da lista de caracteres especiais
     * !@#$%^&*()-+
     */
    String caracteresEspeciais = "(.*[@,#,$,%,^,&,*,(,),-,+].*$)"; //
    if (!senha.matches(caracteresEspeciais)) {
      System.out.println(
          "A senha deve conter ao menos um dos seguintes caracteres especiais: @, #, $, %, ^, &, *, (, ), -, +");
      Valida = false;
    }

    return Valida;
  }
}
