package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    public static class Goods {
        @XmlElement
        List<String> names = new ArrayList<>();

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            if (! names.isEmpty()) {

                for (String good: names) {
                    builder.append(good);
                    builder.append(", ");
                }

                builder.deleteCharAt(builder.length() - 1);
                builder.deleteCharAt(builder.length() - 1);

                return builder.toString();
            } else {
                return "no goods";
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (secretData.length > 0) {
            for (String data: secretData) {
                builder.append(data);
                builder.append(", ");
            }

            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
        }

        return "Shop{\n" +
                "   goods = " + goods.toString() +
                "\n   count = " + count +
                "\n   profit = " + profit +
                "\n   secretData = " + builder.toString() +
                "\n}";
    }
}
