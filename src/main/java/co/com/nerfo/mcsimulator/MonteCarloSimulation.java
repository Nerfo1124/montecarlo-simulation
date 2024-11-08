package co.com.nerfo.mcsimulator;

import java.util.ArrayList;
import java.util.List;

public class MonteCarloSimulation {
    public static void main(String[] args) {
        // Crear actividades con duraciones mínima, más probable y máxima
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A", 1, 4, 7));
        activities.add(new Activity("B", 4, 7, 10));
        activities.add(new Activity("C", 3, 6, 9));
        activities.add(new Activity("D", 5, 8, 11));

        // Número de simulaciones
        int simulations = 10000;
        List<Double> totalDurations = new ArrayList<>();

        // Realizar la simulación de Monte Carlo
        for (int i = 0; i < simulations; i++) {
            double totalDuration = 0;
            for (Activity activity : activities) {
                totalDuration += activity.simularDuracion();
            }
            totalDurations.add(totalDuration);
        }

        // Calcular estadísticas básicas de las duraciones simuladas
        double averageDuration = totalDurations.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double maxDuration = totalDurations.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        double minDuration = totalDurations.stream().mapToDouble(Double::doubleValue).min().orElse(0);

        // Mostrar resultados
        System.out.println("Duración promedio del proyecto: " + averageDuration);
        System.out.println("Duración máxima del proyecto: " + maxDuration);
        System.out.println("Duración mínima del proyecto: " + minDuration);

        // Calcular percentil 90 (tiempo en el cual hay un 90% de probabilidad de completar el proyecto)
        totalDurations.sort(Double::compareTo);
        double percentile90 = totalDurations.get((int) (0.9 * simulations) - 1);
        System.out.println("Percentil 90 (duración en la cual el proyecto tiene un 90% de probabilidad de completarse): " + percentile90);
    }
}
