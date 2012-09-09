grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve

    repositories {
        inherits true // Whether to inherit repository definitions from plugins
        grailsPlugins()
        grailsHome()
        grailsCentral()
		mavenLocal()		
        mavenCentral()
    }
	
	def seleniumVersion = '2.23.1'	
	
    dependencies {
		compile('org.codehaus.groovy.modules.http-builder:http-builder:0.5.2') {
			excludes 'xalan'
			excludes 'xml-apis'
			excludes 'groovy'
		}
		test "org.codehaus.geb:geb-spock:0.7.0"
		test ("org.seleniumhq.selenium:selenium-htmlunit-driver:$seleniumVersion") {
			exclude "xml-apis"
		}
		test "org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion"
		test "org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion"
		test "org.seleniumhq.selenium:selenium-support:$seleniumVersion"
		test 'com.github.robfletcher:betamax:1.0'
		test 'org.apache.httpcomponents:httpmime:4.1.3'
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.7.1"
        runtime ":resources:1.1.6"

        build ":tomcat:$grailsVersion"
		
		test ':spock:0.6'
		test ':geb:0.7.0'
		test ':remote-control:1.2'
		test ':cucumber:0.6.0'
    }
}
