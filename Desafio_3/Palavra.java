package Desafio.Desafio_3;

public class Palavra {

  String palavra;
  int tamanho;
  String reverso;
  String permuta = "";

  Palavra(String palavraCriada) {
    palavra = palavraCriada;
    tamanho = palavraCriada.length();

    reverso = new StringBuilder(palavra).reverse().toString();

  }

  // Método para realizar permuta dos caracteres
  // montando uma lista de anagramas deste conjunto
  public void MontaListaPermuta(String str1,
      String str2) {

    // Se a string estiver varia
    if (str1.length() == 0) {
      permuta = permuta + str2 + ";";
    }

    // Array com 26 posições do tipo boolean.
    // Por default as posições tem o valor false.
    // É moficado para true quando um caracter alfa
    // é utilizado.
    boolean alfa[] = new boolean[26];

    for (int i = 0; i < str1.length(); i++) {

      // Caracter de str da posição i.
      char ch = str1.charAt(i);

      // Demais caracteres com exceção do caracter da posição i.
      String resto = str1.substring(0, i) +
          str1.substring(i + 1);

      // Chamada recursiva do método para continuar
      // montando a cadeia de permuta.
      if (alfa[ch - 'a'] == false)
        MontaListaPermuta(resto, str2 + ch);
      alfa[ch - 'a'] = true;
    }

  }

}
