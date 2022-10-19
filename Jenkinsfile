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
        stage("Stop and delete docker container"){
            steps{
                sh 'docker stop $(docker ps -lq)'
                sh 'docker rm $(docker ps -lq)'
            }
        }
        stage("Deploy new docker image"){
            steps{
                sh 'docker run --name devops-demo-tomcat -p 8081:8080 -d alphasvo/devops-demo'
            }
        }
    }
}