pipeline {
    agent any


    environment {
    SERVICE_NAME = "licensing-boot"
    ORGANIZATION_NAME = "learning-k8s-sboot"
    DOCKERHUB_USERNAME = "vnedbaliuk"
    REPOSITORY_TAG = "${DOCKERHUB_USERNAME}/${ORGANIZATION_NAME}:${BUILD_ID}"
    DOCKER_IMAGE = ''
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
        stage('Build Image'){
            steps{
                script{
                    DOCKER_IMAGE = docker.build REPOSITORY_TAG
                }
            }
        }
        stage('Deploy Image'){
            steps{
                script{
                    docker.withRegistry( '', 'DockerHub' ) {
                        DOCKER_IMAGE.push()
                    }
                }
            }
        }
    }
}
