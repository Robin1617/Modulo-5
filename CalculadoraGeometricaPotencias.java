import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraGeometricaPotencias {

    static Scanner scanner = new Scanner(System.in);
    static double[] resultados = new double[100];
    static int contador = 0;

    public static void main(String[] args) {
        boolean continuar = true;

        System.out.println("=== Calculadora Geométrica con Potencia y Métodos ===");

        while (continuar) {
            try {
                mostrarMenuFiguras();
                int figura = scanner.nextInt();

                mostrarMenuOperaciones();
                int operacion = scanner.nextInt();

                double resultado = 0;

                if (operacion == 3) {
                    resultado = calcularPotencia();
                } else {
                    resultado = procesarFigura(figura, operacion);
                }

                resultados[contador++] = resultado;
                System.out.printf(" Resultado: %.2f\n", resultado);

                System.out.print("\n¿Desea realizar otra operación? (s/n): ");
                char respuesta = scanner.next().toLowerCase().charAt(0);
                if (respuesta != 's') {
                    continuar = false;
                }

            } catch (InputMismatchException e) {
                System.out.println(" Error: Entrada no válida. Intente de nuevo.");
                scanner.nextLine(); 
            }
        }

        mostrarHistorial();
    }

   
    static void mostrarMenuFiguras() {
        System.out.println("\nFiguras disponibles:");
        System.out.println("1. Círculo");
        System.out.println("2. Cuadrado");
        System.out.println("3. Triángulo");
        System.out.println("4. Rectángulo");
        System.out.println("5. Pentágono");
        System.out.print("Seleccione una figura (1-5): ");
    }

    static void mostrarMenuOperaciones() {
        System.out.println("\nOperaciones:");
        System.out.println("1. Área");
        System.out.println("2. Perímetro");
        System.out.println("3. Potencia (base^exponente)");
        System.out.print("Seleccione la operación (1-3): ");
    }

   
    static double procesarFigura(int figura, int operacion) {
        switch (figura) {
            case 1:
                return circulo(operacion);
            case 2:
                return cuadrado(operacion);
            case 3:
                return triangulo(operacion);
            case 4:
                return rectangulo(operacion);
            case 5:
                return pentagono(operacion);
            default:
                System.out.println(" Figura no válida.");
                return 0;
        }
    }

    
    static double circulo(int operacion) {
        System.out.print("Ingrese el radio: ");
        double radio = scanner.nextDouble();
        return (operacion == 1) ?
                Math.PI * radio * radio :
                2 * Math.PI * radio;
    }

    static double cuadrado(int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = scanner.nextDouble();
        return (operacion == 1) ?
                lado * lado :
                4 * lado;
    }

    static double triangulo(int operacion) {
        if (operacion == 1) {
            System.out.print("Ingrese la base: ");
            double base = scanner.nextDouble();
            System.out.print("Ingrese la altura: ");
            double altura = scanner.nextDouble();
            return (base * altura) / 2;
        } else {
            System.out.print("Ingrese los tres lados (a b c): ");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            double c = scanner.nextDouble();
            return a + b + c;
        }
    }

    static double rectangulo(int operacion) {
        System.out.print("Ingrese la base: ");
        double base = scanner.nextDouble();
        System.out.print("Ingrese la altura: ");
        double altura = scanner.nextDouble();
        return (operacion == 1) ?
                base * altura :
                2 * (base + altura);
    }

    static double pentagono(int operacion) {
        System.out.print("Ingrese el lado: ");
        double lado = scanner.nextDouble();
        if (operacion == 1) {
            System.out.print("Ingrese el apotema: ");
            double apotema = scanner.nextDouble();
            return (5 * lado * apotema) / 2;
        } else {
            return 5 * lado;
        }
    }

    
    static double calcularPotencia() {
        System.out.print("Ingrese la base: ");
        int base = scanner.nextInt();
        System.out.print("Ingrese el exponente (entero ≥ 0): ");
        int exponente = scanner.nextInt();
        if (exponente < 0) {
            System.out.println(" El exponente debe ser mayor o igual a 0.");
            return 0;
        }
        return potenciaRecursiva(base, exponente);
    }

    static double potenciaRecursiva(int base, int exponente) {
        if (exponente == 0)
            return 1;
        else
            return base * potenciaRecursiva(base, exponente - 1);
    }

   
    static void mostrarHistorial() {
        System.out.println("\n Historial de Resultados:");
        for (int i = 0; i < contador; i++) {
            System.out.printf("Operación #%d: %.2f\n", i + 1, resultados[i]);
        }
        System.out.println("\nGracias por usar la Calculadora Geométrica Avanzada. ");
    }
}
