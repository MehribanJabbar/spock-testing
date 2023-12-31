package az.ingress.ms.controller;

import az.ingress.ms.model.request.SaveProductRequest;
import az.ingress.ms.model.request.UpdateProductRequest;
import az.ingress.ms.model.response.ProductResponse;
import az.ingress.ms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(OK)
    public List<ProductResponse> getAllProducts(){
       return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveProduct(@RequestBody SaveProductRequest request){
        productService.createProduct(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest productRequest){
        productService.updateProduct(id, productRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
