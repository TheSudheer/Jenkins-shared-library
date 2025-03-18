#!/usr/bin/env groovy

def call(String imageName) {
    echo 'Building the docker image'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "docker build -t ${imageName} ."
        sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
        sh "docker push ${imageName}"
    }
}
