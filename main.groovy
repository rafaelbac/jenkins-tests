import hudson.FilePath

// Build a list of all config files ending in .jenkinsfile
def files = new FilePath(build.workspace.channel, pwd()).list('*.jenkinsfile')

files.each { file ->
    pipelineJob(file.getBaseName()) {
        definition {
            cps {
                script(file.readToString().stripIndent())
                sandbox()
            }
        }
    }
}
