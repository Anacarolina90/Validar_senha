public class PasswordValidator {

    public static boolean isValid(String password) {

        if(password != null && !password.isEmpty() ) {
            // Verifica o comprimento da senha e se tem espaço
            if (password.length() < 9 && password.indexOf(' ') != -1) {
                return false;
            }
            return withNumber(password) && withUpperCase(password) && withLowerCase(password)
                    && withSpecialChar(password) && !withDuplicateChar(password);
        }
        return false;
    }

    // verifica se tem numero
    private static boolean withNumber(String password){
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c < '0' || c > '9') {
                return true;
            }
        }
        return false;
    }

    // verifica se tem letra maiuscula
    private static boolean withUpperCase(String password){
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    // verifica se tem letra minuscula
    private static boolean withLowerCase(String password){
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    // verifica se tem caracter especial
    private static boolean withSpecialChar(String password){
        String[] characters = { "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "-", "+" };
        for(int i = 0; i < characters.length; i++){
            if(password.contains(characters[i])){
                return true;
            }
        }
        return false;
    }

    // verifica se tem caracter duplicado
    private static boolean withDuplicateChar(String password){
        for (int i = 0; i < password.length(); i++) {
            char caracter1 = password.charAt(i);
            for (int j = i+1; j < password.length(); j++) {
                char caracter2 = password.charAt(j);
                if(caracter1 == caracter2){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid(""));          // false
        System.out.println(isValid("aa"));        // false
        System.out.println(isValid("ab"));        // false
        System.out.println(isValid("AAAbbbCc"));  // false
        System.out.println(isValid("AbTp9!foo")); // false
        System.out.println(isValid("AbTp9!foA")); // false
        System.out.println(isValid("AbTp9 fok")); // false
        System.out.println(isValid("AbTp9!fok")); // true
    }
}