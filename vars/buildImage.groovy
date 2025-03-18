#!/usr/bin/env groovy // shebang line

def call() {
    echo 'Building the docker image'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "docker build -t kalki2878/java-gradle-app:latest ."
        sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
        sh "docker push kalki2878/java-gradle-app:latest"
    }
}

return this
