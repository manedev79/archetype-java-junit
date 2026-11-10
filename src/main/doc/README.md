# archetype-java-junit

[![Build Status](https://dev.azure.com/manedev79/OSS%20Projects/_apis/build/status/manedev79.archetype-java-junit?branchName=main)](https://dev.azure.com/manedev79/OSS%20Projects/_build/latest?definitionId=4&branchName=main)

Maven archetype with recent java version, JUnit 6, AssertJ and git repository in place.

Includes:

* Java version of your choice, 17 or newer (default: 17)
* JUnit 6
* AssertJ

A git repo will be initialized for the created project.  
There is a `.gitignore` file with defaults for 
Maven, IntelliJ IDEA and VSCode.

## Usage

```
mvn archetype:generate -DarchetypeGroupId=io.github.manedev79 \
                       -DarchetypeArtifactId=archetype-java-junit \
                       -DarchetypeVersion=${project.version} \
                       -DjavaVersion=21 \
                       -DgitInit=true
```

### Parameters

#### `javaVersion`
The Java version to use in the created project.  
Possible values: Any Java version from 17 on, since JUnit 6 requires Java 17.  
Default: `17`  
Example: `javaVersion=21`


#### `gitInit`
Whether to initialize a git repository in the created project or not.  
Possible values: `true` or `false`.

## Development Setup

### Prerequisites  
* Requires Java 25, because the integration tests generate a Java 25 project.
* Optional: [sdkman](https://sdkman.io) for switching JDK
  * Use `sdk env` to switch to JDK specified in `.sdkmanrc`.

### Install locally
```
./mvnw install
```
