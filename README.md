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
This will create the artifact `movie-recom-tree-1.0-SNAPSHOT.jar` inside the `target/` directory.

## How to Run
Since this application functions as both a Server and a Client, the JAR file contains multiple entry points. You must run the Server first, followed by one or more Clients.

### 1. Start the Server
The server initializes the Genre Tree and listens for connections on port 5000.

### 2. Run the following command:
```bash
java -cp target/movie-recom-tree-1.0-SNAPSHOT.jar ch.hevs.server.RecomServer

### 3. Start the client:
Open a new terminal window (do not close the server) and run the client to connect to the server:
```bash
java -cp target/movie-recom-tree-1.0-SNAPSHOT.jar ch.hevs.client.Client

### Note:
The -cp flag specifies the Classpath, allowing you to select which main class (RecomServer or Client) to execute from the same JAR file.
