
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LexicalAnalyzer{

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

    public static void main(String args[]){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Java File Name to be Analyzed : ");

        String sanitizeString = ".*\\.java$";
        try{
            String fileName = bufferedReader.readLine();
            Pattern pattern = Pattern.compile(sanitizeString);
            Matcher matcher = pattern.matcher(fileName);

            if(matcher.matches()){
                System.out.println("Java File Identified......");
                StringBuilder inputFileAsString = new StringBuilder();
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));
                    
                }catch(IOException io){
                    System.out.println("File Not Found..");
                }
                
            }else{
                System.out.println("Enter Only Java File");
            }
        }catch(IOException ioException){
            
        }
        

    }

}



