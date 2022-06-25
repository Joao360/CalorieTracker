# CaloryTracker

An app developed during the
course [Building Industry-Level Apps With Multi-Module Architecture](https://elopage.com/s/philipplackner/building-industry-level-apps-with-multi-module-architecture)

## What is the goal of the app

The main goal of the app, in terms of business logic, is to help users track their daily calories to
achieve a certain goal. This goal can be lose, keep or gain weight.

The user will have a daily goal of calories, protein and fat ingested and the app will help tracking
it by supplying a search page where they can search and track the calories of an ingested meal. If
the the total calories ingested

## The tech side of it

The app followed the multi-module architecture with Jetpack Compose as the UI framework and MVVM
design pattern to connect each individual feature logic together.

As of today, the app has 3 modules

* app
* onboarding
* tracker

The app module serves as the launch point and thus is dependent of all of the remaining modules,
while the onboarding module, as the name implies, has everything related to the onboarding process.

The tracker module handles all the tracking of calories a user does. This includes the daily
tracking of food for each meal and also the search for food.

### Inside each module

It was decided each module would have 3 other sub-modules. Which are

* data
* domain
* presentation

With this decision the ever separation of concerns will be even greater since we confirm the
following:

* The domain layer shouldn't know anything from any other layer
* The data and presentation layers should only communicate to the domain one, they should never know
  the existence of the other or should know its details

### Navigation

The navigation, as a first implementation, was handled by each module and when the goal was to
navigate to a screen present in a different module it would be done through a callback.

Later it was refactored for the whole control of the navigation to be handled by the app module
since it would give a much more agile way of refactoring the navigation if necessary. The way this
was done was basically through passing callbacks to each view whenever they want to navigate to a
different screen.

## Things learnt with the development of this project

- For dynamic features when choosing a dependency injection library you must pick `Dagger 2`
  over `Dagger Hilt` since the latter requires knowledge of all modules at build time.
- Each module has its own **permissions**, so if for some reason the app needs to access to the
  internet you just need to add that permission to the modules that **use it**, instead of adding it
  to the `app` module.
- **Navigation** between modules is controlled by the app module. This module decides how the
  navigation between modules work through a set of callback functions passed down to the modules

### Advantages & Disadvantages of Multiple Modules

#### Pros

- Separation of concerns
- Faster build times
- Support for instant apps & dynamic features
- Reusability of modules

#### Disadvantages

- Requires a lot of work to setup
- Not knowing what you’re doing will strongly backfire