package JetBulb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotationConverter {
    final char[] literals = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    final int[] values = {1, 5, 10, 50, 100, 500, 1000};

    public int toArabic(String romanNotation) throws InvalidValueException {
        if (romanNotation == null || romanNotation.isBlank()) {
            throw new InvalidValueException("String must contain only valid roman numerals\n" +
                    "[I, V, X, L, C, D, M].");
        } else {
            int result = 0;
            char[] romanChars = romanNotation.toCharArray();
            List<Integer> list = new ArrayList<>();
            List<Integer> sortedList = new ArrayList<>();
            for (int i = 0; i < romanChars.length; i++) {
                for (int k = 0; k < literals.length; k++) {
                    if (romanChars[i] == literals[k]) {
                        list.add(values[k]);
                        sortedList.add(values[k]);
                    }
                }
            }
            System.out.println(list);
            for (int i = 0; i < sortedList.size(); i++) {
                Collections.sort(sortedList);
                int min = Collections.min(sortedList);
                System.out.println("min = " + min);
                System.out.println(sortedList);
                System.out.println(sortedList.indexOf(min));
                System.out.println(sortedList.size());
                if (sortedList.size() == 1) {
                    result += min;
                } else {
                    if (min == sortedList.get(sortedList.indexOf(min) + 1)) {
                        result += min;
                        sortedList.remove(sortedList.indexOf(min));
                    } else {
                        int firstSearchedNumberIndex = 0;
                        int secondSearchedNumberIndex = 0;
                        int firstSearchedNumber = 0;
                        int secondSearchedNumber = 0;
                        boolean firstNumberIsUnknown = true;
                        boolean secondNumberIsUnknown = true;
                        for(int k = list.size() - 1; k > 0; k--){
                            if(list.get(k).equals(sortedList.get(i)) && firstNumberIsUnknown){
                                System.out.println("1. " + firstNumberIsUnknown);
                                firstSearchedNumberIndex = k;
                                firstNumberIsUnknown = false;
                                list.remove(k);
                                k--;
                                System.out.println("2. " + firstNumberIsUnknown);
                            }
                            if(list.get(k).equals(sortedList.get(i + 1)) && secondNumberIsUnknown){
                                System.out.println("3. " + secondNumberIsUnknown);
                                secondSearchedNumberIndex = k;
                                secondNumberIsUnknown = false;
                                list.remove(k);
                                System.out.println("4. " + secondNumberIsUnknown);
                                //k--;
                            }
                        }
                        System.out.println("ffff" + firstSearchedNumberIndex);
                        System.out.println("ffff" + secondSearchedNumberIndex);
                        System.out.println(list.size());
                        System.out.println(list);
                        System.out.println(sortedList);
                        System.out.println(sortedList.size());
                        System.out.println(i);

                        if((firstSearchedNumberIndex - 1 < secondSearchedNumberIndex - 1) &&
                                (sortedList.get(firstSearchedNumberIndex) > sortedList.get(secondSearchedNumberIndex))){
                            result += list.get(i) + list.get(i + 1);
                        } else{
                            if(list.size() == 1){
                                result += list.get(i);
                            }
                            else{
                                result += list.get(i + 1) - list.get(i);
                            }
                        }
//                        result += ((firstSearchedNumberIndex - 1 < secondSearchedNumberIndex - 1) &&
//                                (sortedList.get(firstSearchedNumberIndex) > sortedList.get(secondSearchedNumberIndex))) ?
//                                (list.get(i) + list.get(i + 1)) :
//                                (list.get(i + 1) - list.get(i));
//                        sortedList.remove(sortedList.get(i));
//                        sortedList.remove(sortedList.get(i));
//                        System.out.println(sortedList.size());
                    }
                    //i--;
                }
            }
            System.out.println(sortedList);
            return result;
        }
    }
}
