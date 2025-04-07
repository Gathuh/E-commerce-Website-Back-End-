package com.gathu.ecommerce.product;

import com.gathu.ecommerce.exception.ProductPurchaseException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {


    private final ProductRepository repository;
    private final ProductMapper mapper;
    public  Integer createProduct(ProductRequest request) {
      Product product=  mapper.toProduct(request);
    return repository.save(product).getId();
    }

    public List<ProductPurchaseResponse> purchase(List<ProductPurchaseRequest> request) {
        var productIds= request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .collect(Collectors.toList());
        var storedProducts = repository.findByIdInOrderById(productIds);
        if (productIds.size() !=storedProducts.size()){
            throw  new ProductPurchaseException("One or more products is not available");

        }
        var storedRequest=request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();
            var purchasedProducts= new ArrayList<ProductPurchaseResponse>();
            for( int i =0; i<storedProducts.size(); i++){
                var product=storedProducts.get(i);
                var productRequest=storedRequest.get(i);
                if(product.getAvailableQuantity()<productRequest.quantity()){
                    throw new ProductPurchaseException("Insufficient quantity");

                }

                var newAvailableQuantity=product.getAvailableQuantity()-productRequest.quantity();
                product.setAvailableQuantity(newAvailableQuantity);
                repository.save(product);
                purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
            }
        return purchasedProducts;
    }

    public ProductResponse findById(Integer id) {
    Product product=repository.findById(id).orElseThrow(()-> new EntityNotFoundException(String.format("Prodect with ID %i was not found",id)));
    ProductResponse productResponse=mapper.toResponse(product);

        return productResponse;
    }

    public List<ProductResponse> findAll() {
        List<Product> product= repository.findAll();

        return product.stream().map(mapper::toResponse).collect(Collectors.toList());
    }
}