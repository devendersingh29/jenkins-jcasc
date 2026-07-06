folder('team-alpha') {
  displayName('Team Alpha')
  description('Team Alpha pipelines and jobs')
  properties {
    authorizationMatrix {
      permission('hudson.model.Item.Read:org/team-alpha', 'org/team-alpha')
      permission('hudson.model.Item.Build:org/team-alpha', 'org/team-alpha')
      permission('hudson.model.Item.Configure:org/team-alpha', 'org/team-alpha')
    }
  }
}

folder('team-beta') {
  displayName('Team Beta')
  description('Team Beta pipelines and jobs')
  properties {
    authorizationMatrix {
      permission('hudson.model.Item.Read:org/team-beta', 'org/team-beta')
      permission('hudson.model.Item.Build:org/team-beta', 'org/team-beta')
      permission('hudson.model.Item.Configure:org/team-beta', 'org/team-beta')
    }
  }
}

folder('infra') {
  displayName('Infrastructure')
  description('Shared infrastructure pipelines')
}

folder('sandbox') {
  displayName('Sandbox')
  description('Experimentation and prototypes')
}
