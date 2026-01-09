pipeline {
    agent any

    environment{



    }

    tools{
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
    }


    }//pipeline closed