# Target circle

This project was first written for an in-game event for my free-company (more known as Guild) in Final Fantasy XIV.

This was first thought for the "secret-santa" event.
Each participant get a "child"/target in the other participants they have to give a prensent to.

Contrains
* Each participant only get one target (as secret santa)
* Each participant are given one santa they get a gift from

Option:
* The target cannot be your santa

Other:
* The code must be easy to read for a non-tech
* The code should be easy to update for future actions (like having 2 targets or 2 santas or even a custom list for each participants...)

## Class from Library
* List
  * ArrayList
* Map
  * TreeMap


## Tests
Should add a test to check syntax in the future...

## Execution
Atm run the Java code (`java -jar target.jar`) in a console and copy/paste output in the `graphviz/files/test.dot` then run 
* `graphviz/files/generate.sh` if you have graphviz installed
* `graphviz/docker-generate.sh` if not (check image name...)

Currently the loops are wrong (it couldbe a loop with less than 3 persons)...

