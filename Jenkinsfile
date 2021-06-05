pipeline {
    agent any

    environment {
    SERVICE_NAME = "licensing-boot"
    ORGANIZATION_NAME = "learning-k8s-sboot"
    }

    stages{
        stage('Preparation'){
            steps{
                cleanWs()
                git credentialsId: 'GitHub', url: "https://bitbucket.org/${ORGANIZATION_NAME}/${SERVICE_NAME}/"
            }
        }
        stage('Build'){
            steps{
                sh '''mvn clean package'''
            }
        }
    }
}