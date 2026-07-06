pipelineJob('seed-jobs') {
  definition {
    cps {
      script('''
        pipeline {
          agent any
          stages {
            stage('Generate folders') {
              steps {
                jobDsl(targets: 'jobs/seed-folder-builder.groovy')
              }
            }
            stage('Generate pipelines') {
              steps {
                jobDsl(targets: 'jobs/seed-pipeline-builder.groovy')
              }
            }
            stage('Generate multibranch jobs') {
              steps {
                jobDsl(targets: 'jobs/seed-multibranch.groovy')
              }
            }
          }
        }
      ''')
      sandbox(true)
    }
  }
}
