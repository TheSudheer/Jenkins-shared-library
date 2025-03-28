#!/usr/bin/env groovy

def call() {
    echo "Checking Java and Gradle versions before building the application..."
    sh '''
        # Add the SDKMAN Gradle path to the PATH.
        export PATH=$HOME/.sdkman/candidates/gradle/current/bin:$PATH

        echo "---- Java Version ----"
        java -version

        echo "---- Gradle Version ----"
        gradle --version

        echo "Building the application with a timeout of 180 seconds..."
        timeout --kill-after=180 180 gradle clean build
    '''
}
