package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){

		if(text.equals(""))
			return 0;
        else if(text.contains("-"))
            return sum(splitNumbers(text));
        else if(text.contains("]["))
            return sum(splitNumbersWithMultipleDelimiters(text));
        else if(text.contains("//["))
            return sum(splitNumbersWithAnyLengthDelimiter(text));
        else if(text.startsWith("//"))
            return sum(splitNumbersWithCustomDelimiter(text));
        else
            return sum(splitNumbers(text));
    }

	private static int toInt(String numbers){
		return Integer.parseInt(numbers);
	}

	private static String[] splitNumbers(String numbers){
        String delimiter = "[,|\\\n]";
	    return numbers.split(delimiter);
    }

    private static String[] splitNumbersWithCustomDelimiter(String numbers){
        String delimiter = "[\\D|\\" + numbers.substring(2,3);
        numbers = numbers.substring(4);
        return numbers.split(delimiter + "]");
    }

    private static String[] splitNumbersWithAnyLengthDelimiter(String numbers){
        int newLineIndex = numbers.indexOf("\n");
        String delimiter = "[\\D|\\" + numbers.substring(3, newLineIndex);
        numbers = numbers.substring(newLineIndex + 1);
        return numbers.split(delimiter);
    }

    private static String[] splitNumbersWithMultipleDelimiters(String numbers){
        int newLineIndex = numbers.indexOf("\n");
        int firstDelim = numbers.indexOf("]");
        String delimiter = "[\\D|\\" + numbers.substring(3, firstDelim);
        for(int i = firstDelim; i < newLineIndex; i++){
            if(numbers.charAt(i) == '[')
                delimiter += "|\\" + numbers.substring(i + 1, numbers.indexOf("]", i));
        }
        numbers = numbers.substring(newLineIndex + 1);
        return numbers.split(delimiter + "]");
    }

    private static int sum(String[] numbers){
 	    int total = 0;
        String neg = "";
        for(String number : numbers){
            if(number.equals(""))
                continue;
            if(toInt(number) > 1000)
                continue;
            if(toInt(number) < 0)
                neg += number + ",";
		    total += toInt(number);
		}
        if(!neg.equals(""))
            throw new RuntimeException("Negatives not allowed: " + neg.substring(0, neg.length() -1));

		return total;
    }

    public static void main(String[] args){
        System.out.print("hello");
    }

}
