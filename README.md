# Movie Recommendation System

A Java-based client-server application that manages a catalog of movies organized by genres using a Tree data structure.
The system allows users to list movies, add new entries, rate them, and receive recommendations via a TCP command-line interface.

## Architecture & Design Patterns
This project demonstrates the practical application of several design patterns:

### Composite Pattern
Used to structure the `GenreTree`. Both `GenreNode` (Composite) and `Movie` (Leaf) implement the `CatalogComponent` interface, allowing uniform treatment of individual movies and genre hierarchies.

### Command Pattern
Encapsulates user requests (e.g., `RateCommand`, `AddMovieCommand`, `RecommendCommand`) as objects.

### Strategy Pattern
Enables dynamic switching of algorithms for listing and recommending movies (e.g., `TopRatedRecommendationStrategy`, `GenreListStrategy`).

## Prerequisites
* Java 21 or higher.
* Maven (for building the project).

## Building the Project
To compile the project and generate the JAR file, open your terminal in the project root directory and run:

```bash
mvn clean package
