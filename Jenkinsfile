pipeline {
    agent any

     environment {
        APP_NAME = "Calc-App"
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
                sh "./mvnw package -DskipTests- B"
            }
        }

    }


    }//pipeline closed