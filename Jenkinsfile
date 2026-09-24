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
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests'
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