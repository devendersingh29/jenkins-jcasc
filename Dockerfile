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

# Dynamic fix: jo bhi group GID 998 par already exist karta hai,
# jenkins ko uska member bana do (naya group mat banao)
ARG DOCKER_GID=998
RUN if getent group ${DOCKER_GID} > /dev/null 2>&1; then \
      EXISTING_GROUP=$(getent group ${DOCKER_GID} | cut -d: -f1); \
      usermod -aG ${EXISTING_GROUP} jenkins; \
    else \
      groupadd -g ${DOCKER_GID} docker && \
      usermod -aG docker jenkins; \
    fi

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