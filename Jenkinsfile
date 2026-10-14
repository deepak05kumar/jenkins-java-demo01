pipeline {
    agent any

    environment {
        APP_NAME = 'jenkins-java-demo01'
    }

    parameters {
        booleanParam(
            name: 'RUN_TESTS',
            defaultValue: true,
            description: 'Run unit tests before packaging'
        )
    }

    stages {
        stage('Compile') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Unit Tests') {
            when {
                expression { params.RUN_TESTS }
            }
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                  testResults: '**/target/surefire-reports/*.xml'
        }

        success {
            archiveArtifacts artifacts: 'target/*.jar'
            echo "Pipeline completed successfully for ${APP_NAME}!"
        }

        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}


/*pipeline {
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
            junit '*target/surefire-reports.xml'
        }

        success {
            archiveArtifacts artifacts: 'target.jar'
            echo 'Java Maven Pipeline completed successfully!'
        }
    }
}*/