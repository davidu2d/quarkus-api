package com.u2d.resource;

import com.u2d.activerecord.dto.CreateProduct;
import com.u2d.activerecord.entity.Product;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public Response findAll(){
        var response = Product.findAll();
        return response.list().isEmpty() ? Response.noContent().build() : Response.ok(response.list()).build();
    }

    @POST
    @Transactional
    public Response create(CreateProduct createProduct){
        Product product = Product.builder()
                .name(createProduct.getName())
                .price(createProduct.getPrice()).build();
        product.persist();
        return Response.status(Response.Status.CREATED).build();
    }
}
