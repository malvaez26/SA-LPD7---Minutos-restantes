import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] diasSemana = {"lunes", "martes", "miércoles", "jueves", "viernes"};

        String diaSemana;
        do {
            System.out.println("Ingrese un día de la semana (lunes a viernes):");
            diaSemana = scanner.nextLine().toLowerCase();
        } while (!esDiaSemanaValido(diaSemana, diasSemana));

        int hora, minutos;
        do {
            System.out.println("Ingrese la hora (0-23):");
            hora = scanner.nextInt();
            System.out.println("Ingrese los minutos (0-59):");
            minutos = scanner.nextInt();
        } while (!esHoraValida(hora) || !esMinutosValidos(minutos));

        
        int minutosHastaFinSemana = calcularMinutosHastaFinSemana(diaSemana, hora, minutos);

       
        System.out.println("Faltan " + minutosHastaFinSemana + " minutos para el fin de semana.");

        scanner.close();
    }

    public static boolean esDiaSemanaValido(String dia, String[] diasSemana) {
        for (String d : diasSemana) {
            if (dia.equals(d)) {
                return true;
            }
        }
        System.out.println("Día de la semana inválido. Por favor, ingrese un día de la semana válido.");
        return false;
    }

    public static boolean esHoraValida(int hora) {
        if (hora >= 0 && hora <= 23) {
            return true;
        }
        System.out.println("Hora inválida. Por favor, ingrese una hora válida (0-23).");
        return false;
    }

    
    public static boolean esMinutosValidos(int minutos) {
        if (minutos >= 0 && minutos <= 59) {
            return true;
        }
        System.out.println("Minutos inválidos. Por favor, ingrese minutos válidos (0-59).");
        return false;
    }

    
    public static int calcularMinutosHastaFinSemana(String diaSemana, int hora, int minutos) {
        
        int diaNumero = 0;
        switch (diaSemana) {
            case "lunes":
                diaNumero = 0;
                break;
            case "martes":
                diaNumero = 1;
                break;
            case "miércoles":
                diaNumero = 2;
                break;
            case "jueves":
                diaNumero = 3;
                break;
            case "viernes":
                diaNumero = 4;
                break;
        }

        
        int minutosHastaViernes = (4 - diaNumero) * 24 * 60 + (15 - hora) * 60 - minutos;

        if (minutosHastaViernes < 0) {
            minutosHastaViernes += 7 * 24 * 60;
        }

        return minutosHastaViernes;
    }
}
