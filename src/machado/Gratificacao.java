package machado;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.*;
import java.util.Scanner;

public class Gratificacao {

   public static void main(String[] args) {
      Scanner ler = new Scanner(System.in);

      String arquivo = "C:\\Users\\Note\\Documents\\NetBeansProjects\\Machado\\src\\machado\\gratificacao.fcl";
      FIS fis = FIS.load(arquivo, true);

      if (fis == null) {
         System.out.println("ARQUIVO ERRADO");
         System.exit(1);
      }
      System.out.println("Aluno: Maicon Henrique Cordeiro Machado R.A->11716434");

      System.out.println("Quantidade a anos de capacitação (0-15) ->");
      double capacitacao = ler.nextDouble();
      System.out.println("");

      System.out.println("Quantidade de anos de experiência (0-30) ->");
      double experiencia = ler.nextDouble();
      System.out.println("");

      FunctionBlock fb = fis.getFunctionBlock(null);

      fb.setVariable("experiencia", experiencia);
      fb.setVariable("capacitacao", capacitacao);

      fb.evaluate();

      System.out.printf("O valor da Gratificação será de R$ %9.2f \n",
              fb.getVariable("gratificacao").getValue());
      System.out.println("\nApresentaçãoo das regras\n");

      for (Rule r
              : fis.getFunctionBlock("gratificoes").getFuzzyRuleBlock("No1").getRules()) {
         System.out.println(r);
      }

   }

}
