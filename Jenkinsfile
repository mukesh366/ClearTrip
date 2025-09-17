pipeline {
    agent any   // or use: agent { label 'my-node' }

    options {
        timestamps()      // show timestamps in logs
        skipDefaultCheckout() // optional, if you want manual checkout
    }

    environment {
        MAVEN_HOME = "/opt/homebrew"
        JAVA_HOME = "/opt/homebrew/Cellar/openjdk/20/"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out code..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building the project..."
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }

        stage('Unit Tests') {
            steps {
                echo "Running unit tests..."
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }
    }
}
