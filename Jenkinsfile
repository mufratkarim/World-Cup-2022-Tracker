pipeline {
  agent any
  stages {
    stage('Checkout Stage') {
      steps {
        git(url: 'https://github.com/mufratkarim/World-Cup-2022-Tracker', branch: 'main')
      }
    }

    stage('Log') {
      steps {
        sh 'ls -la'
      }
    }

  }
}