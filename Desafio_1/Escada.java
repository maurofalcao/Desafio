package Desafio.Desafio_1;

public class Escada {
  /** Propriedade da classe Escada */
  int altura = 0;

  /** Método para realizar a montagem do degrau de acordo com a altura e a base */
  String MontarDegrau(int base) {
    String retorno = "";

    /** Percorre o laço para montar a base utilizando espaços e asteriscos */
    for (int n = 1; n <= altura; n += 1) {
      if (n <= (altura - base)) {
        retorno = retorno + " ";
      } else {
        retorno = retorno + "*";
      }
    }
    /** Retorna a linha formatada com os caracteres que forma a base do degrau */
    return retorno;
  }

}
