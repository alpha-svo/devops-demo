pipeline{
    agent any
    tools{
        maven 'maven_3_6_3'
    }
    stages{
        stage("Build Maven"){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/alpha-svo/devops-demo']]])
                sh "mvn clean install"
            }
        }
        stage("Build docker image"){
            steps{
                script{
                    sh 'docker build -t alphasvo/devops-demo .'
                }
            }
        }
        stage("Push image to hub"){
            steps{
                withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u alphasvo -p ${dockerhubpwd}'

                    sh 'docker push alphasvo/devops-demo'
                }
            }
        }
    }
}