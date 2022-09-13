package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ProductRepositoryImpl;
import by.teachmeskills.eshop.services.ProductService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepositoryImpl productRepository;
    private ImageRepositoryImpl imageRepository;
    private CategoryRepositoryImpl categoryRepository;

    public ProductServiceImpl(ProductRepositoryImpl productRepository, ImageRepositoryImpl imageRepository,
                              CategoryRepositoryImpl categoryRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
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
    public ModelAndView getCategoryPage(int id) {
        ModelMap modelMap = new ModelMap();
        Category category = categoryRepository.getCategoryById(id);
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

    public void exportToFile(Writer writer, int categoryId) {
        try {
            List<Product> products = productRepository.getProductsByIdCategory(categoryId);
            StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            statefulBeanToCsv.write(products);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.getStackTrace();
        }
    }

    public void importFromFile(MultipartFile file, int categoryId) {
        if (Optional.ofNullable(file).isPresent()) {
            Category category = categoryRepository.getCategoryById(categoryId);
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CsvToBean<Product> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Product.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSeparator(',')
                        .build();
                List<Product> products = csvToBean.parse();
                for (Product product : products) {
                    product.setCategory(category);
                }
                if (Optional.ofNullable(products).isPresent() && products.size() > 0) {
                    products.stream().forEach(productRepository::create);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}

