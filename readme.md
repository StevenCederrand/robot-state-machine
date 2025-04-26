# robot-state-machine

A fun little java-kata. Here you are able to input commands, by file or interactively,
to make a small state machine traverse a 2D grid. An error is generated if the robot
is outside the defined boundaries, and a report is generated if the machine ends up in
a valid location.

## Pre-requisites
* `mvn`
* `java 17` older versions may work, but I haven't tested it.

## Running:
### CLI
Running the kata in the CLI is simple.
* Run `$ mvn package` from the project root

For running interactively:
``` sh
$ java -cp target/robot-state-machine-1.0-SNAPSHOT.jar com.sc.app.App -i
```

For running with file input:
``` sh
$ java -cp target/robot-state-machine-1.0-SNAPSHOT.jar com.sc.app.App -f ./resources/example.txt
```
### Testing
To run tests:
```sh
$ mvn test
```