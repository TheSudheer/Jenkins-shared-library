#!/usr/bin/env groovy // shebang line

def call() {
    echo "building the application...."
    sh "./gradlew build"
}
