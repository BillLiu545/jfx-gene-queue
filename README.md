# jfx-gene-queue
This repos contains a genetic decoder simulated using JavaFX and the queue data structure.

# How does it work?
We start off at an empty queue, so the genetic string is decoded as "Empty". Genetic bases can be added based on input of A, T, C, or G. Since we are using a queue instead of a tree, we can only remove the head or first element. There is also a mutate option to mutate the entire gene with random bases, and a reset to clear the gene to set it to empty again.
