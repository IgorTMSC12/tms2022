package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
    public ModelAndView findAllProductsByRequest(String search, int page) {
        ModelMap modelMap = new ModelMap();
        List<Product> products = productRepository.findProductsByRequest(search, page);
        long numberPages = productRepository.countAllProductsByRequest(search);
        List<Long> listPages = new ArrayList<>();
        for (long i = 1; i <= numberPages; i++) {
            listPages.add(i);
        }
        List<Image> images = new ArrayList<>();
        for (Product product : products) {
            Image image = imageRepository.getImageByIdProduct(product.getId());
            if (images.size() == 0) {
                images.add(image);
            }
            int count = 0;
            for (int i = 0; i < images.size(); i++) {
                if (!(images.get(i).getProduct().getId() == image.getProduct().getId())) {
                    count++;
                }
                if (count == images.size()) {
                    images.add(image);
                }
            }
        }
        modelMap.addAttribute("number_of_pages", listPages);
        modelMap.addAttribute("search", search);
        modelMap.addAttribute("products", products);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.SEARCH_PAGE.getPath(), modelMap);
    }
}
