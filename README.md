# NOTICE

Documentation is in next section, thank you for taking interest in this project.

## Current version information

| Version Type | Latest Version | Branch |
|--------------|----------------| ------ |
| Latest Release | 0.2.0 | main |
| Pre | v0.3.0-alpha1 | v0.3.0-dev |

## Pre-release

v0.2.0 is in alpha pre-release. You can download and test it from the releases page under the latest pre-release.
Some features of pre-release include showable heading and changeable drive constants.

For more information look at the releases page or visit the dev branch README

---

# Welcome to the Swerve Visualizer documentation

This repository serves as the source code for rocketbooster1000's swerve visualizer.
Swerve refers to a type of drivetrain typically used in robotics where each wheel is indpendently steered and driven. 
(Think about an office chair, thats a swerve drive!)
The visualizer offers a way to see how the wheels of a swerve drive move under certain inputs

## Using the program

Visit the release page and download the latest release jar. To use older releases navigate to the releases folder in the source code.
After launching the program a window will appear with a red square in the middle. This square represents the swerve base, with the front left wheel in the top left.

Controls for the visualizer are as follows:
- `w` key is forward
- `s` key is back
- `a` key is left
- `d` key is right
- `j` key is to turn left
- `l` key is to turn right
- `b` key will reset the drivetrain to a heading of 0 (more on that below)

When using the visualizer blue arrows will appear out of the corner of the swerve base, which represent the indicated power and angle of each module. 

The heading of the swerve base along with rotation speed will be displayed at the bottom of the screen.
You may change the rotation speed and heading as you wish, then click the `OK` button to confirm.

### Note about heading and oreintation

**This visualizer uses a field centric control scheme but visualizes from a robot centric view.** For example after turning 90 degrees and then going forward, visualizer will show arrows to the side, however from the field view this is still forward. For more information visit [here](https://gm0.org/en/latest/docs/software/tutorials/mecanum-drive.html). Both rotation speed and heading increase in the clockwise direction.

## Using source code

There are a couple ways to use the source code of this project:
- If you are a git user, you can clone the most current version of the repository. **This is not necessarily equivalent to the latest release**:
    `git clone https://github.com/rocketbooster1000/SwerveVisualizer.git`
- Alternatively you can download the latest release source code by going to the release pages.
- If you prefer, you can also download the project from the main repository page by clicking the green `Code` drop down arrow, and then click `Download Zip` to minimize download size. **This is not necessarily equivalent to the latest release**
- You can also drag the latest release jar file into your project library

### Using the project with an IDE

Sometimes your IDE will generate files specific to that development environment, if you wish to contribute or use as a version control the best practice is to modify the `.gitignore` file:
- A `*.` followed by a file extension will omit any files with that extension.
    - For example: `*.class` will omit any `.class` files that the Java compiler produces
- A `/` preceeded by a folder directory will omit the entire folder
    - For example: `.vscode/` will omit the entire `.vscode` folder that VS Code will generate for Java Projects
- Putting the file name in will omit that singular file
    - For example: `settings.json` will omit only the `settings.json` file
- Putting a `!` followed by a file name will add that file back into git tracking
    - For example: If `*.json` was already in the `.gitignote` but a file `test.json` is wanted on git, `!test.json` will add that file back to git
- Any new line is a new statement

## Contributing

Notes about contributing will come at a later date.

---

# Release Information

## v0.2.0 (122723-212406)

Full release for version 0.2.0

New features:
- Revamped UI
    - Editable rotation speed
    - Editable/Displayable heading
 - Added a new `getFormatHeading()` method for easy displayable heading conversion

Changes:
- Moved from `KeyListener` to `KeyBindings`
- Folder structure now under `src/main/java` to align with maven conventions

Bug fixes:
- Fixed a bug (Issue #2) where caps lock would disable movement
- Fixed an issue where incompatible Java versions were not disclosed 

New Controls - Controls are same for both `Rotation Speed` and `Heading`:
- Click on the text box with mouse cursor
- Delete existing values
- Put in desired values
- Press ok

Note: Invalid inputs will revert to previous inputs. Both `Rotation Speed` and `Heading` are in units of degrees and increase in the **clockwise** direction.

## v0.1.2 (10272023-140817)

RECOMMENDED - This is a recommended patch that fixes the following bugs:
- Window title issue
- Rotation direction was inverted

## v0.1.1 (10262023-130811)

The following changes are present in this patch:
- Separated `graphics` and `model` to be usable in other applications.
- Added runnable file to release
- Added documentation
- Small bug fixes and improvements

## v0.1.0-alpha (10252023-151347)

This is the intitial release of this project that is not ready for production:
- Only source code is available
- No documentation is offered
- Program structure is spaghetti and not reusable

Sidenote: this version never made it past pre-release thus only the alpha release notes are provided
