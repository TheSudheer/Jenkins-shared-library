#!/usr/bin/env groovy

def call() {
    echo "Checking Java and Gradle versions before building the application..."
    sh '''
        # Add the absolute Gradle path from SDKMAN
        export PATH=/home/ubuntu/.sdkman/candidates/gradle/current/bin:$PATH

        echo "---- Java Version ----"
        java -version

        # Explicitly adding the SDKMAN Gradle path
        export PATH=/home/ubuntu/.sdkman/candidates/gradle/current/bin:$PATH
                    
        echo "---- Gradle Version ----"
        gradle --version

        echo "Building the application with a timeout of 300 seconds..."
        timeout --kill-after=300 300 gradle clean build
    '''
}
