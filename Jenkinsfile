pipeline {

    agent any

    environment {
        SERVICE_NAME = "licensing-boot"
        ORGANIZATION_NAME = "learning-k8s-sboot"
        DOCKER_USER_NAME = credentials('DOCKER_USER_NAME')
        REPOSITORY_TAG = "${DOCKER_USER_NAME}/${SERVICE_NAME}:${BUILD_ID}"
        DOCKER_IMAGE = ''
    }

    stages{
        stage('Preparation'){
            steps{
                cleanWs()
                git branch: 'develop', credentialsId: 'GitHub', url: "https://github.com/${ORGANIZATION_NAME}/${SERVICE_NAME}/"
            }
        }
        stage('Install'){
            steps{
                sh '''mvn clean package'''
            }
        }
        stage('Sonar'){
            steps{
                withSonarQubeEnv(installationName: 'sonar-learning'){
                    sh '''mvn sonar:sonar'''
                }
            }
        }
        stage('Init') {
            steps {
                echo 'Initializing..'
                echo "Running ${BUILD_ID} on ${JENKINS_URL}"
                echo "Current branch: ${BRANCH_NAME}"
            }
        }
        stage('Build Image') {
            steps {
                echo 'Building image..'
                script{
                    DOCKER_IMAGE = docker.build REPOSITORY_TAG
                }
            }
        }
        stage('Push Image') {
            steps {
                echo 'Publishing image to DockerHub..'
                script{
                    docker.withRegistry( '', 'DockerHub' ) {
                        DOCKER_IMAGE.push()
                    }
                }
            }
        }
        stage('Deploy to Cluster') {
            steps {
                sh 'envsubst < ${WORKSPACE}/deployment.yaml | kubectl apply -f -'
            }
        }
    }
}