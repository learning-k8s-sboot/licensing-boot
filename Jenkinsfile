pipeline {
    agent any

    tools {
        jdk 'java_11'
    }

    environment {
    SERVICE_NAME = "licensing-boot"
    ORGANIZATION_NAME = "learning-k8s-sboot"
    DOCKERHUB_USERNAME = "vnedbaliuk"
    REPOSITORY_TAG = "${DOCKERHUB_USERNAME}/${ORGANIZATION_NAME}:${BUILD_ID}"
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
                sh '''mvn clean package -DskipTests'''
            }
        }
        stage('Build and Push Image'){
            steps{
                sh 'docker image build -t ${REPOSITORY_TAG} .'
                sh 'docker push ${REPOSITORY_TAG}'
            }
        }
    }
}