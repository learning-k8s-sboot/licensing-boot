pipeline {
    agent any

    environment {
    SERVICE_NAME = "licensing-boot"
    ORGANIZATION_NAME = "te-ma"
    }

    stages{
        stage('Preparation'){
            steps{
                cleanWs()
                git credentialsId: 'Bitbucket', ulr: "https://bitbucket.org/${ORGANIZATION_NAME}/${SERVICE_NAME}/"
            }
        }
        stage('Build'){
            steps{
                sh '''mvn clean package'''
            }
        }
    }
}