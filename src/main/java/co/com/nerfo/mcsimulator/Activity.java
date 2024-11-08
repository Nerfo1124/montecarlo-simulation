package co.com.nerfo.mcsimulator;

import java.util.Random;

public class Activity {
    private String name;
    private double minDuracion;
    private double normDuracion;
    private double maxDuracion;

    public Activity(String name, double minDuracion, double normDuracion, double maxDuracion) {
        this.name = name;
        this.minDuracion = minDuracion;
        this.normDuracion = normDuracion;
        this.maxDuracion = maxDuracion;
    }

    public String getName() {
        return name;
    }

    public double simularDuracion() {
        Random random = new Random();
        double f = (normDuracion - minDuracion) / (maxDuracion - minDuracion);
        double rand = random.nextDouble();

        if (rand < f) {
            return minDuracion + Math.sqrt(rand * (maxDuracion - minDuracion) * (normDuracion - minDuracion));
        } else {
            return maxDuracion - Math.sqrt((1 - rand) * (maxDuracion - minDuracion) * (maxDuracion - normDuracion));
        }
    }
}
