includeTargets << grailsScript("_GrailsInit")

target(main: "The description of the script goes here!") {

    ant.echo(message: 'Copy templates to src/templates')

    ant.copy(todir: 'src/templates') {
        fileset(dir: "${pluginLocation}/src/templates")
    }

}

def getBuildConfig() {
    GroovyClassLoader classLoader = new GroovyClassLoader(getClass().classLoader)
    new ConfigSlurper().parse(classLoader.loadClass('BuildConfig'))
}

def getPluginLocation() {
    buildConfig?.grails?.plugin?.location?.'tb-templates-plugin'
}

setDefaultTarget(main)
