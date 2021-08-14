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
                git branch: 'develop', credentialsId: 'GitHub', url: "https://github.com/${ORGANIZATION_NAME}/${SERVICE_NAME}/"
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
        stage('Push Image'){
            steps{
                script{
                    docker.withRegistry( '', 'DockerHub' ) {
                        DOCKER_IMAGE.push()
                    }
                }
            }
        }
        stage('Deploy to Cluster') {
            steps {
                sh 'envsubst < ${WORKSPACE}/deployment.yaml | microk8s.kubectl apply -f -'
            }
        }
    }
}
