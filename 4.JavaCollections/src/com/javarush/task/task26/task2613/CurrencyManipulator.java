package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<>();
    }

    public void addAmount(int denomination, int count) {
        Integer previousAmountByNominal = denominations.get(denomination);

        if (previousAmountByNominal != null) {
            count += previousAmountByNominal;
        }

        denominations.put(denomination, count);
    }

    public int getTotalAmount() {
        int totalAmount = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            totalAmount += entry.getKey() * entry.getValue();
        }

        return totalAmount;
    }

    public boolean hasMoney() {
        if (getTotalAmount() <= 0) {
//            ConsoleHelper.writeMessage("No money available.");
            return false;
        }

        return true;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> sortedWithdrawnBills = new TreeMap<>(Collections.reverseOrder());
        sortedWithdrawnBills.putAll(this.denominations);

        Set<Map<Integer, Integer>> allVariants = getAllVariantsSet(sortedWithdrawnBills.keySet(), expectedAmount);

        removeInvalidVariants(allVariants);

        if (allVariants.isEmpty()) {
            throw new NotEnoughMoneyException();
        }

        Set<Map<Integer, Integer>> variantsWithSmallestNumberOfBills = getVariantsWithSmallestNumberOfBills(allVariants);

        Map<Integer, Integer> optimalVariant = getOptimalVariant(variantsWithSmallestNumberOfBills);

        removeWithdrawnBills(optimalVariant);

        return optimalVariant;
    }

    private Set<Map<Integer, Integer>> getAllVariantsSet(Set<Integer> sortedNominalSet, int expectedAmount) {
        Set<Map<Integer, Integer>> allVariants = new HashSet<>();

        Set<Integer> sortedNominalSetCopy = new TreeSet<>(Collections.reverseOrder());
        sortedNominalSetCopy.addAll(sortedNominalSet);

        while (sortedNominalSetCopy.stream().findFirst().isPresent()) {
            int nominal = sortedNominalSetCopy.stream().findFirst().get();

            Map<Integer, Integer> variantForNominal = getVariantForNominal(sortedNominalSetCopy, nominal, expectedAmount);

            if (isVariantAmountEqualsExpectedAmount(variantForNominal, expectedAmount)) {
                allVariants.add(variantForNominal);
            }

            sortedNominalSetCopy.remove(nominal);
        }

        return allVariants;
    }

    private Map<Integer, Integer> getVariantForNominal(Set<Integer> sortedNominalSet, int nominal, int expectedAmount) {
        Set<Integer> sortedNominalSetCopy = new TreeSet<>(Collections.reverseOrder());
        sortedNominalSetCopy.addAll(sortedNominalSet);

        Map<Integer, Integer> variantForCurrentNominal = new TreeMap<>(Collections.reverseOrder());

        int maxCountOfRequiredBillsForAmount = getMaximumCountOfRequiredBillsForAmount(nominal, expectedAmount);

        int amountByCurrentNominalBills = 0;

        if (maxCountOfRequiredBillsForAmount > 0) {
            amountByCurrentNominalBills = nominal * maxCountOfRequiredBillsForAmount;
            variantForCurrentNominal.put(nominal, maxCountOfRequiredBillsForAmount);

            if (amountByCurrentNominalBills == expectedAmount) {
                return variantForCurrentNominal;
            }
        }

        if (sortedNominalSetCopy.remove(nominal)) {
            if (sortedNominalSetCopy.stream().findFirst().isPresent()) {
                int nextSmallestNominal = sortedNominalSetCopy.stream().findFirst().get();
                variantForCurrentNominal.putAll(getVariantForNominal(sortedNominalSetCopy, nextSmallestNominal, expectedAmount - amountByCurrentNominalBills));
            }
        }

        return variantForCurrentNominal;
    }

    private boolean isVariantAmountEqualsExpectedAmount(Map<Integer, Integer> variant, int expectedAmount) {
        int variantAmount = 0;

        for (Map.Entry<Integer, Integer> entry : variant.entrySet()) {
            int nominal = entry.getKey();
            int count = entry.getValue();

            variantAmount += nominal * count;
        }

        return variantAmount == expectedAmount;
    }

    private int getMaximumCountOfRequiredBillsForAmount(int nominal, int expectedAmount) {
        int count = 0;
        int currentAmount = nominal * count;

        while (true) {
            if (currentAmount < expectedAmount) {
                count++;

            } else if (currentAmount == expectedAmount) {
                return count;

            } else {
                count--;
                break;
            }

            currentAmount = nominal * count;
        }

        return count;
    }

    private void removeInvalidVariants(Set<Map<Integer, Integer>> allVariants) {
        Set<Map<Integer, Integer>> setForRemove = new HashSet<>();

        for (Map<Integer, Integer> currentVariant : allVariants) {
            for (Map.Entry<Integer, Integer> entry : currentVariant.entrySet()) {
                int nominal = entry.getKey();
                int count = entry.getValue();

                if (count > this.denominations.get(nominal)) {
                    setForRemove.add(currentVariant);
                }
            }
        }

        allVariants.removeAll(setForRemove);
    }

    private Set<Map<Integer, Integer>> getVariantsWithSmallestNumberOfBills(Set<Map<Integer, Integer>> allVariants) {
        Set<Map<Integer, Integer>> variantsWithSmallestNumberOfBills = new HashSet<>();
        int smallestBillsCount = getSmallestBillsCount(allVariants);

        for (Map<Integer, Integer> currentVariant : allVariants) {
            int currentVariantBillsCount = getCountOfBills(currentVariant);

            if (currentVariantBillsCount == smallestBillsCount) {
                variantsWithSmallestNumberOfBills.add(currentVariant);
            }
        }

        return variantsWithSmallestNumberOfBills;
    }

    private int getSmallestBillsCount(Set<Map<Integer, Integer>> allVariants) {
        int smallestBillsCount = Integer.MAX_VALUE;

        for (Map<Integer, Integer> currentVariant : allVariants) {
            int currentVariantBillsCount = getCountOfBills(currentVariant);

            if (currentVariantBillsCount > 0 && currentVariantBillsCount < smallestBillsCount) {
                smallestBillsCount = currentVariantBillsCount;
            }
        }

        return smallestBillsCount;
    }

    private int getCountOfBills(Map<Integer, Integer> variant) {
        int count = 0;

        for (Integer currentNominalBillsCount : variant.values()) {
            count += currentNominalBillsCount;
        }

        return count;
    }

    private Map<Integer, Integer> getOptimalVariant(Set<Map<Integer, Integer>> variantSet) throws NotEnoughMoneyException {
        int biggerNominal = getBiggerNominal(variantSet);

        Set<Map<Integer, Integer>> biggerNominalVariants = getBiggerNominalVariants(variantSet, biggerNominal);

        Map<Integer, Integer> optimalVariant = getMaximumBillsCountOfBiggerNominal(biggerNominalVariants, biggerNominal);

        return optimalVariant;
    }

    private int getBiggerNominal(Set<Map<Integer, Integer>> variantSet) {
        int biggerNominal = 0;

        for (Map<Integer, Integer> currentVariant : variantSet) {
            for (Integer currentNominal : currentVariant.keySet()) {

                if (currentNominal > biggerNominal) {
                    biggerNominal = currentNominal;
                }
            }
        }

        return biggerNominal;
    }

    private Set<Map<Integer, Integer>> getBiggerNominalVariants(Set<Map<Integer, Integer>> variantSet, int biggerNominal) {
        Set<Map<Integer, Integer>> biggerNominalVariants = new HashSet<>();

        for (Map<Integer, Integer> currentVariant : variantSet) {
            if (currentVariant.containsKey(biggerNominal)) {
                biggerNominalVariants.add(currentVariant);
            }
        }

        return biggerNominalVariants;
    }

    private Map<Integer, Integer> getMaximumBillsCountOfBiggerNominal(Set<Map<Integer, Integer>> variantsSet, int biggerNominal) throws NotEnoughMoneyException {
        int maxBillsCountOfBiggerNominal = 0;
        Set<Map<Integer, Integer>> optimalVariantsSet = new HashSet<>();
        Map<Integer, Integer> optimalVariant = null;

        for (Map<Integer, Integer> currentVariant : variantsSet) {
            int biggerNominalBillsCount = currentVariant.get(biggerNominal);

            if (biggerNominalBillsCount > maxBillsCountOfBiggerNominal) {
               maxBillsCountOfBiggerNominal = biggerNominalBillsCount;
            }
        }

        for (Map<Integer, Integer> currentVariant : variantsSet) {
            int biggerNominalBillsCount = currentVariant.get(biggerNominal);

            if (biggerNominalBillsCount == maxBillsCountOfBiggerNominal) {
                optimalVariantsSet.add(currentVariant);
            }
        }

        if (optimalVariantsSet.size() == 1) {
            for (Map<Integer, Integer> current : optimalVariantsSet) {
                optimalVariant = current;
            }

        } else if (optimalVariantsSet.size() > 1) {
            Set<Map<Integer, Integer>> copySet = new HashSet<>(optimalVariantsSet);
            copySet.remove(biggerNominal);
            int nextLowerNominal = getBiggerNominal(copySet);
            optimalVariant = getMaximumBillsCountOfBiggerNominal(optimalVariantsSet, nextLowerNominal);

        } else {
            throw new NotEnoughMoneyException();
        }

        return optimalVariant;
    }

    private void removeWithdrawnBills(Map<Integer, Integer> withdrawnBills) {
        for (Map.Entry<Integer, Integer> entry : withdrawnBills.entrySet()) {
            int nominal = entry.getKey();
            int withdrawCount = entry.getValue();
            int amountAtATM = this.denominations.get(nominal);

            int updatedAmount = amountAtATM - withdrawCount;

            if (updatedAmount > 0) {
                this.denominations.put(nominal, updatedAmount);

            } else {
                this.denominations.remove(nominal);
            }
        }
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
