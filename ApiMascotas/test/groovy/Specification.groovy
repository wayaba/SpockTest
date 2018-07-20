import groovyx.net.http.RESTClient
import spock.lang.Specification

class RestSpecification extends Specification {

    RESTClient restClient = new RESTClient("http://192.168.99.100:7801")

    def 'Check if the weather in Eindhoven can be found'() {
        given:
        String petid = "2"

        when:
        def response = restClient.get( path: '/v2/pet/getPetsById',
                query: ['petId' : petid])

        then:
        response.status == 200

        and:
        response.responseData.name == "Eindhoven"
    }

    def 'Check if we can find multiple cities'() {
        when:
        def response = restClient.get( path: '/v2/pet/getPetsById', query: ['petId' : petid])

        then:
        assert response.status == 200

        and:
        response.responseData.name == expectedResult

        where:
        petid            | expectedResult
        "2"  | "Fido"
        "3"  | "Dico"
        "4"   | "Brussels"
    }
}