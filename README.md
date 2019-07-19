This repository serves as an example of how to use ezAuton in FTC.

While initially designed for FRC (FIRST Robotics Competition), the modularity of ezAuton allows one to
easily use the library in FTC without adding any FRC-specific bloat to the program


[Link to ezAuton](https://github.com/ezAuton/ezAuton)

## What is ezAuton?

ezAuton is a library designed to improve the ease with which FIRST teams can write autonomous programs.
The library provides many useful features to facilitate this, such as built in odometry for tank drive robots,
and a built in implementation of the Pure Pursuit path tracking algorithm. Perhaps more importantly
for FTC, it provides _Actions_, an easy way to separate and reuse autonomous routines. It is similar
to the _Command_s found in the standard FRC library.


## How do I add ezAuton to my codebase?

TODO: Add complete instructions

Note: Usage of Git is strongly recommended.

1. `git submodule init`

2. `git submodule add https://github.com/ezAuton/ezAuton ezAuton`

3. gradle magic

4. Sync Project with Gradle Files in android studio