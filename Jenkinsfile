pipeline {
    agent any


       parameters {
       choice(
        name: 'ENVIRONMENT',
        choices: ['dev', 'test', 'prod'],
        description: 'Select deployment environment'
          )
     }

    stages {
        stage('Checkout') {
            steps {
                echo 'EmployeeHub source code checked out from GitHub'
            }
        }

     stage('Environment') {
      steps {
        echo "Building for environment: ${params.ENVIRONMENT}"
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