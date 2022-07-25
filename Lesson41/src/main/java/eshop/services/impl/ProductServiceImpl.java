package eshop.services.impl;

import eshop.PagesPathEnum;
import eshop.entities.Category;
import eshop.entities.Image;
import eshop.entities.Product;
import eshop.repositories.impl.ImageRepositoryImpl;
import eshop.repositories.impl.ProductRepositoryImpl;
import eshop.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepositoryImpl productRepository;
    private ImageRepositoryImpl imageRepository;

    public ProductServiceImpl(ProductRepositoryImpl productRepository, ImageRepositoryImpl imageRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void create(Product entity) {
        productRepository.create(entity);
    }

    @Override
    public List<Product> read() {
        return productRepository.read();
    }

    @Override
    public void update(Product entity) {
        productRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public ModelAndView getCategoryPage(int id, String name) {
        ModelMap modelMap = new ModelMap();
        List<Product> products = productRepository.getProductsByIdCategory(id);
        Category category = Category.builder().id(id).name(name).products(products).build();
        List<Image> images = imageRepository.getImagesProductsByCategory(id);
        modelMap.addAttribute("category", category);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.CATEGORY_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView getProductPage(int id) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.getProductById(id);
        Image image = imageRepository.getImageByIdProduct(id);
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("image", image);
        return new ModelAndView(PagesPathEnum.PRODUCT_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView findAllProductsByRequest(String search) {
        ModelMap modelMap = new ModelMap();
        List<Product> products = productRepository.findProductsByRequest(search);
        List<Image> images = imageRepository.getImagesByListProducts(products);
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.SEARCH_PAGE.getPath(), modelMap);
    }
}
