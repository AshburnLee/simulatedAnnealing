package myTSP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class simpleSimulatedAnnealing {

    /**
     * simulated annealing algorithm:
     * @param args:
     */
    public static void main(String[] args) {

        Double[] a = {1509.0, 1391.0, 1393.0, 1449.0, 1446.0, 1480.0, 1365.0, 1383.0, 1468.0, 1486.0, 1416.0, 1461.0, 1399.0, 1358.0, 1463.0};

        //convert a array to an ArrayList
        ArrayList<Double> al = new ArrayList<Double>(Arrays.asList(a));

        // init the temperature and cooling rate
        double temp = 200;
        double coolingRate = 0.02;

        //randomly pick a initial solution:
        double current = al.get(new Random().nextInt(al.size()));

        //counter
        int count = 0;
        // loop until the stop condition is met
        while(temp > 1 && al.size() > 0) {

            //show info
            showArray(al);
            System.out.println("Temperature: " + temp);
            System.out.println("current:     " + current);

            //randomly pick a neighbor solution and remove it from list
            double next = al.get(new Random().nextInt(al.size()));
            System.out.println("next:        " + next);
//            removeElementInArray(al, next);


            //the change of energy
            double delta = current - next;

            //acceptance process
            // if next is a good solution, accept the next,
            if(delta > 0)
                current = next;

            // if delta is not a good solution, calculate following below and
            // then accept the next
            else if( Math.exp(delta/temp) > Math.random())
                current = next;

            temp *= 1 - coolingRate;
            count +=1;


        }
        System.out.println();
        System.out.println("The final solution: "+current);
        System.out.println(count + " times of executions");

    }

    private static void removeElementInArray(ArrayList<Double> arr, double elem) {

        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == elem){
                arr.remove(i);
                break;
            }
        }
    }

    private static void showArray(ArrayList<Double> arr) {
        for(int i = 0; i < arr.size(); i++){
            System.out.print(" " + arr.get(i));
        }
        System.out.println();
    }
}
