#!/usr/bin/env groovy // shebang line

def call() {
    echo "building the application for branch $BRANCH_NAME"
    sh "./gradlew build"
}
