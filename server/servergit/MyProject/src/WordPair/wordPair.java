package WordPair;


public class wordPair {
 private String englishWord;
 private String finnishWord;
 
 public wordPair(String englishWord, String finnishWord) {
	 this.englishWord = englishWord;
	 this.finnishWord = finnishWord;
 }

 
 public String getEnglishWord() {
	 return englishWord;
 }
 
 public String getFinnishWord() {
	 return finnishWord;
 }
 
 public String toString() {
	 return (englishWord + " = " + finnishWord);
 }


public void setEnglishWord(String englishWord) {
	this.englishWord = englishWord;
}


public void setFinnishWord(String finnishWord) {
	this.finnishWord = finnishWord;
}
 
 
 
}
 