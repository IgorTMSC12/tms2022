---------------------------------------
--  DDL for schema eshop_db
---------------------------------------
DROP SCHEMA IF EXISTS eshop_db;
CREATE SCHEMA IF NOT EXISTS eshop_db;

---------------------------------------
--  DDL for Table users
---------------------------------------
DROP TABLE IF EXISTS eshop_db.users;
CREATE TABLE IF NOT EXISTS eshop_db.users
(
    id
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    name
    VARCHAR
(
    50
) NOT NULL,
    lastname VARCHAR
(
    50
) NOT NULL,
    email VARCHAR
(
    60
) NOT NULL,
    password VARCHAR
(
    50
) NOT NULL,
    PRIMARY KEY
(
    id
));

---------------------------------------
--  DDL for Table categories
---------------------------------------
DROP TABLE IF EXISTS eshop_db.categories;
CREATE TABLE IF NOT EXISTS eshop_db.categories
(

    id
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    name
    VARCHAR
(
    50
) NOT NULL,
    raiting DOUBLE NOT NULL,
    PRIMARY KEY
(
    id
));

---------------------------------------
--  DDL for Table products
---------------------------------------
DROP TABLE IF EXISTS eshop_db.products;
CREATE TABLE IF NOT EXISTS eshop_db.products
(

    id
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    id_categiry
    NOT
    NULL,
    name
    VARCHAR
(
    100
) NOT NULL,
    description VARCHAR
(
    500
) NOT NULL,
    price INT NOT NULL,
    PRIMARY KEY
(
    id
),
    CONSTRAINT products_category_id_categories_id
    FOREIGN KEY
(
    id_category
) REFERENCES eshop_db.categories
(
    id
)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

---------------------------------------
--  DDL for Table images
---------------------------------------
DROP TABLE IF EXISTS eshop_db.images;
CREATE TABLE IF NOT EXISTS eshop_db.images
(

    id
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    id_category
    INT,
    id_product
    INT,
    image_path
    VARCHAR
(
    200
) NOT NULL,
    PRIMARY KEY
(
    id
),
    CONSTRAINT images_category_id_categories_id
    FOREIGN KEY
(
    id_category
) REFERENCES eshop_db.categories
(
    id
)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT images_product_id_categories_id
    FOREIGN KEY
(
    id_product
) REFERENCES eshop_db.products
(
    id
)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    );

---------------------------------------
--  DDL for Table orders
---------------------------------------
DROP TABLE IF EXISTS eshop_db.orders;
CREATE TABLE IF NOT EXISTS eshop_db.orders
(

    id
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    id_user
    INT
    NOT
    NULL,
    price_order
    INT
    NOT
    NULL,
    date
    DATETIME
    NOT
    NULL,
    PRIMARY
    KEY
(
    id
),
    CONSTRAINT orders_user_id_user_id
    FOREIGN KEY
(
    id_user
) REFERENCES eshop_db.users
(
    id
)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    );

---------------------------------------
--  DDL for Table order_products
---------------------------------------
DROP TABLE IF EXISTS eshop_db.order_products;
CREATE TABLE IF NOT EXISTS eshop_db.order_products
(

    id
    INT
    NOT
    NULL
    AUTO_INCREMENT,
    id_order
    INT
    NOT
    NULL,
    id_product
    INT
    NOT
    NULL,
    PRIMARY
    KEY
(
    id
),
    CONSTRAINT order_products_id_order_ordres_id
    FOREIGN KEY
(
    id_order
) REFERENCES eshop_db.orders
(
    id
)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    );

--------------------------------------------------------
--  DML for Table eshop_db.categories
--------------------------------------------------------

INSERT INTO eshop.categories (id, name, rating)
VALUES (1, 'Mobile phones', 3);
INSERT INTO eshop.categories (id, name, rating)
VALUES (2, 'Laptops', 3);
INSERT INTO eshop.categories (id, name, rating)
VALUES (3, 'GPS Navigators', 3);
INSERT INTO eshop.categories (id, name, rating)
VALUES (4, 'Fridges', 3);
INSERT INTO eshop.categories (id, name, rating)
VALUES (5, 'Cars', 3);
INSERT INTO eshop.categories (id, name, rating)
VALUES (6, 'Cameras', 3);

--------------------------------------------------------
--  DML for Table eshop_db.products
--------------------------------------------------------
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (1, 1, 'Huawei nova 9 SE',
        'Android, экран 6.78, IPS (1080x2388), Qualcomm Snapdragon 680, ОЗУ 8 ГБ,' +
        ' флэш-память 128 ГБ, карты памяти, камера 108 Мп, аккумулятор 4000 мАч, 2 SIM', 939);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (2, 1, 'Apple iPhone 13',
        'Apple iOS, экран 6.1, OLED (1170x2532), Apple A15 Bionic, ОЗУ 4 ГБ,' +
        ' флэш-память 128 ГБ, камера 12 Мп, аккумулятор 3227 мАч, 1 SIM', 2500);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (3, 1, 'Samsung Galaxy A52',
        'Android, экран 6.5, AMOLED (1080x2400), Qualcomm Snapdragon 720G, ОЗУ 4 ГБ,' +
        ' флэш-память 128 ГБ, карты памяти, камера 64 Мп, аккумулятор 4500 мАч, 2 SIM', 770);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (4, 2, 'HP 255 G8',
        '15.6, 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Athlon Silver 3050U 2300 МГц,' +
        ' 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, без ОС, цвет крышки серебристый', 1448);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (5, 2, 'Lenovo IdeaPad 3',
        '15.6, 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Ryzen 3 5300U 2600 МГц,' +
        ' 8 ГБ DDR4, SSD 256 ГБ, видеокарта встроенная, без ОС, цвет крышки серый', 1790);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (6, 2, 'HP Pavilion 15',
        '15.6, 1920 x 1080 IPS, 60 Гц, несенсорный, AMD Ryzen 5 5500U 2100 МГц,' +
        ' 8 ГБ DDR4, SSD 512 ГБ, видеокарта встроенная, без ОС, цвет крышки синий', 2499);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (7, 3, 'Roadmax Uno',
        'экран 7, TFT (800 x 480), ОЗУ 256 Мб, флэш-память 8 Гб, Windows CE 6.0', 199);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (8, 3, 'NAVITEL E707',
        'экран 7, TFT (800 x 480), процессор MStar MSB2531 800 МГц, флэш-память 8 Гб, Linux', 349);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (9, 3, 'GEOFOX MID743GPS',
        'экран 7, IPS (1024 x 600), процессор MediaTek MT8321 1300 МГц, ОЗУ 1 Гб, флэш-память 32 Гб,' +
        ' 3G, камера 5 Мп, Android 6.0 Marshmallow', 259);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (10, 4, 'ATLANT ХМ',
        'встраиваемый, без No Frost, механическое управление, класс A, полезный объём:' +
        ' 234 л (167 + 67 л), перенавешиваемые двери, лоток для яиц, 54x56x178 см, белый', 1250);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (11, 4, 'Samsung RB33A3440WW/WT',
        'отдельностоящий, полный No Frost, электронное управление, класс A+, полезный объём:' +
        ' 328 л (230 + 98 л), инверторный компрессор, перенавешиваемые двери, выдвижная полка,' +
        ' складная полка, лоток для яиц, 59.5x67.5x185 см, белый', 2148);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (12, 4, 'Bosch Series 6',
        'отдельностоящий, полный No Frost, электронное управление, класс A++, полезный объём:' +
        ' 388 л (280 + 108 л), инверторный компрессор, зона свежести, перенавешиваемые двери,' +
        ' складная полка, полка для вина, лоток для яиц, 60x66x203 см, белый', 2483);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (13, 5, 'BMW 3 seria',
        '2.0 бензин, седан, передний привод', 60000);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (14, 5, 'AUDI A6',
        '4.0 бензин, полный привод, 2018 год', 72000);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (15, 5, 'Opel Insignia',
        '2.2 бензин, 180 л.с, передний привод, 2014 год', 35000);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (16, 6, 'Canon EOS R6',
        'беззеркальная камера, байонет Canon RF, матрица Full frame (полный кадр) 20.1 Мп,' +
        ' без объектива (body), Wi-Fi, два слота для карт памяти', 7600);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (17, 6, 'Sony Alpha a7',
        'беззеркальная камера, байонет Sony E, матрица Full frame (полный кадр) 24.2 Мп, без' +
        ' объектива (body), Wi-Fi, два слота для карт памяти', 6650);
INSERT INTO eshop_db.products (id, id_category, name, description, price)
VALUES (18, 6, 'Canon EOS 6D',
        'зеркальная камера, байонет Canon EF, матрица Full frame (полный кадр) 26 Мп, без' +
        ' объектива (body), Wi-Fi', 3640);

--------------------------------------------------------
--  DML for Table eshop_db.images
--------------------------------------------------------
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (1, null, 'mobile.jpg');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (2, null, 'laptop.jpg');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (3, null, 'jps_nav.jpg');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (4, null, 'fridge.jpg');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (5, null, 'car.jpg');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (6, null, 'camera.jpg');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (1, 1, 'Huawei_nova9_SE.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (1, 2, 'Apple_iPhone13.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (1, 3, 'Samsung_GalaxyA52.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (2, 4, 'HP_255_G8.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (2, 5, 'Lenovo_IdeaPad3.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (2, 6, 'HP_Pavilion15.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (3, 7, 'Roadmax_Uno.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (3, 8, 'NAVITEL_E707.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (3, 9, 'GEOFOX_MID743GPS.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (4, 10, 'ATLANT_ХМ.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (4, 11, 'Samsung_fridges.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (4, 12, 'Bosch_Serie6.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (5, 13, 'BMW_3.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (5, 14, 'AUDI_A6.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (5, 15, 'opel_insignia.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (6, 16, 'Canon_EOS_R6.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (6, 17, 'Sony_Alpha_a7.png');
INSERT INTO eshop_db.images(id_category, id_product, image_path)
values (6, 18, 'Canon_EOS_6D.png');

--------------------------------------------------------
--  DML for Table eshop_db.users
--------------------------------------------------------
INSERT INTO eshop_db.users (name, lastname, email, password)
VALUES ('admin', 'admin', 'admin', 'admin');
INSERT INTO eshop_db.users (id, name, lastname, email, password)
VALUES ('igor', 'mixaevich', 'mixaevich@mail.ru', 'zxc');