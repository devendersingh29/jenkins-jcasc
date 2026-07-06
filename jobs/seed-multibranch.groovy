def repos = [
  [folder: 'team-alpha', name: 'alpha-multibranch', repo: 'https://github.com/example/team-alpha', branch: 'main'],
  [folder: 'team-beta', name: 'beta-multibranch', repo: 'https://github.com/example/team-beta', branch: 'main']
]

repos.each { r ->
  multibranchPipelineJob("${r.folder}/${r.name}") {
    branchSources {
      github {
        id(r.name)
        repoOwner('example')
        repository(r.repo.tokenize('/').last())
        scanCredentialsId('github-pat')
      }
    }
    factory {
      workflowBranchProjectFactory {
        scriptPath('Jenkinsfile')
      }
    }
    triggers {
      periodicFolderTrigger {
        interval('1h')
      }
    }
  }
}
