# Homework 3 - Part 2

## Date: 5/16/2020

## Final Class Diagram

![FinalClassDiagram](images/FinalClassDiagram.PNG)

## Final Sequence Diagram

![FinalSequenceDiagram](images/FinalSequenceDiagram.PNG)

## Questions

### To what extent did the peer’s design function?

I was unable to get the final design to properly function. The findShortestPath(Graph g) did not work because the Algorithms had no way of pulling off the needed
data from the Graph objects, specifically the starting node for the graphs that use list nodes. There is no way of accessing that value from the graph for lists, and therefore
there is no way of actually running the algorithm for the list implementations because the list needs the head node. However, the array implementations worked.
One issue that the design didn't mention was the need for there to be classes that represented array algorithms and list algorithms, which were not included in the
class diagram.

### To what extent did the design favor composition over inheritance?

There was no favoring composition over inheritance because there were no instances where the design composes behavior of objects.

### To what extent did the design program to interfaces?

The design does a good job programming to interfaces by using the ShortestPathAlgorithm class to inherit the responsibility of finding the shortestPathAlgorithm.
However it didn't really make sense for that to be the different algorithms to implement that class since the algorithms shouldn't be having running a method to find
the shortestPathAlgorithm, that should instead be done in the super class.

### To what extent was the design loosely coupled? Were there any trainwrecks?

The design did a good job by loosely coupling the classes and not having a lot of dependencies between the classes. Additionally, there were no present trainwrecks
with the design.

### To what extent was the design cohesive? Did it violate Single Responsibility Principle anywhere?

### Was there anything that your peer’s design/notebook lacked that would have made life easier for you?

### In retrospect: was there anything that your notebook was lacking that would have made life easier for someone else?