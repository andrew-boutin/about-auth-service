# So we can see what commands get ran from the command line output.
SHELL = sh -xv

default: clean build run

# Deletes the build directory.
.PHONY: clean
clean:
	./gradlew clean

# Assembles and tests this project.
.PHONY: build
build:
	./gradlew build

# Run the Java jar directly.
.PHONY: run
run:
	java -jar build/libs/about-auth-service-1.0.0.jar
