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
                    sh "mvn clean compile -B"

                }

            }

        }
    }


    }//pipeline closed