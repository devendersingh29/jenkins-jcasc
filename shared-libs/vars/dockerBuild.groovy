def call(String imageName) {
  sh "docker build -t ${imageName} ."
}

def push(String imageName) {
  sh "docker push ${imageName}"
}
