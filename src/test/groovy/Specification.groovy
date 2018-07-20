import spock.lang.Shared
import spock.lang.Specification
 
class ExampleSpec extends Specification {
 
    def message = "Hello world!"
 
    def setup() {
        println "Setup"
    }
 
    def cleanup() {
        println "Clean up"
    }
 
    def setupSpec() {
        println "Setup specification"
    }
 
    def cleanupSpec() {
        println "Clean up specification"
    }
 
    def "first feature method"() {
        println "First feature method"
 
        when: "Message is transformed into lowercase"
        message = message.toLowerCase()
 
        then: "Should transform message into lowercase"
        message == "hello world!"
    }
 
    def "second feature method"() {
        println "Second feature method"
 
        when: "Message is transformed into uppercase"
        message = message.toUpperCase()
 
        then: "Should transform message into uppercase"
        message == "HELLO WORLD!"
    }
}