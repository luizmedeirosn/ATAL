import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Algorithm_CalculateTrapezeArea {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double MINOR_BASE = 0.0, MAJOR_BASE = 0.0, HEIGHT = 0.0;

        try {
            do {
                System.out.print("\nInforme o valor da base |MENOR|: ");
                MINOR_BASE = sc.nextDouble();
                
                System.out.print("Informe o valor da base |MAIOR|: ");
                MAJOR_BASE = sc.nextDouble();

                System.out.print("Informe a |ALTURA|: ");
                HEIGHT = sc.nextDouble();
                
                if (MINOR_BASE < 0 || MAJOR_BASE < 0 || HEIGHT < 0) {
                    System.out.println("Valores negativos são inválidos para o cálculo da área!");
                }
            } while (MINOR_BASE < 0 || MAJOR_BASE < 0 || HEIGHT < 0);
            System.out.println("A área do trapézio eh: " + (((MINOR_BASE+MAJOR_BASE)*HEIGHT)/2) + "m2");

        } catch (InputMismatchException e) {
            System.out.println("Valores válidos são necessários para os cálculos!");
        }

        sc.close();
    }
}