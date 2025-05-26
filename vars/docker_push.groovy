def call(String image,String tag,String username){
  withCredentials([usernamePassword("credentialsId" : "dockerhub-username",passwordVariable : "password",usernameVariable : "username",)]){
                sh "docker login -u ${username} -p ${password}"
  }
                sh "docker image tag ${image} ${username}/${image}"
                sh "docker push ${username}/${image}:${tag}"
}
