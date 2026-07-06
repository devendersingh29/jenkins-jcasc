

def pipelines = [
  [folder: 'team-alpha', name: 'alpha-ci', jenkinsfile: 'pipelines/team-alpha/Jenkinsfile'],
  [folder: 'team-beta', name: 'beta-ci', jenkinsfile: 'pipelines/team-beta/Jenkinsfile'],
  [folder: 'echodocker', name: 'echodocker-ci', jenkinsfile: 'pipelines/echodocker/Jenkinsfile']
]

pipelines.each { p ->
  pipelineJob("${p.folder}/${p.name}") {
    definition {
      cpsScm {
        scm {
          git {
            remote { url(repoUrl) }
            branch('main')
          }
        }
        scriptPath(p.jenkinsfile)
      }
    }
  }
}
