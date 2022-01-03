// request - org.apache.maven.archetype.ArchetypeGenerationRequest
projectDir = new File(new File(request.outputDirectory), request.artifactId)

def run(String cmd) {
    def process = cmd.execute(null, projectDir)
    process.waitForProcessOutput((Appendable)System.out, System.err)
    if (process.exitValue() != 0) {
        throw new Exception("Command '$cmd' exited with code: ${process.exitValue()}")
    }
}

def initGitRepo() {
    if (request.properties.gitInit == 'true') {
        println "Initializing git repository"
        run "git init"
    }
}

def renameGitignore(File projectDir) {
    println "Renaming _gitignore to .gitignore. This is due to https://issues.apache.org/jira/projects/ARCHETYPE/issues/ARCHETYPE-505"
    new File(projectDir, '_gitignore').renameTo(new File(projectDir, '.gitignore'))
}

renameGitignore(projectDir) // TODO: Remove when this is fixed: https://issues.apache.org/jira/projects/ARCHETYPE/issues/ARCHETYPE-505
initGitRepo()
