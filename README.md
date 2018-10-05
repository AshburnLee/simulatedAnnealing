# simulatedAnnealing

Solving Travel Salesman Problem (TSP) using simulated annealing.
Tasks that are suitable for simulated annealing need have two components:
- solution space. In thsi case, each tour is a solution
- the corresponding energy. In this case, the total distance of a tour is the energy of that tour

The content of this project:
- *simpleSimulatedAnnealling.java* is the simplest example of simulated annealing.
- *myCity.java* is the data type representing the cities.
- *myTour.java* manages tour, for instance, calculate the distance; select the next tour...
- *simulateAnnealingForTSP.java* applies simulate annealing to TSP.

The results are pretty satisfying, it finds a good enough solution only a few steps of searching, which is significant because, for a TSP with 15 cities, the solution space has (15! = 1.307674368×10¹²) solitions, while using SA, in this case, it took aroubd 1000 steps to find a good solution. >>>>>>>>>>>>>>>>>>>

