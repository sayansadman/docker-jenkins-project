pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // this pulls code from local path or Git
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mnvw clean package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t docker-jenkins-app .'
            }
        }

        stage('Deploy') {
            steps {
                // Stops old container if exists and run the new one
                sh 'docker stop docker-jenkins-container || true'
                sh 'docker rm docker-jenkins-container || true'
                sh 'docker run -d -p 8081:8080 --name docker-jenkins-container docker-jenkins-app'
            }
        }
    }
}