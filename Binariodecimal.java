import java.util.Scanner;


public class Binariodecimal {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Ingrese un número binario (terminado en 'b') o decimal (terminado en 'd') (o 'exit' para salir):");
            String input = scanner.nextLine();


            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Saliendo del programa...");
                break;
            }


            char suffix = input.charAt(input.length() - 1);


            if (suffix == 'b') {
                // Si es un número binario
                String binaryNumber = input.substring(0, input.length() - 1);
                if (binaryNumber.matches("[01]+")) {
                    if (binaryNumber.length() < 16) {
                        binaryNumber = String.format("%16s", binaryNumber).replace(' ', '0');
                    }


                    System.out.println("Número binario con 16 bits: " + binaryNumber);


                    char signBit = binaryNumber.charAt(0);
                    System.out.println("Bit de signo: " + signBit);


                    String mantisa = binaryNumber.substring(1);
                    System.out.println("Mantisa: " + mantisa);


                    int equivalentedecimal = Integer.parseInt(binaryNumber, 2);
                    System.out.println("Equivalente decimal: " + equivalentedecimal);
                } else {
                    System.out.println("Entrada inválida. Ingrese un número binario válido.");
                }
            } else if (suffix == 'd') {
                // Si es un número decimal
                String decimalNumber = input.substring(0, input.length() - 1);
                int decimal = Integer.parseInt(decimalNumber);
                char sign = decimal >= 0 ? '+' : '-';
                System.out.println("Signo del número decimal: " + sign);


                String binariorespectivo = String.format("%15s", Integer.toBinaryString(Math.abs(decimal))).replace(' ', '0');
                String binarioCompleto = (sign == '+' ? "0" : "1") + binariorespectivo;
                System.out.println("Número decimal en formato binario de 16 bits: " + binarioCompleto);


                char signo = binarioCompleto.charAt(0);
                System.out.println("Bit de signo: " + signo);


                String mantisa = binarioCompleto.substring(1);
                System.out.println("Mantisa: " + mantisa);
            } else {
                System.out.println("Entrada inválida. Ingrese un número decimal o binario válido.");
            }
        }
        scanner.close();
  }
}