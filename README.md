# CaloryTracker App

This project is an app developed during the course [Building Industry-Level Apps With Multi-Module Architecture](https://elopage.com/s/philipplackner/building-industry-level-apps-with-multi-module-architecture). 
Its purpose is to help users track their daily calorie intake in order to achieve their weight-related goals, whether it's losing, maintaining, or gaining weight.

## Features

The app provides the following features to assist users in tracking their calories:

- Daily goal setting: Users can define their daily calorie, protein, and fat goals.
- Meal tracking: The app allows users to track the calories of each meal they consume.
- Food search: Users can search for specific food items and track their calorie intake accordingly.

## Technology Stack

The app follows a multi-module architecture, utilizing the following technologies:

- **UI Framework**: Jetpack Compose
- **Design Pattern**: MVVM (Model-View-ViewModel)

The project consists of three modules:

1. **App**: This module serves as the launch point for the app and depends on the other two modules.
2. **Onboarding**: This module handles the onboarding process, including relevant UI and functionality.
3. **Tracker**: The tracker module manages the calorie tracking and food search features.

Each module is further divided into three sub-modules:

- **Data**: Handles data management and storage.
- **Domain**: Contains the core business logic of each module.
- **Presentation**: Handles the UI and user interaction.

This modular structure ensures separation of concerns, with clear boundaries between different layers of the app.

## Navigation

Initially, each module was responsible for its own navigation. However, it was later refactored to centralize navigation control in the app module. 
This approach provides flexibility for future refactoring and simplifies the navigation process. The navigation between modules is facilitated through callback functions passed down to the respective views.

## Lessons Learned

Throughout the development of this project, several valuable insights were gained:

- **Dynamic Features**: When choosing a dependency injection library for dynamic features, it is recommended to use `Dagger 2` instead of `Dagger Hilt`. The latter requires knowledge of all modules at build time.
- **Module Permissions**: Each module can have its own permissions. If a specific module requires internet access, the permission can be added to that module alone, rather than the entire app module.
- **Navigation Control**: Centralizing navigation control in the app module offers more flexibility and allows for easier navigation refactoring.

### Advantages & Disadvantages of Multiple Modules

#### Pros

- **Separation of Concerns**: The modular architecture ensures clear separation of different components, promoting maintainability and scalability.
- **Faster Build Times**: With modularization, incremental builds become faster as only the necessary modules are recompiled.
- **Support for Instant Apps & Dynamic Features**: The architecture supports instant app development and enables the implementation of dynamic features.
- **Reusability of Modules**: Individual modules can be reused in other projects, reducing development effort.

#### Cons

- **Setup Complexity**: Setting up the multi-module architecture requires additional effort and complexity during initial project setup.
- **Potential Pitfalls**: Insufficient knowledge of module architecture and organization may lead to issues or inefficiencies in the project.