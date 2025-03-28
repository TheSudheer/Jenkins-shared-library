#!/usr/bin/env groovy // shebang line

def call() {
    echo "building the application...."
    sh " timeout --kill-after=180 180 ./gradlew clean build"
}
