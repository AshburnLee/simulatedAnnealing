package myTSP;

import java.util.ArrayList;

import static myTSP.myTour.accumulatedDistance;
import static myTSP.myTour.randomPickSolution;
import static myTSP.myTour.showTour;

/**
 * Applying simulated annealing to solve the TSP
 *  layer 1: create the cities, tours(solution) and the distance(energy)
 *  layer 2: the simulated annealing
 */
public class simulatedAnnealingForTSP {

    public static void main(String[] args) {
        /* Create citied and tour and get the corresponding energy */
        // 1) create and add cities
        ArrayList<myCity> container = new ArrayList<>();

        myCity city1 = new myCity("1", 3,6);
        container.add(city1);
        myCity city2 = new myCity("2",2,7);
        container.add(city2);
        myCity city3 = new myCity("3",2,8);
        container.add(city3);
        myCity city4 = new myCity("4",1,4);
        container.add(city4);
        myCity city5 = new myCity("5",6,9);
        container.add(city5);
        myCity city6 = new myCity("6",12,3);
        container.add(city6);
        myCity city7 = new myCity("7",11,12);
        container.add(city7);
        myCity city8 = new myCity("8",6,15);
        container.add(city8);
        myCity city9 = new myCity("9",1,14);
        container.add(city9);
        myCity city10 = new myCity("10",9,16);
        container.add(city10);
        myCity city11 = new myCity("11",3,16);
        container.add(city11);
        myCity city12 = new myCity("12",5,15);
        container.add(city12);
        myCity city13 = new myCity("13",7,13);
        container.add(city13);
        myCity city14 = new myCity("14",8,12);
        container.add(city14);
        myCity city15 = new myCity("15",20,19);
        container.add(city15);


        // 3.5) show the default tour (solution)
        System.out.print("The original tour: \t");
        showTour(container);

        // 4) calculate distance (energy)
        double energy1 = accumulatedDistance(container);
        System.out.println(energy1);


        // 6) make a copy and random pick a tour (solution)
        ArrayList<myCity> nextSolution = randomPickSolution(container);
        System.out.print("The random tour: \t");
        showTour(nextSolution);

        // calculate the distance (energy)
        double energy2  = accumulatedDistance(nextSolution);
        System.out.println(energy2);



        /* Simulated Annealing Layer */
        double temp = 1000;
        double coolingRate = 0.005;

        // 1) random pick a solution as current
        System.out.println("Start from here: ");
        ArrayList<myCity> current = randomPickSolution(container);
        System.out.print("The random tour: \t");
        showTour(current);
        double currentEnergy = accumulatedDistance(current);


        int counter = 0;
        while (temp > 1 ) {
            //randomly pick a neighbour solution
            ArrayList<myCity> next = randomPickSolution(container);
            System.out.print("The random tour: \t");
            showTour(next);
            double nextEnergy = accumulatedDistance(next);

            //the change of energy
            double delta = currentEnergy - nextEnergy;

            //acceptance process
            //if next is a good solution, accept this next
            if(delta > 0) {
                //accept the energy
                currentEnergy = nextEnergy;
                //accept the tour
                current = next;

            }
            else if( Math.exp(delta/temp) > Math.random()) {
                currentEnergy = nextEnergy;
                current = next;

            }

            //cooling down
            temp *= 1 - coolingRate;
            counter += 1;
        }

        System.out.println();
        System.out.println("Searched :" + counter + " times");
        System.out.print("The final solution is: \t");
        showTour(current);
        System.out.println("The final energy is: \t"+ currentEnergy);



    }


}
