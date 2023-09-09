package com.u2d.resource;

import com.u2d.repository.dto.CreateCustomer;
import com.u2d.repository.entity.Customer;
import com.u2d.repository.repository.CustomerRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResouce {

    @Inject
    private CustomerRepository customerRepository;

    @GET
    public Response findAll(){
        var response = customerRepository.findAll();
        return response.list().isEmpty() ? Response.noContent().build() : Response.ok(response.list()).build();
    }

    @POST
    @Transactional
    public Response create(CreateCustomer createCustomer){
        customerRepository.persist(Customer.builder()
                        .name(createCustomer.getName())
                        .birth(createCustomer.getBirth())
                .build());
        return Response.status(Response.Status.CREATED).build();
    }
}
