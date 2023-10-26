# Welcome to the SwerveVIsualizer documentation

This repository serves as the source code for rocketbooster1000's swerve visualizer.
Swerve refers to a type of drivetrain typically used in robotics where each wheel is indpendently steered and driven. 
(Think about an office chair, thats a swerve drive!)
The visualizer offers a way to see how the wheels of a swerve drive move under certain inputs

## Using the program

Visit the release page and download the latest release jar. To use older releases navigate to the releases folder in the source code.
After launching the program a window will appear with a red square in the middle. This square represents the swerve base, with the front left wheel in the top left.
> Controls for the visualizer are as follows:
> - `w` key is forward
> - `s` key is back
> - `a` key is left
> - `d` key is right
> - `j` key is to turn left
> - `l` key is to turn right
> - `b` key will reset the drivetrain to a heading of 0 (more on that below)

When using the visualizer blue arrows will appear out of the corner of the swerve base, which represent the indicated power and angle of each module. 

### Note about heading and oreintation

---

**This visualizer uses a field centric control scheme but visualizes from a robot centric view.** For example after turning 90 degrees and then going forward, visualizer will show arrows to the side, however from the field view this is still forward. For more information visit [here](https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html)

## Using source code

Source code is available by cloning this repository or downloading the release. Anything under `graphics` is meant for this visualizer's grpahics only, antyhing under `model` or `util` is intended to be used in other programs that may look to utilize swerve.

Alternatively you can also drag the jar file into the lib folder of your project to access its classes.

Notes about contributing will come at a later date.

## v0.1.1

The following changes are present in this patch:
- Separated `graphics` and `model` to be usable in other applications.
- Added runnable file to release
- Added documentation
- Small bug fixes and improvements

## v0.1.0-alpha

This is the intitial release of this project that is not ready for production:
- Only source code is available
- No documentation is offered
- Program structure is spaghetti and not reusable


