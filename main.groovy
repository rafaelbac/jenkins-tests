def  files = ['test1.jenkinsfile', 'test2.jenkinsfile']

files.each { file ->
    pipelineJob(file.getName()) {
        definition {
            cps {
                script(readFileFromWorkspace(file).stripIndent())
                sandbox()
            }
        }
    }
}
