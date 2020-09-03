steps:
- task: Docker@2
  displayName: Login to ACR
  inputs:
    command: login
    containerRegistry: devopsmanual-acr

- task: Docker@2
  displayName: Build and Push
  inputs:
    repository: $(imageName)
    command: buildAndPush
    Dockerfile: build-docker-image/SampleAppForDocker/DOCKERFILE
    tags: |
      $(tag)
