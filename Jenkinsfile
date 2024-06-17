pipeline {
    agent any

    stages {
        stage('Checkout code') {
            steps {
                git url: 'https://github.com/patricedjate/gestionPigierBackEnd.git'
            }
        }

        stage('Build Maven/Gradle') {
            steps {
                sh 'mvn clean package' // Remplacer par 'gradle build' si vous utilisez Gradle
            }
        }

        stage('Test application') {
            steps {
                sh 'mvn test' // Remplacer par 'gradle test' si vous utilisez Gradle
            }
        }

        stage('Build Docker image') {
            steps {
                dockerImage 'jenkins/docker-maven:latest' // Utiliser l'image Docker pour compiler Maven
                withDockerRegistry([
                    id: 'dockerhub',
                    url: 'https://index.docker.io',
                    credentialsId: 'dockerhub-cred'
                ]) {
                    dockerBuild 'patricedjate/gestionPigierBackEnd:latest'
                }
            }
        }

        stage('Deploy Docker image') {
            steps {
                dockerImage 'dockerhub/centos:latest' // Utiliser l'image Docker pour l'exécution
                withDockerRegistry([
                    id: 'dockerhub',
                    url: 'https://index.docker.io',
                    credentialsId: 'dockerhub-cred'
                ]) {
                    dockerPush 'patricedjate/gestionPigierBackEnd:latest'
                }
            }
        }
    }
}
