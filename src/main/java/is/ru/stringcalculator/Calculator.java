package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){

        String delimiters = ",|\n";

		if(text.equals(""))
			return 0;
        else if(text.startsWith("//"))
            return sum(splitNumbersWithCustomDelimiter(text, delimiters));
        else if(text.contains("-"))
            return sum(splitNumbers(text, delimiters));
        else
            return sum(splitNumbers(text, delimiters));


/*        if(text.startsWith("//")){
            delimiters += "|" + text.substring(2, 3);
            text = text.substring(4);
            return sum(splitNumbers(text, delimiters));
        }
        else
            return sum(splitNumbers(text, delimiters));*/

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

    private static int sum(String[] numbers){
 	    int total = 0;
        String neg = "";
        for(String number : numbers){
            if(toInt(number) < 0)
                neg += number + ",";
		    total += toInt(number);
		}
        if(!neg.equals(""))
            throw new RuntimeException("Negatives not allowed: " + neg.substring(0, neg.length() - 1));

		return total;
    }

   /* private static void checkNegatives(String[] numbers){
        String neg = "";
        for(String s : arr){
            if(s.equals("-"))
                neg += "," + s;
        }

        if(!"".equals(neg))
            throw new Exception("Negatives not allowed: " + neg.substring(1));
    }*/

    /*private static void checkSize(String numbers){
        for(String number : numbers){
            if(toInt(number) > 1000).....           // Herna vantar liklega splittid
    */

    public static void main(String[] args){
        System.out.print("hello");
    }

}
