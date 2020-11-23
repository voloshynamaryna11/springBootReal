package startspringboot.demo.mapper;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import startspringboot.demo.dto.DataDto;
import startspringboot.demo.model.Product;

public class ProductMapperTest {
    private DataDto dataDtoOk = new DataDto();
    private ProductMapper productMapper = new ProductMapper();

    @Before
    public void init() {
        dataDtoOk.setProductId("3");
    }

    @Test
    public void map_ok() {
        Product expectedProduct = new Product();
        expectedProduct.setProductId("3");
        Assert.assertEquals(expectedProduct, productMapper.mapToProduct(dataDtoOk));
    }

    @Test
    public void map_empty() {
        Assert.assertEquals(new Product(), productMapper.mapToProduct(new DataDto()));
    }
}
