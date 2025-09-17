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

        stage('Code Quality') {
            steps {
                echo "Running static analysis..."
                sh "${MAVEN_HOME}/bin/mvn sonar:sonar"
            }
        }

        stage('Package') {
            steps {
                echo "Packaging application..."
                sh "${MAVEN_HOME}/bin/mvn package -DskipTests"
            }
        }

        stage('Deploy to Dev') {
            when {
                branch "develop"
            }
            steps {
                echo "Deploying to DEV environment..."
                sh "./scripts/deploy.sh dev"
            }
        }

        stage('Deploy to Prod') {
            when {
                branch "main"
            }
            steps {
                input message: "Deploy to PROD?", ok: "Deploy"
                echo "Deploying to PROD environment..."
                sh "./scripts/deploy.sh prod"
            }
        }
    }

    post {
        always {
            echo "Pipeline finished (success or failure)."
        }
        success {
            echo "✅ Build succeeded!"
        }
        failure {
            echo "❌ Build failed!"
        }
    }
}
