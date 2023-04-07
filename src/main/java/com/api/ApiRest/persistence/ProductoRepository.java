package com.api.ApiRest.persistence;

import com.api.ApiRest.domain.Product;
import com.api.ApiRest.domain.repository.ProductRepository;
import com.api.ApiRest.persistence.crud.ProductCrudRepository;
import com.api.ApiRest.persistence.entity.Producto;
import com.api.ApiRest.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> products = (List<Producto>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProduct(int quantity) {
        Optional<List<Producto>> productos = productCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }


}
