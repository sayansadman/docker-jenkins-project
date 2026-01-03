pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Pulls code from your GitHub repository
                checkout scm
            }
        }

        stage('Docker Build & Package') {
            steps {
                // This command triggers the Dockerfile.
                // Docker will download Java 25 and compile your code inside a container.
                sh 'docker build -t docker-jenkins-app .'
            }
        }

        stage('Deploy') {
            steps {
                // Stops old container if it exists and runs the new one
                sh 'docker stop docker-jenkins-container || true'
                sh 'docker rm docker-jenkins-container || true'
                sh 'docker run -d -p 8081:8080 --name docker-jenkins-container docker-jenkins-app'
            }
        }
    }
}