# Project Description
This project is to run Conway's GameOfLife from one pattern user input.
The game is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves, or, for advanced players, by creating patterns with particular properties. 
## Dev Environment Setup for OS X.
* Java v10
```
$ brew cask install java
```
At present(22/08/2018) it will directly install java 10. Please verify the version if you are using it later.

[To install java please refer](https://docs.oracle.com/javase/10/install/overview-jdk-10-and-jre-10-installation.htm)
* Gradle v5.0

[To install gradle please refer](https://gradle.org/install/)

## Test instructions
```
$ ./gradlew clean test
```

## Build instructions
```
$ ./gradlew build
```

## Code Coverage instructions
```
$ ./gradlew clean build jacocoTestReport
```

## Code complexity
```
$ ./gradlew clean build check
```

### Author
Syarif Hidayatullah
