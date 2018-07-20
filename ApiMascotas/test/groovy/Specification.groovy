import groovyx.net.http.RESTClient
import spock.lang.Specification

class FirstSpecification extends Specification {

RESTClient restClient = new RESTClient("http://192.168.99.100:7801", JSON)

def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }
def "Get all pet"() {
       
       when: "get all arrivals"
       def response = restClient.get(
               path: '/v2/pet',
               requestContentType: JSON
       )

       then: "Status is 200"
       response.status == 200

       and: "Body contains proper values"
       assert response.data[0].id == 1
   }

}