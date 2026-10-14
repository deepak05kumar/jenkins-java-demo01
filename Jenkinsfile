
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/deepak05kumar/jenkins-java-demo01.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean verify'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }

        success {
            archiveArtifacts artifacts: 'target/*.jar'
            echo 'Java Maven Pipeline completed successfully!'
        }
    }
}