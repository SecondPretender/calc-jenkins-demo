pipeline {
    agent any

     environment {
        APP_NAME = "Calc-App"
        DOCKER_IMAGE = "demo_calc_jpl"
     }

    stages{
        stage('Initialize'){
            steps{
                echo "Application: ${APP_NAME}"
                echo "Build Number: ${BUILD_NUMBER}"
            }
        }
        stage("Checkout"){
            steps {
                // checkout scm  // For Git-based projects
                sh 'ls -la'
            }
        }

        stage("Build"){
            steps{
                dir("."){
                    sh "chmod -R 777 ./mvnw"
                    sh "./mvnw clean compile -B"
                }
            }
        }

        stage("Test"){
            steps{
                sh "./mvnw test -B"
            }
            post{
                always{
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage("Package"){
            steps{
                dir("."){
                    sh "./mvnw package -DskipTests -B"
                }

            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/training1_9-1.0-SNAPSHOT.jar', fingerprint: true
                }
            }
        }

        stage("Code Quality"){
            parallel{
                stage("Lint Check"){
                    steps{
                        echo "Running Linter"
                    }

                }
                stage("Security Skin"){
                    steps{
                        echo "Running Security Scan"
                    }
                }
            }
        }

        stage('Build Docker Image') {
            when {
                expression { params.BUILD_DOCKER == true }
            }
            steps {
                dir('java-app') {
                    sh '''
                        docker build -t ${DOCKER_IMAGE}:${BUILD_NUMBER} .
                        docker tag ${DOCKER_IMAGE}:${BUILD_NUMBER} ${DOCKER_IMAGE}:latest
                    '''
                }
            }
        }

    }


    }//pipeline closed