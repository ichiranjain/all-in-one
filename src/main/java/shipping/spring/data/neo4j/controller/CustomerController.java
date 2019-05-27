package shipping.spring.data.neo4j.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import shipping.spring.data.neo4j.domain.Address;
import shipping.spring.data.neo4j.domain.Order;
import shipping.spring.data.neo4j.domain.Person;
import shipping.spring.data.neo4j.repositories.AddressRepository;
import shipping.spring.data.neo4j.repositories.OrderRepository;
import shipping.spring.data.neo4j.repositories.PersonRepository;
import shipping.spring.data.neo4j.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

/**
 * @author
 * @author
 */
@RestController
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private OrderRepository orderRepository;

	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

    @GetMapping("/graph")
	public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return customerService.graph(limit == null ? 100 : limit);
//		return new HashMap<String, Object>();
	}


//	@PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
//	public void addMember(@RequestBody Member member) {
//		//code
//	}

	@GetMapping(value="/savegraph")
	public String createPurchases() {
		Address address = new Address("streetName1", 1, "SanJose", 95134L);

		addressRepository.save(address);

		Person keanu = new Person("Keanu Reeves", 1964);
		personRepository.save(keanu);
		//personRepository.save(keanu);

		//		Role neo = new Role(address, keanu);
		//		neo.addRoleName("Neo");
		//
		//		keanu.addRole(neo);
		//keanu.addAddress(address);
		address.addPerson(keanu);


		addressRepository.save(address);

		Order orderDetails = new Order(1L, "Sports");
		orderRepository.save(orderDetails);

		Address srcAddr = new Address("streetNameSrc", 2, "SanJose", 95132L);
		Address destAddr = new Address("streetNameDest", 3, "SanJose", 95134L);
		orderDetails.addSourceAddress(srcAddr);
		orderDetails.addDestinationAddress(destAddr);
		orderDetails.addPerson(keanu);

		orderRepository.save(orderDetails);


		return "Successfully created entities";
	}
	@GetMapping("/graphAdd")
	public Map<String, Object> graphAdd(@RequestParam(value = "limit",required = false) Integer limit) {
		return customerService.graphAdd(limit == null ? 100 : limit);
		//return new HashMap<String, Object>();
	}

	@GetMapping("/graphOrder")
	public Map<String, Object> graphOrder(@RequestParam(value = "limit",required = false) Integer limit) {
		return customerService.graphOrder(limit == null ? 100 : limit);
		//		return new HashMap<String, Object>();
	}
}
