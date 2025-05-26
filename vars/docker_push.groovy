def call(String image,String tag,String username){
  withCredentials([usernamePassword("credentialsId" : "dockerhub-username",passwordVariable : "password",usernameVariable : "username",)]){
                sh "docker login -u ${username} -p ${password}"
                //sh "docker image tag html-docker-demo ${env.username}/html-docker-demo"
                sh "docker push ${username}/${image}:${tag}"
}
