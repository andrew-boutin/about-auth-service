# So we can see what commands get ran from the command line output.
SHELL = sh -xv

default: clean validateSpec build run

# Validate the API spec.
.PHONY: validateSpec
validateSpec:
	./gradlew openApiValidate

# Deletes the build directory.
.PHONY: clean
clean:
	./gradlew clean

# Test only.
.PHONY: test
test:
	./gradlew test

# Assembles and tests this project.
.PHONY: build
build:
	./gradlew build

# Run the Java jar directly.
.PHONY: run
run:
	java -jar build/libs/about-auth-service-1.0.0.jar
