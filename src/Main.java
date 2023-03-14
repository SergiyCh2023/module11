import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {



    }

    public static String createStringNamesMethod(List<String> listNames) {
        String result = "";
        List<String> listResult = listNames.stream()
                .filter(e -> listNames.indexOf(e) % 2 != 0)
                .map(e -> new String(listNames.indexOf(e) + "." + e))
                .collect(Collectors.toList());

        for (int i = 0; i < listResult.size(); i++) {
            if (i != listResult.size() - 1) result += listResult.get(i) + " ";
            else result += listResult.get(i);
        }
        return result;
    }



    public static List<String> upperCaseSortMethod(List<String> list) {
        List<String> result = list.stream()
                .map(s -> s.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return result;
    }



    public static String  unitedSortedNumbers (String [] array) {
        List<String> result =Arrays.asList(array).stream()
                .map(s -> s.split("\\,"))
                .flatMap(Arrays::stream)
                .map(s -> s.trim())
                .sorted()
                .collect(Collectors.toList());

        return String.join(",", result);
    }



    public static Stream<Long> infinityLongStream(Long seed, Long a, Long c, Long m) {
        return Stream.iterate(seed, value->(a*value+c)%m);
    }


    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List <T> firstList = first.collect(Collectors.toList());
        List <T> secondList = second.collect(Collectors.toList());
        List<T> united = new ArrayList<>();
        int counter1=0;
        int counter2=0;
        int counter3=0;
        while (firstList.size()>counter2 && secondList.size()>counter3){
            if (counter1%2 == 0) united.add(counter1++, firstList.get(counter2++));
            else united.add(counter1++, secondList.get(counter3++));
        }
        return united.stream();
    }


}
