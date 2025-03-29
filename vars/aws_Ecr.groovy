#!/usr/bin/env groovy

def call(String AWS_ECR_REPO, String imageName) {
    echo 'Building the docker image and pushing it to AWS ECR...'
    withCredentials([usernamePassword(credentialsId: 'ecr-credentials', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
        sh "docker build -t ${AWS_ECR_REPO}:${imageName} ."
        sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"
        sh "docker push ${AWS_ECR_REPO}:${imageName}"
    }
}
