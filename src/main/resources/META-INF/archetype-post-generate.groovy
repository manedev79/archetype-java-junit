projectDir = new File(new File(request.outputDirectory), request.artifactId)
new File(projectDir, '_gitignore').renameTo(new File(projectDir, '.gitignore'))