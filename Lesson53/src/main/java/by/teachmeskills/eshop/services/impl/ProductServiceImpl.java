package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.dto.SearchParamsDto;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ImageRepository;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.ProductSearchSpecification;
import by.teachmeskills.eshop.services.ProductService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    private ProductRepository productRepository;
    private ImageRepository imageRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ImageRepository imageRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.imageRepository = imageRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void create(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public void update(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public ModelAndView getCategoryPage(int id) {
        ModelMap modelMap = new ModelMap();
        Category category = categoryRepository.getCategoryById(id);
        List<Image> images = imageRepository.getImagesByCategoryId(id);
        modelMap.addAttribute("category", category);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.CATEGORY_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView getProductPage(int id) {
        ModelMap modelMap = new ModelMap();
        Product product = productRepository.getProductById(id);
        Image image = imageRepository.getImageByProductId(id);
        modelMap.addAttribute("product", product);
        modelMap.addAttribute("image", image);
        return new ModelAndView(PagesPathEnum.PRODUCT_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView findAllProductsByRequest(SearchParamsDto searchParamsDto, int pageNumber, int pageSize) {
        ModelMap modelMap = new ModelMap();
        ProductSearchSpecification productSearchSpecification = new ProductSearchSpecification(searchParamsDto);
        Pageable paging = PageRequest.of(pageNumber, pageSize, Sort.by("name").ascending());
        Page<Product> products = productRepository.findAll(productSearchSpecification, paging);
        List<Product> newProducts = products.getContent();
        int size = products.getTotalPages();
        List<Integer> countPage = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            countPage.add(i);
        }
        List<Image> images = new ArrayList<>();
        for (Product product : newProducts) {
            Image image = imageRepository.getImageByProductId(product.getId());
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
        modelMap.addAttribute("countPage", countPage);
        modelMap.addAttribute("pageSize", pageSize);
        modelMap.addAttribute("search", searchParamsDto);
        modelMap.addAttribute("products", newProducts);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.SEARCH_PAGE.getPath(), modelMap);
    }

    public void exportToFile(Writer writer, int categoryId) {
        try {
            List<Product> products = productRepository.getProductsByCategoryId(categoryId);
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
                    products.stream().forEach(productRepository::save);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}

