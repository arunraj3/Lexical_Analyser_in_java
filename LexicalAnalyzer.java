import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LexicalAnalyzer {


    // Defining all The Regular Expression for the JAVA programming Language

    private static final String KEYWORD_REGEX = "\\b(?:abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|if|implements|import|instanceof|int|interface|long|native|new|null|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|transient|try|void|volatile|while)\\b";
    private static final String IDENTIFIER_REGEX = "[a-zA-Z][a-zA-Z0-9]*";
    private static final String STRING_LITERAL_REGEX = "\"[^\"]*\"";
    private static final String CHAR_LITERAL_REGEX = "'.'";
    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?([eE][+-]?\\d+)?";
    private static final String WHITESPACE_REGEX = "\\s+";
    private static final String RELATIONAL_OPERATOR_REGEX = "((==)|(!=)|(<=)|(>=)|[<>])";
    private static final String LOGICAL_OPERATOR_REGEX = "(&&|\\|\\||!)";
    private static final String BITWISE_OPERATOR_REGEX = "(&|\\||\\^|~|<<|>>|>>>|&=|\\|=|\\^=|<<=|>>=|>>>=)";
    private static final String ARITHMETIC_OPERATOR_REGEX = "[+\\-*/%]";
    private static final String SPECIAL_SYMBOLS_REGEX = "[!@#$%^&*()_+=\\-\\[\\]{};:'\"<>,.?/\\\\|]";
    public static int totalTokenCounts = 0;
   

    public static void main(String args[]) {
        //Title 
        System.out.println("LEXICAL ANALYZER USING JAVA FOR JAVA PROGRAMMING LANGUAGE");

        
        //Reading File Name using BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Java File Name to be Analyzed : ");

        
        String sanitizeString = ".*\\.java$"; //To check Whether added file is Java file or Not



        try {

            String fileName = bufferedReader.readLine(); //Extracting FileName 

            Pattern pattern = Pattern.compile(sanitizeString);
            Matcher matcher = pattern.matcher(fileName);

            if (matcher.matches()) {
                System.out.println("Java File Identified Successfully ......");

                StringBuilder inputFileAsString = new StringBuilder();


                try {
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    String eachLine;

                    while ((eachLine = reader.readLine()) != null) {
                        inputFileAsString.append(eachLine).append("\n");
                    }
                    reader.close();

                    //Regular Expression for JAVA  
                    Pattern syntaxPattern = Pattern.compile(
                            KEYWORD_REGEX + "|" +
                                    IDENTIFIER_REGEX + "|" +
                                    STRING_LITERAL_REGEX + "|" +
                                    CHAR_LITERAL_REGEX + "|" +
                                    NUMBER_REGEX + "|" +
                                    WHITESPACE_REGEX + "|" +
                                    RELATIONAL_OPERATOR_REGEX + "|" +
                                    LOGICAL_OPERATOR_REGEX + "|" +
                                    BITWISE_OPERATOR_REGEX + "|" +
                                    ARITHMETIC_OPERATOR_REGEX + "|" +
                                    SPECIAL_SYMBOLS_REGEX);

                    Matcher syntaxMatcher = syntaxPattern.matcher(inputFileAsString);

                    while (syntaxMatcher.find()) {
                        
                        String matchedToken = syntaxMatcher.group();

                        if(!matchedToken.matches(WHITESPACE_REGEX)){

                            String matchedType = getMatchedType(matchedToken);
                            totalTokenCounts+=1;
                            System.out.println("< " + matchedToken + " , " + matchedType + " >");
                        }
                     
                    }
                    System.out.println("Total number of Tokens : "+totalTokenCounts);

                } catch (IOException io) {
                    System.out.println("File Not Found..");
                }

            } else {
                System.out.println("Enter Only Java File");
            }
        } catch (IOException ioException) {

        }

    }
    private static String getMatchedType(String token) {

        StringBuilder result = new StringBuilder();
        if (token.matches(KEYWORD_REGEX)) {
            result.append("KEYWORD");
        } else if (token.matches(IDENTIFIER_REGEX)) {
            result.append("IDENTIFIER");
        } else if (token.matches(STRING_LITERAL_REGEX)) {
            result.append("STRING");
        } else if (token.matches(CHAR_LITERAL_REGEX)) {
            result.append("CHAR");
        } else if (token.matches(NUMBER_REGEX)) {
            result.append("NUMBER");
        } else if (token.matches(RELATIONAL_OPERATOR_REGEX)) {
            result.append("RELATIONAL OPERATOR");
        } else if (token.matches(LOGICAL_OPERATOR_REGEX)) {
            result.append("LOGICAL OPERATOR");
        } else if (token.matches(BITWISE_OPERATOR_REGEX)) {
            result.append("BITWISE OPERATOR");
        } else if (token.matches(SPECIAL_SYMBOLS_REGEX)) {
            result.append("SPECIAL SYMBOL");
        }

        return result.toString();
    }
}
