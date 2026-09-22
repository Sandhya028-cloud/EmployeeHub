pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'EmployeeHub source code checked out from GitHub'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }


       stage('Docker Check') {
                steps {
                bat 'docker --version'
                     }
               }
    }

    post {
        success {
            echo 'EmployeeHub build completed successfully'
        }

        failure {
            echo 'EmployeeHub build failed'
        }
    }
}