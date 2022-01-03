# archetype-java-junit

Maven archetype for simple java projects with LTS JDK and JUnit5.

Includes:

* Java version of your choice, e.g. 17
* JUnit5
* assertj

A git repo will be initialized for the created project.  
There is a `.gitignore` file with defaults for 
Maven, IntelliJ IDEA and VSCode.

## Installation

```
mvn install
```

## Usage

```
mvn archetype:generate -DarchetypeGroupId=io.github.manedev79 \
                       -DarchetypeArtifactId=archetype-java-junit \
                       -DarchetypeVersion=1.0.0-SNAPSHOT
```