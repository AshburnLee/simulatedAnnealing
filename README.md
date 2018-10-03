# simulatedAnnealing

This is the implementation of simulated annealing.
Tasks that are suitable for simulated annealing need have two components:
- solution space
- the corresponding energy

The first thing is set a initial temperature and the cooling rate,
which should be test for better suit the specific problem.
For instance, if a task is to find the global optimal in a large list of numbers, 
the solution space would be the index and the energy would be the value of each index.

-  *basicImplementation.java* is the simplest example of simulated annealing.

To be continu...

