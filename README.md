# archetype-java-junit

[![Build Status](https://dev.azure.com/manedev79/OSS%20Projects/_apis/build/status/manedev79.archetype-java-junit?branchName=main)](https://dev.azure.com/manedev79/OSS%20Projects/_build/latest?definitionId=4&branchName=main)

Maven archetype with recent java version, JUnit5, assertj and git repository in place.

Includes:

* Java version of your choice, e.g. 17
* JUnit5
* assertj

A git repo will be initialized for the created project.  
There is a `.gitignore` file with defaults for 
Maven, IntelliJ IDEA and VSCode.




## Installation

### Prerequisites  
* Requires Java 17.
* Optional: [sdkman](https://sdkman.io) for switching JDK
  * Use `sdk env` to switch to JDK specified in `.sdkmanrc`.

### Install locally
```
mvn install
```

## Usage

```
mvn archetype:generate -DarchetypeGroupId=io.github.manedev79 \
                       -DarchetypeArtifactId=archetype-java-junit \
                       -DarchetypeVersion=1.0.0-SNAPSHOT \
                       -DjavaVersion=11
                       -DgitInit=true
```

### Parameters

#### `javaVersion`
The Java version to use in the created project.  
Possible values: Any valid Java version.
Example: `javaVersion=17`


#### `gitInit`
Whether to initialize a git repository in the created project or not.  
Possible values: `true` or `false`.
