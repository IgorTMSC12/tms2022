package task2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StorageProducts {

    private static List<Product> creatProducts() {
        Product mobil1 = new Product(1, 1, "Huawei_nova9_SE.png", "Huawei nova 9 SE",
                "Android, экран 6.78, IPS (1080x2388), Qualcomm Snapdragon 680, ОЗУ 8 ГБ," +
                        " флэш-память 128 ГБ, карты памяти, камера 108 Мп, аккумулятор 4000 мАч, 2 SIM", 939);
        Product mobil2 = new Product(2, 1, "Apple_iPhone13.png", "Apple iPhone 13",
                "Apple iOS, экран 6.1, OLED (1170x2532), Apple A15 Bionic, ОЗУ 4 ГБ," +
                        " флэш-память 128 ГБ, камера 12 Мп, аккумулятор 3227 мАч, 1 SIM", 2500);
        Product mobil3 = new Product(3, 1, "Samsung_GalaxyA52.png", "Samsung Galaxy A52",
                "Android, экран 6.5, AMOLED (1080x2400), Qualcomm Snapdragon 720G, ОЗУ 4 ГБ," +
                        " флэш-память 128 ГБ, карты памяти, камера 64 Мп, аккумулятор 4500 мАч, 2 SIM", 770);

        Product laptop1 = new Product(4, 2, "HP_255_G8.png", "HP 255 G8",
                "15.6, 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Athlon Silver 3050U 2300 МГц," +
                        " 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, без ОС, цвет крышки серебристый", 1448);
        Product laptop2 = new Product(5, 2, "Lenovo_IdeaPad3.png", "Lenovo IdeaPad 3",
                "15.6, 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Ryzen 3 5300U 2600 МГц," +
                        " 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, без ОС, цвет крышки серый", 1790);
        Product laptop3 = new Product(6, 2, "HP_Pavilion15.png", "HP Pavilion 15",
                "15.6, 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Ryzen 5 5500U 2100 МГц," +
                        " 8 ГБ DDR4, SSD 512 ГБ, видеокарта встроенная, без ОС, цвет крышки синий", 2499);

        Product gps_navigator1 = new Product(7, 3, "Roadmax_Uno.png", "Roadmax Uno",
                "экран 7, TFT (800 x 480), ОЗУ 256 Мб, флэш-память 8 Гб, Windows CE 6.0", 199);
        Product gps_navigator2 = new Product(8, 3, "NAVITEL_E707.png", "NAVITEL E707",
                "экран 7, TFT (800 x 480), процессор MStar MSB2531 800 МГц, флэш-память 8 Гб, Linux", 349);
        Product gps_navigator3 = new Product(9, 3, "GEOFOX_MID743GPS.png", "GEOFOX MID743GPS",
                "экран 7, IPS (1024 x 600), процессор MediaTek MT8321 1300 МГц, ОЗУ 1 Гб, флэш-память 32 Гб," +
                        " 3G, камера 5 Мп, Android 6.0 Marshmallow", 259);

        Product fridges1 = new Product(10, 4, "ATLANT_ХМ.png", "ATLANT ХМ",
                "встраиваемый, без No Frost, механическое управление, класс A, полезный объём:" +
                        " 234 л (167 + 67 л), перенавешиваемые двери, лоток для яиц, 54x56x178 см, белый", 1250);
        Product fridges2 = new Product(11, 4, "Samsung_fridges.png", "Samsung RB33A3440WW/WT",
                "отдельностоящий, полный No Frost, электронное управление, класс A+, полезный объём:" +
                        " 328 л (230 + 98 л), инверторный компрессор, перенавешиваемые двери, выдвижная полка," +
                        " складная полка, лоток для яиц, 59.5x67.5x185 см, белый", 2148);
        Product fridges3 = new Product(12, 4, "Bosch_Serie6.png", "Bosch Serie 6",
                "отдельностоящий, полный No Frost, электронное управление, класс A++, полезный объём:" +
                        " 388 л (280 + 108 л), инверторный компрессор, зона свежести, перенавешиваемые двери," +
                        " складная полка, полка для вина, лоток для яиц, 60x66x203 см, белый", 2483);

        Product car1 = new Product(13, 5, "BMW_3.png", "BMW 3 seria",
                "2.0 бензин, седан, передний привод", 60000);
        Product car2 = new Product(14, 5, "AUDI_A6.png", "AUDI A6",
                "4.0 бензин, полный привод, 2018 год", 72000);
        Product car3 = new Product(15, 5, "opel_insignia.png", "Opel Insignia",
                "2.2 бензин, 180 л.с, передний привод, 2014 год", 35000);

        Product camera1 = new Product(16, 6, "Canon_EOS_R6.png", "Canon EOS R6",
                "беззеркальная камера, байонет Canon RF, матрица Full frame (полный кадр) 20.1 Мп," +
                        " без объектива (body), Wi-Fi, два слота для карт памяти", 7600);
        Product camera2 = new Product(17, 6, "Sony_Alpha_a7.png", " Sony Alpha a7",
                "беззеркальная камера, байонет Sony E, матрица Full frame (полный кадр) 24.2 Мп, без" +
                        " объектива (body), Wi-Fi, два слота для карт памяти", 6650);
        Product camera3 = new Product(18, 6, "Canon_EOS_6D.png", "Canon EOS 6D",
                "зеркальная камера, байонет Canon EF, матрица Full frame (полный кадр) 26 Мп, без" +
                        " объектива (body), Wi-Fi", 3640);

        List<Product> products = Arrays.asList(mobil1, mobil2, mobil3, laptop1, laptop2, laptop3, fridges1,
                fridges2, fridges3, gps_navigator1, gps_navigator2, gps_navigator3, car1, car2, car3, camera1, camera2, camera3);

        return products;
    }

    public static List<Product> getProductByIdCategory(int idCategory) {
        ArrayList<Product> productsByIdCategory = new ArrayList<>();
        for (Product product : creatProducts()) {
            if (product.getIdCategory() == idCategory) {
                productsByIdCategory.add(product);
            }
        }
        return productsByIdCategory;
    }

    public static Product getProductById(int id) {
        List<Product> products = creatProducts();
        for (Product product : products) {
            if (product.getId() == (id)) {
                return product;
            }
        }
        return null;
    }

    public static Product getProduct(String name) {
        List<Product> products = creatProducts();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
