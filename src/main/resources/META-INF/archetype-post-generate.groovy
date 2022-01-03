// request - org.apache.maven.archetype.ArchetypeGenerationRequest
println "REQUEST: $request"
println "PROPS: $request.properties"
println "PROP gitInit: $request.properties.gitInit"

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
        println "GIT INIT"
        run "git init"
    }
}

def renameGitignore(File projectDir) {
    new File(projectDir, '_gitignore').renameTo(new File(projectDir, '.gitignore'))
}

renameGitignore(projectDir)
initGitRepo()
