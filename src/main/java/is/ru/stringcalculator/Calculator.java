package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){

        String delimiters = ",|\n";

		if(text.equals(""))
			return 0;
        else if(text.contains("-"))
            return sum(splitNumbers(text, delimiters));
        else if(text.contains("//["))
            return sum(splitNumbersWithAnyLengthDelimiter(text, delimiters));
        else if(text.startsWith("//"))
            return sum(splitNumbersWithCustomDelimiter(text, delimiters));
        else
            return sum(splitNumbers(text, delimiters));
    }

	private static int toInt(String numbers){
		return Integer.parseInt(numbers);
	}

	private static String[] splitNumbers(String numbers, String delimiters){
	    return numbers.split(delimiters);
    }

    private static String[] splitNumbersWithCustomDelimiter(String numbers, String delimiters){
        delimiters += "|" + numbers.substring(2,3);
        numbers = numbers.substring(4);
        return numbers.split(delimiters);
    }

    private static String[] splitNumbersWithAnyLengthDelimiter(String numbers, String delimiters){
        int newLineIndex = numbers.indexOf("\n");
        delimiters += "|" + numbers.substring(2, newLineIndex);
        numbers = numbers.substring(newLineIndex + 1);
        return numbers.split(delimiters);
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
