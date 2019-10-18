def  files = sh (script: "ls *.jenkinsfile", returnStdout: true).trim().split( "\\r?\\n" )

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