package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable createException(Enum exceptionEnum) {

        if (exceptionEnum != null) {
            String enumValueName = exceptionEnum.toString().replace('_', ' ');
            String message = enumValueName.charAt(0) + enumValueName.substring(1).toLowerCase();

            if (exceptionEnum.getClass().isAssignableFrom(ApplicationExceptionMessage.class)) {
                return new Exception(message);

            } else if (exceptionEnum.getClass().isAssignableFrom(DatabaseExceptionMessage.class)) {
                return new RuntimeException(message);

            } else if (exceptionEnum.getClass().isAssignableFrom(UserExceptionMessage.class)) {
                return new Error(message);
            }
        }

        return new IllegalArgumentException();
    }
}
