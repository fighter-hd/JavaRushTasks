package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData incomeData) {
            data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            String key = data.getCountryCode();
            String countryName = countries.get(key);

            return countryName;
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            int intNumber = data.getPhoneNumber();

            String strNumber = String.valueOf(intNumber);
            if (strNumber.length() < 10) {
                for (int i = 10 - strNumber.length(); i > 0; i--) {
                    strNumber = "0" + strNumber;
                }
            } else {
                strNumber = String.valueOf(intNumber);
            }

            String fullNumber = "+" + data.getCountryPhoneCode() + "("
                    + strNumber.substring(0, 3) + ")"
                    + strNumber.substring(3, 6) + "-"
                    + strNumber.substring(6, 8) + "-"
                    + strNumber.substring(8, 10);

            return fullNumber;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}