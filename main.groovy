import hudson.FilePath

// Build a list of all config files ending in .jenkinsfile
def cwd = hudson.model.Executor.currentExecutor().getCurrentWorkspace().absolutize()
def files = new FilePath(cwd).list('*.jenkinsfile')

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
