@Library("shared-libraries") _
pipeline {
    agent { label "pramod" }

    stages {
        stage('Hello') {
            steps {
               script{
                   hello()
                   karthik()
               }
            }
        }
        
        stage('code') {
            steps {
                echo 'This is coding part'
                script{
                    clone("https://github.com/pramod19workspace/html-docker-demo.git", "main")
                }
            }
        }

        stage('build') {
            steps {
                echo 'Build Part'
                script{
                    build("html-docker-demo", "latest")
                }
                echo "Build done"
            }
        }    

        stage('pushing image to dockerhub') {
            steps {
                echo 'Pusing image to dockerhub'
                // withCredentials([usernamePassword(
                //     "credentialsId" : "dockerhub-username",
                //     passwordVariable : "password",
                //     usernameVariable : "username",
                //     )]){
                // sh "docker login -u ${env.username} -p ${env.password}"
                // sh "docker image tag html-docker-demo ${env.username}/html-docker-demo"
                // sh "docker push ${env.username}/html-docker-demo"
                script{
                    docker_push("html-docker-demo", "latest", "pramod19workspace")
                }
            }
        }

        stage('deploy') {
            steps {
                echo 'Deployment part'
                sh "docker compose up -d"
                echo "Deployment done"
            }
        }
    }
}
