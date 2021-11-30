package ru.netology.graphics;

import ru.netology.graphics.image.Converter;
import ru.netology.graphics.image.Schema;
import ru.netology.graphics.image.TextGraphicsConverter;
import ru.netology.graphics.server.GServer;

import java.io.File;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        TextGraphicsConverter converter = new Converter(); // Создайте тут объект вашего класса конвертера

        GServer server = new GServer(converter); // Создаём объект сервера
        server.start(); // Запускаем

        // Или то же, но с выводом на экран:
//        String url = //"https://belplit.by/system/product_images/212609/gallery_big/Stromboli_grey_7351_S.JPG?1601018342";
//                       "https://i.ibb.co/6DYM05G/edu0.jpg";
//                      // "https://raw.githubusercontent.com/netology-code/java-diplom/main/pics/simple-test.png";
//        converter.setMaxRatio(2);
//        converter.setMaxWidth(100);
//        converter.setMaxHeight(100);
//        converter.setTextColorSchema(new Schema());
//        String imgTxt = converter.convert(url);
//        System.out.println(imgTxt);
    }
}
