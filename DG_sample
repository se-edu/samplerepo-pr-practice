# Developer Guide

## Acknowledgements

{list here sources of all reused/adapted ideas, code, documentation, and third-party libraries -- include links to the original source as well}

## Design

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### Architecture

"Diagram Here"

The Diagram above explains how the App is designed and will function

Given below we have a quick overview of all the main components of Gordon as well as how these pieces interact with each other

*Main Components*

`Main` contains both `main` and `run`. It is responsible for:

1. Once the App is launched, `main` will call `run` to initialize the necessary components for the App to function properly
2. On exit, the App will print the corresponding messages and execute the necessary cleanup methods.

The App contains the `command`, `exception`, `kitchen`, and `util` packages that represent a collection of various different classes that are deal with different parts of the functions of the App

1. `command`: Contains all the classes that deal with the inputs that the user is able to make.
2. `exception`: Contains all the Gordon specific exceptions that are used throughout the App
3. `kitchen`: Contains the classes that deal with the management of the cookbook
4. `util`: Contains the classes that deal with the functionality of the App

*How do these components interact with each other*

The Sequence Diagram below will show how the components interact with each other for the scenario where the user issues the command `delete 1`.

"Diagram Here"

### Kitchen component

### Parser component

### Command component

### Storage component

## Implementation

This section describes some noteworthy details on how certain features are implemented.

### XYZ

## Product scope
### Target user profile

* Nus Students who stay in a Hall
* Cooks on a regular basis  
* Has Ingredients for cooking readily available
* Is familiar with a command line interface  
* Can type relatively fast  
* Prefers a desktop application to a mobile application

### Value proposition

A digital cookbook that works in Command-Line Interface that can provide all the necessary functions faster than from a typical mouse/GUI drive App

## User Stories

|Priority|Version| As a ... | I want to ... | So that I can ...|
|--------|--------|----------|---------------|------------------|
|***|v1.0|new user|see usage instructions|refer to them when I forget how to use the application|
|***|v1.0|user|exit the program|do other tasks in the command line|
|***|v1.0|user|check my stored recipes|refer to them while cooking|
|***|v1.0|user|add recipes to my cookbook|try them in the future|
|***|v1.0|user|delete recipes from my cookbook|remove recipes I'm no longer interested in|
|**|v2.0|disorganised user|find recipes by ingredient|see what recipes I can make with the food in my pantry|
|**|v2.0|user|save and load my recipes from memory|refer to them whenever I want to|
|**|v2.0|health-conscious user|set the amount of calories a recipe has|choose the healthier option|
|*|v2.0|organized user|add tags to a recipe|classify my recipes however I feel like|
|*|v2.0|developer|add my own functionality to Gordon in a modular fashion|improve the app to my needs|

## Use Cases

**Use case: `help`**

**MSS:**
1. User opens Application
2. User does not know the commands
3. Gordon provides a list of commands
4. User can now use the App

Use case ends.

**Use case: `exit`**

**MSS:**
1. User requests to exit program
2. Program exits.

Use case ends

**Use case: `check`**

**MSS:**
1. User requests to check recipes
2. Gordon shows a list of all currently stored recipes

Use case ends.

**Extensions** 
* The list is empty.
  * Use case ends.

**Use case: `add`**

**MSS:**
1. User requests to add a recipe to Gordon
2. User inputs the necessary commands
3. Gordon adds the recipe to the cookbook

Use case ends.

**Extensions**
* The command given was invalid
  * Gordon shows an error message
  * Use case resumes on step 1

**Use case: `delete`**

**MSS:**
1. User requests a list of all recipes
2. Gordon shows a list of all recipes
3. User requests to delete a specific recipe
4. Gordon deletes that recipe.

Use case ends.

**Extensions**
* The list is empty
  * Use case ends
* The given index is invalid
  * Gordon shows an error message
  * Use case resumes from step 2

**Use case: `find`**

**MSS:**
1. User has a large cookbook
2. User searches for a specific recipe by a keyword
3. Gordon returns a list of all the recipes which contain that keyword
4. User checks the recipe for cooking

Use case ends.

**Extensions** 
* The list is empty
  * Use case ends
* No recipe contains the keyword
  * Gordon shows an error message
  * Use case resumes from step 2

**Use case: `tag`**

**MSS:** 
1. User wants to sort the recipes with their own metric
2. User requests to add a tag to a specific recipe
3. Gordon tags the recipe
4. User can now find the recipe by tag

Use case ends.

**Extensions**
* The given recipe does not exist
  * Gordon shows an error message
  * Use case resumes from step 2

## Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java `11` or above installed.
2. It should be able to hold thousands of recipes without any slowdown in performance
3. A user with above average typing speed should be able to key in recipes faster than using a typical mouse/GUI application

## Glossary

* *Mainstream OS* - Windows, MacOS, Linux, Unix

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
