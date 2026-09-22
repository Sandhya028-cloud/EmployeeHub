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

        stage('Docker Build') {
                  steps {
             bat 'docker build -t employeehub:1.0 .'
                       }
                   }

         stage('Docker Push') {
    steps {
        withCredentials([string(
            credentialsId: 'dockerhub-token',
            variable: 'DOCKER_TOKEN'
        )]) {

            powershell '''
                $env:DOCKER_TOKEN | docker login -u sandhyakadam --password-stdin
            '''

            bat 'docker tag employeehub:1.0 sandhyakadam/employeehub:1.0'

            bat 'docker push sandhyakadam/employeehub:1.0'
        }
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