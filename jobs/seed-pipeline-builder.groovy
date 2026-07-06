def pipelines = [
  [folder: 'team-alpha', name: 'alpha-ci', repo: 'https://github.com/example/team-alpha', branch: 'main', jenkinsfile: 'Jenkinsfile'],
  [folder: 'team-beta', name: 'beta-ci', repo: 'https://github.com/example/team-beta', branch: 'main', jenkinsfile: 'Jenkinsfile']
]

pipelines.each { p ->
  pipelineJob("${p.folder}/${p.name}") {
    definition {
      cpsScm {
        scm {
          git {
            remote { url(p.repo) }
            branch(p.branch)
          }
        }
        scriptPath(p.jenkinsfile)
      }
    }
  }
}
