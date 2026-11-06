pipeline {
    agent any

    environment {
        PATH = "/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/opt/homebrew/bin:${env.PATH}"
        
        // Formatted to map directly to your Docker Hub repository
        IMAGE_NAME = "vatsank/doctor-data-jpa-api"
        IMAGE_TAG  = "${BUILD_NUMBER}"
        CONTAINER_NAME = "doctor-data-api-container"
        PROJECT_DIR = "doctor_data_jpa_rest_api_secured-dockerized"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building the multi-stage Docker image...'
                dir("${env.PROJECT_DIR}") {
                    sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} -t ${IMAGE_NAME}:latest ."
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                echo 'Logging in and pushing image to Docker Hub...'
                // Pointed explicitly to your pre-existing credential ID
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', 
                                                 usernameVariable: 'DOCKER_USER', 
                                                 passwordVariable: 'DOCKER_PASS')]) {
                    sh "echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin"
                    sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
                    sh "docker push ${IMAGE_NAME}:latest"
                }
            }
        }

        stage('Deploy Container') {
            steps {
                echo 'Deploying the application container locally...'
                sh '''
                    if [ \$(docker ps -aq -f name=${CONTAINER_NAME}) ]; then
                        echo "Stopping and removing existing container..."
                        docker stop ${CONTAINER_NAME} || true
                        docker rm ${CONTAINER_NAME} || true
                    fi
                '''
                sh "docker volume create medconnect_h2_data"
                sh """
                    docker run -d \
                        --name ${CONTAINER_NAME} \
                        -p 8080:8080 \
                        -v medconnect_h2_data:/app/data \
                        --restart unless-stopped \
                        ${IMAGE_NAME}:latest
                """
            }
        }

        stage('Sanity Check') {
            steps {
                echo 'Waiting for application to boot up...'
                sleep 10
                sh "curl -f http://localhost:8080/actuator/health || exit 1"
            }
        }
    }

    post {
        always {
            echo 'Cleaning up dangling Docker build images...'
            sh 'docker image prune -f'
        }
    }
}
