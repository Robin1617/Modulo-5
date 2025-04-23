import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraGeometricaAvanzada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] resultados = new double[100]; 
        int contador = 0;
        boolean continuar = true;

        System.out.println("=== Calculadora Geométrica Avanzada ===");

        while (continuar) {
            try {
                System.out.println("\nFiguras disponibles:");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.print("Seleccione una figura (1-5): ");
                int figura = scanner.nextInt();

                System.out.println("\nOperaciones:");
                System.out.println("1. Área");
                System.out.println("2. Perímetro");
                System.out.print("Seleccione la operación (1-2): ");
                int operacion = scanner.nextInt();

                double resultado = 0;

                switch (figura) {
                    case 1:
                        System.out.print("Ingrese el radio: ");
                        double radio = scanner.nextDouble();
                        resultado = (operacion == 1) ?
                            Math.PI * radio * radio :
                            2 * Math.PI * radio;
                        break;

                    case 2:
                        System.out.print("Ingrese el lado: ");
                        double lado = scanner.nextDouble();
                        resultado = (operacion == 1) ?
                            lado * lado :
                            4 * lado;
                        break;

                    case 3:
                        if (operacion == 1) {
                            System.out.print("Ingrese la base: ");
                            double base = scanner.nextDouble();
                            System.out.print("Ingrese la altura: ");
                            double altura = scanner.nextDouble();
                            resultado = (base * altura) / 2;
                        } else {
                            System.out.print("Ingrese los tres lados (a b c): ");
                            double a = scanner.nextDouble();
                            double b = scanner.nextDouble();
                            double c = scanner.nextDouble();
                            resultado = a + b + c;
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese la base: ");
                        double baseR = scanner.nextDouble();
                        System.out.print("Ingrese la altura: ");
                        double alturaR = scanner.nextDouble();
                        resultado = (operacion == 1) ?
                            baseR * alturaR :
                            2 * (baseR + alturaR);
                        break;

                    case 5:
                        System.out.print("Ingrese el lado: ");
                        double ladoP = scanner.nextDouble();
                        if (operacion == 1) {
                            System.out.print("Ingrese el apotema: ");
                            double apotema = scanner.nextDouble();
                            resultado = (5 * ladoP * apotema) / 2;
                        } else {
                            resultado = 5 * ladoP;
                        }
                        break;

                    default:
                        System.out.println(" Figura no válida.");
                        continue;
                }

               
                resultados[contador++] = resultado;
                System.out.printf(" Resultado: %.2f\n", resultado);

               
                System.out.print("\n¿Desea realizar otra operación? (s/n): ");
                char respuesta = scanner.next().toLowerCase().charAt(0);
                if (respuesta != 's') {
                    continuar = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Intente de nuevo.");
                scanner.nextLine(); // Limpiar buffer
            }
        }

        
        System.out.println("\n Historial de Resultados:");
        for (int i = 0; i < contador; i++) {
            System.out.printf("Operación #%d: %.2f\n", i + 1, resultados[i]);
        }

        System.out.println("\nGracias por usar la Calculadora Geométrica Avanzada. ");
    }
}
