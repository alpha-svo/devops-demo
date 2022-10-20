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
                    sh '/tmp/jenkins-shell/change-docker-permission.sh'
                    sh '/tmp/jenkins-shell/delete-last-image.sh'
                    sh 'docker build -t alphasvo/devops-demo .'
                }
            }
        }
        stage("Deploy"){
            steps{
                sh '/tmp/jenkins-shell/check-first-run.sh'
            }
        }
    }
}