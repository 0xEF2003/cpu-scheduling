# Report Elias

For this report I read quickly through the git commits to remember what things I touched on.
We always worked together on the project over voice chat and tried to alternate a bit who was working on what.
Effort-wise I would say both were more or less equally engaged even though the statistics show unbalanced contribution (with regards to actual lines of code).
I believe the contributions looks skewed because I decided to go nuts on abstractions (which is not crucial to the task).

## What did I learn?
* I understood better how various cpu scheduling algorithms work now after we have made this project to simulate and visualize them.
* I learned how to use a progressbar library.
* Because this was a project with limited scope and good boundaries it was also a good excercise in applying best-practices with regards to programming.
* It was a good exercise in extending existing code base as we wanted to try implement more algorithms than necessary.

## What did I do?
* Created the repo and set up basic maven structure
* Found and initially integrated progressbar library
* Created ui functions for user input
* Made initial separation between views, logic, entities and enums
* Set up observer pattern for Process, ProcessEventPublisher and ProcessView
* Integrated Round Robin into general application logic
* Implemented calculations for average waiting time and average turn around time
* Generally refactored much code to attempt maintaining high cohesion and low coupling
* Added ASCII Art ;)
