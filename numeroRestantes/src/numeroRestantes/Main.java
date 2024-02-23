package numeroRestantes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner scanner = new Scanner(System.in)) {
			String diaSemana;
			do {
			    System.out.print("día de la semana (lunes a viernes): ");
			    diaSemana = scanner.nextLine().toLowerCase();
			} while (!validarDiaSemana(diaSemana));

			int hora, minutos;
			do {
			    System.out.print("Ingrese la hora (0-23): ");
			    hora = scanner.nextInt();
			    System.out.print("Ingrese los minutos (0-59): ");
			    minutos = scanner.nextInt();
			} while (!validarHora(hora) || !validarMinutos(minutos));

			int minutosFaltantes = calcularMinutosFaltantes(diaSemana, hora, minutos);

			System.out.println("Faltan " + minutosFaltantes + " minutos para el fin de semana.");
		}
    }

    public static boolean validarDiaSemana(String diaSemana) {
        return diaSemana.equals("lunes") || diaSemana.equals("martes") || diaSemana.equals("miércoles") ||
                diaSemana.equals("miercoles") || diaSemana.equals("jueves") || diaSemana.equals("viernes");
    }

    public static boolean validarHora(int hora) {
        return hora >= 0 && hora <= 23;
    }

    public static boolean validarMinutos(int minutos) {
        return minutos >= 0 && minutos <= 59;
    }

    public static int calcularMinutosFaltantes(String diaSemana, int hora, int minutos) {
        int minutosHastaFinSemana = 0;
        switch (diaSemana) {
            case "lunes":
                minutosHastaFinSemana += (23 - hora) * 60 + (60 - minutos);
                minutosHastaFinSemana += 24 * 60 * 4; 
                break;
            case "martes":
                minutosHastaFinSemana += (23 - hora) * 60 + (60 - minutos);
                minutosHastaFinSemana += 24 * 60 * 3;
                break;
            case "miércoles":
            case "miercoles":
                minutosHastaFinSemana += (23 - hora) * 60 + (60 - minutos);
                minutosHastaFinSemana += 24 * 60 * 2;
                break;
            case "jueves":
                minutosHastaFinSemana += (23 - hora) * 60 + (60 - minutos);
                minutosHastaFinSemana += 24 * 60; 
                break;
            case "viernes":
                if (hora < 15) {
                    minutosHastaFinSemana += (14 - hora) * 60 + (60 - minutos);
                }
                break;
        }
        return minutosHastaFinSemana;

	}

}
