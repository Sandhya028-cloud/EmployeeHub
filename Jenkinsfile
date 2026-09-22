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




stage('Docker Environment Check') {
    steps {
        bat 'whoami'
        bat 'docker version'
        bat 'docker context show'
    }
}




        stage('Docker Push') {
    steps {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub-creds',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {

            bat '''
                echo %DOCKER_PASS% | docker login -u %DOCKER_USER% --password-stdin
            '''

            bat 'docker tag employeehub:1.0 %DOCKER_USER%/employeehub:1.0'

            bat 'docker push %DOCKER_USER%/employeehub:1.0'
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