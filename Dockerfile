FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y \
        git \
        docker.io \
        curl \
        openssh-client \
        ca-certificates && \
    rm -rf /var/lib/apt/lists/*

USER jenkins

RUN jenkins-plugin-cli --plugins \
    configuration-as-code \
    job-dsl \
    git \
    github \
    github-oauth \
    github-branch-source \
    github-pullrequest \
    role-strategy \
    matrix-auth \
    cloudbees-folder \
    pipeline-stage-view \
    workflow-aggregator \
    pipeline-model-definition \
    workflow-cps-global-lib \
    credentials-binding \
    ssh-credentials \
    plain-credentials \
    docker-workflow \
    docker-plugin \
    mailer \
    slack \
    ws-cleanup \
    build-timeout \
    timestamper \
    pam-auth \
    ldap
