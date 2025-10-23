package SoftComputing;

import SoftComputing.Chromosomes.Chromosome;
import SoftComputing.Core.Population;
import SoftComputing.interfaces.SelectionStrategy;
import SoftComputing.Operators.selection.RouletteWheelSelection;
import SoftComputing.Operators.selection.TournamentSelection;
import java.util.List;
import java.util.stream.Collectors;

public class TestSelectionMethods {
    public static void main(String[] args) {
        int populationSize = 5;
        int chromosomeLength = 6;
        Population population = new Population(populationSize);
        population.intializeBinary(chromosomeLength);

        double fitness = 1.0;
        for (Chromosome c : population.getChromosoms()) {
            c.setFitness(fitness);
            fitness += 2.0;
        }

        System.out.println("Population Fitness Values: " +
                population.getChromosoms().stream()
                        .map(c -> String.valueOf(c.getFitness()))
                        .collect(Collectors.joining(", ")));

        SelectionStrategy rouletteSelector = new RouletteWheelSelection();
        int numberToSelect = 3;
        List<Chromosome> rouletteSelected = rouletteSelector.select(population.getChromosoms(), numberToSelect);

        System.out.println("\n=== Roulette Wheel Selection Test ===");
        for (int i = 0; i < rouletteSelected.size(); i++) {
            System.out.println("Selected Chromosome " + (i + 1) +
                    " Fitness = " + rouletteSelected.get(i).getFitness());
        }

        SelectionStrategy tournamentSelector = new TournamentSelection(3);
        List<Chromosome> tournamentSelected = tournamentSelector.select(population.getChromosoms(), numberToSelect);

        System.out.println("\n=== Tournament Selection Test ===");
        for (int i = 0; i < tournamentSelected.size(); i++) {
            System.out.println("Selected Chromosome " + (i + 1) +
                    " Fitness = " + tournamentSelected.get(i).getFitness());
        }
    }

}