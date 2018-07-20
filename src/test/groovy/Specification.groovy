import spock.lang.*
import groovyx.net.http.RESTClient

// Hit 'Run Script' below
class MyFirstSpec extends Specification {
	

    RESTClient restClient = new RESTClient("http://192.168.99.100:7801")
	
/*
	def "let's try this!"() {
		expect:
		Math.max(1, 2) == 3
	}
*/	
	def 'Check if we can find multiple cities'() {
		given:
        String petid = "2"
        
		when:
        def response = restClient.get( path: '/v2/pet/getPetsById', query: ['petId' : petid])

        then:
        assert response.status == 200

        and:
        response.responseData.nombre == expectedResult

        where:
        petid            | expectedResult
        "2"  | "Fido"
        "3"  | "Dico"
        "4"   | "Brussels"
    }
}