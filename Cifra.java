class Cifra { 
    public static StringBuffer criptografar(String texto, int x){ 
        StringBuffer criptografia= new StringBuffer(); 
  
        for (int i=0; i<texto.length(); i++) 
        { 
            if (Character.isUpperCase(texto.charAt(i))) 
            { 
                char ch = (char)(((int)texto.charAt(i) + x - 65) % 26 + 65); 
                criptografia.append(ch); 
            } 
            else if (Character.isLowerCase(texto.charAt(i)))
            { 
                char ch = (char)(((int)texto.charAt(i) + x - 97) % 26 + 97); 
                criptografia.append(ch); 
            }
            else if (Character.isDigit(texto.charAt(i)))
            { 
                char ch = (char)(((int)texto.charAt(i) + x - 48) % 10 + 48); 
                criptografia.append(ch); 
            }
            else
            { 
                char ch = (char)((int)texto.charAt(i)); 
                criptografia.append(ch); 
            } 
        } 
        return criptografia; 
    } 

    public static StringBuffer descriptografar(String textocript, int x){ 
        StringBuffer descriptografia= new StringBuffer(); 
  
        for (int i=0; i<textocript.length(); i++) 
        { 
            if (Character.isUpperCase(textocript.charAt(i))) 
            { 
                char ch = (char)(((int)textocript.charAt(i) + (26- x) - 65) % 26 + 65); 
                descriptografia.append(ch); 
            } 
            else if (Character.isLowerCase(textocript.charAt(i)))
            { 
                char ch = (char)(((int)textocript.charAt(i) + (26 - x) - 97) % 26 + 97); 
                descriptografia.append(ch); 
            }
            else if (Character.isDigit(textocript.charAt(i)))
            { 
                char ch = (char)(((int)textocript.charAt(i) + (10 - x) - 48) % 10 + 48); 
                descriptografia.append(ch); 
            }
            else
            { 
                char ch = (char)((int)textocript.charAt(i)); 
                descriptografia.append(ch); 
            } 
        } 
        return descriptografia; 
    } 
   
    public static void main(String[] args){
        
    } 
}