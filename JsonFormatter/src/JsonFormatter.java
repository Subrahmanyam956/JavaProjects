import java.util.Stack;

public class JsonFormatter {

    boolean simpleValidateJson(String input) {

        int n = input.length();
        int bracesCount = 0;
        for(int i = 0 ; i < n; i++) {
            if(Character.compare(input.charAt(i), '{') == 0) {
                bracesCount += 1;
            } else if (Character.compare(input.charAt(i), '}') == 0) {
                bracesCount -= 1;
            }
        }

        if(bracesCount != 0) return false;

        return true;
    }

    String getSpace(int spaceCount) {
        String  finalSpace = "";
        String initialSpace = "    ";
        for(int i = 0 ; i < spaceCount; i++) {
            finalSpace += initialSpace;
        }
        return finalSpace;
    }
    String formatJson(String input) {
        String output = "";
        boolean validationOutput = this.simpleValidateJson(input);
        if(!validationOutput) {
            return "given input is an invalid Json";
        }
        int spaceCount = 0;
        int n = input.length();
        for(int i = 0; i < n; i++) {
            if(input.charAt(i) == '{') {
                output = output + "{\n";
                spaceCount += 1;
                output += getSpace(spaceCount);
            } else if(input.charAt(i) == '}') {
                output = output  + "\n}";
                spaceCount -= 1;
            } else {
                output +=  Character.toString(input.charAt(i));
            }
        }

        return output;
    }


}
