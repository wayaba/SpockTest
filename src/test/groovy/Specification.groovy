import spock.lang.*
import groovyx.net.http.RESTClient

// Hit 'Run Script' below
class MyFirstSpec extends Specification {
	
	RESTClient restClient = new RESTClient("http://192.168.99.100:7801", JSON)
	def "let's try this!"() {
		expect:
		Math.max(1, 2) == 3
	}
}