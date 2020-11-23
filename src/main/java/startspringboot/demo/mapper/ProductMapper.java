package startspringboot.demo.mapper;

import org.springframework.stereotype.Component;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.model.Product;

@Component
public class ProductMapper {
    public Product mapToProduct(DataDto dataDto) {
        Product product = new Product();
        product.setProductId(dataDto.getProductId());
        return product;
    }
}
