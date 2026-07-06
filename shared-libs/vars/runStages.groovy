def call(List stages) {
  stages.each { stageName ->
    stage(stageName) {
      echo "Running ${stageName}"
    }
  }
}
