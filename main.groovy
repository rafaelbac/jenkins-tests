import hudson.FilePath

// Build a list of all config files ending in .jenkinsfile
def workspace = hudson.model.Executor.currentExecutor().getCurrentWorkspace()
def files = workspace.list('*.jenkinsfile')

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
