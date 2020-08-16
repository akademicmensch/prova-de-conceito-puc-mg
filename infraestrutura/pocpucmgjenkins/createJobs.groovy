pipelineJob('pipelineJob') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}

pipelineJob('pocpucmgexamplejob'){
    definition {
        cpsScm{
            scm{
                git{
                    remote{
                        url 'https://github.com/akademicmensch/pocpucmgexamplejob.git'
                    }
                    branch 'master'
                }
           }
        }
     }
}

pipelineJob('pocpucmgspringsecurityjwt'){
    definition {
        cpsScm{
            scm{
                git{
                    remote{
                        url 'https://github.com/akademicmensch/pocpucmgspringsecurityjwt.git'
                    }
                    branch 'master'
                }
           }
        }
     }
}
