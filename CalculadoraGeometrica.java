import java.util.Scanner;

public class CalculadoraGeometrica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calculadora Geométrica ===");
        System.out.println("Figuras disponibles:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");

        System.out.print("Seleccione una figura (1-5): ");
        int figura = scanner.nextInt();

        System.out.println("\nOperaciones disponibles:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");

        System.out.print("Seleccione una operación (1-2): ");
        int operacion = scanner.nextInt();

        double resultado = 0;

        switch (figura) {
            case 1:
                System.out.print("Ingrese el radio: ");
                double radio = scanner.nextDouble();
                if (operacion == 1) {
                    resultado = Math.PI * radio * radio;
                    System.out.printf("Área del círculo: %.2f\n", resultado);
                } else {
                    resultado = 2 * Math.PI * radio;
                    System.out.printf("Perímetro del círculo: %.2f\n", resultado);
                }
                break;

            case 2:
                System.out.print("Ingrese el lado: ");
                double lado = scanner.nextDouble();
                if (operacion == 1) {
                    resultado = lado * lado;
                    System.out.printf("Área del cuadrado: %.2f\n", resultado);
                } else {
                    resultado = 4 * lado;
                    System.out.printf("Perímetro del cuadrado: %.2f\n", resultado);
                }
                break;

            case 3:
                if (operacion == 1) {
                    System.out.print("Ingrese la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingrese la altura: ");
                    double altura = scanner.nextDouble();
                    resultado = (base * altura) / 2;
                    System.out.printf("Área del triángulo: %.2f\n", resultado);
                } else {
                    System.out.print("Ingrese los tres lados (a b c): ");
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    double c = scanner.nextDouble();
                    resultado = a + b + c;
                    System.out.printf("Perímetro del triángulo: %.2f\n", resultado);
                }
                break;

            case 4:
                System.out.print("Ingrese la base: ");
                double baseR = scanner.nextDouble();
                System.out.print("Ingrese la altura: ");
                double alturaR = scanner.nextDouble();
                if (operacion == 1) {
                    resultado = baseR * alturaR;
                    System.out.printf("Área del rectángulo: %.2f\n", resultado);
                } else {
                    resultado = 2 * (baseR + alturaR);
                    System.out.printf("Perímetro del rectángulo: %.2f\n", resultado);
                }
                break;

            case 5:
                if (operacion == 1) {
                    System.out.print("Ingrese el lado del pentágono: ");
                    double ladoP = scanner.nextDouble();
                    System.out.print("Ingrese el apotema: ");
                    double apotema = scanner.nextDouble();
                    resultado = (5 * ladoP * apotema) / 2;
                    System.out.printf("Área del pentágono: %.2f\n", resultado);
                } else {
                    System.out.print("Ingrese el lado del pentágono: ");
                    double ladoP = scanner.nextDouble();
                    resultado = 5 * ladoP;
                    System.out.printf("Perímetro del pentágono: %.2f\n", resultado);
                }
                break;

            default:
                System.out.println("Figura no válida.");
        }
    }
}
