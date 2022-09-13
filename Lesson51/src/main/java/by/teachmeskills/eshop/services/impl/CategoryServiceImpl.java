package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.entities.Image;
import by.teachmeskills.eshop.repositories.impl.CategoryRepositoryImpl;
import by.teachmeskills.eshop.repositories.impl.ImageRepositoryImpl;
import by.teachmeskills.eshop.services.CategoryService;
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
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepositoryImpl categoryRepository;
    private ImageRepositoryImpl imageRepository;

    public CategoryServiceImpl(CategoryRepositoryImpl categoryRepository, ImageRepositoryImpl imageRepository) {
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public void create(Category entity) {
        categoryRepository.create(entity);
    }

    @Override
    public List read() {
        return categoryRepository.read();
    }

    @Override
    public void update(Category entity) {
        categoryRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }

    @Override
    public ModelAndView getAllCategories() {
        ModelMap modelMap = new ModelMap();
        List<Category> categories = read();
        List<Image> images = imageRepository.getAllImagesCategories();
        modelMap.addAttribute("categories", categories);
        modelMap.addAttribute("images", images);
        return new ModelAndView(PagesPathEnum.HOME_PAGE.getPath(), modelMap);
    }

    @Override
    public void exportToFile(Writer writer) {
        try {
            List<Category> categories = read();
            StatefulBeanToCsv statefulBeanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            statefulBeanToCsv.write(categories);
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void importFromFile(MultipartFile file) {
        if (Optional.ofNullable(file).isPresent()) {
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CsvToBean<Category> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Category.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSeparator(',')
                        .build();
                List<Category> categories = csvToBean.parse();
                if (Optional.ofNullable(categories).isPresent() && categories.size() > 0) {
                    categories.stream().forEach(categoryRepository::create);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
