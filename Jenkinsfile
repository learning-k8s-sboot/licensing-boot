pipeline {
    agent any

    tools {
        jdk 'jdk_11.0.11'
      }

    environment {
    SERVICE_NAME = "licensing-boot"
    ORGANIZATION_NAME = "learning-k8s-sboot"
    }

    stages{
        stage('Preparation'){
            steps{
                cleanWs()
                git credentialsId: 'GitHub', url: "https://github.com/${ORGANIZATION_NAME}/${SERVICE_NAME}/"
            }
        }
        stage('Build'){
            steps{
                sh 'java -version'
                sh 'find / -name java '
                sh '''mvn clean package'''
            }
        }
    }
}