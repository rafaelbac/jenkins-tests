def  files = ['test1.jenkinsfile', 'test2.jenkinsfile']

files.each { file ->
    pipelineJob(file.replace('.jenkinsfile', '')) {
        definition {
            cps {
                script(readFileFromWorkspace(file).stripIndent())
                sandbox()
            }
        }
    }
}
