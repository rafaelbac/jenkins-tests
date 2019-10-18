def files = findFiles(glob: '*.jenkinsfile')

files.each { file ->
    pipelineJob(file.getName()) {
        definition {
            cps {
            script(readFileFromWorkspace(file).stripIndent())
            }
        }
    }
}
