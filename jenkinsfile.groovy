pipeline {
    agent any
               
       stages {
            stage('SCM checkout') {
                  steps {
                        git url: 'https://github.com/Madhavi1952662/webserver-project.git'
                        }
             }
             
             stage('archiving artifacts') {
                  steps {
                          archiveArtifacts '**/*.html'
                        }
              }
              
              stage('transfer artifacts') {
                    steps {
                          sshPublisher(publishers: [sshPublisherDesc(configName: 'jenkins', transfers: [sshTransfer(excludes: '', execCommand: '', execTimeout: 120000, flatten: true, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '', remoteDirectorySDF: false, removePrefix: '', sourceFiles: '**/*.html')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: true)])
// here remote directory not using will call it from configure management tool 
                          }
              }
       }
}
