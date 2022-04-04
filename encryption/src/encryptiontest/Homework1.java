package encryptiontest;
import org.junit.Test;
public class Homework1 {
@Test 
public void test1(){
//Decrypt an English sentence using a shift cipher: ERETTPIEHECOIITWXLIHSGXSVEAEC
	double sum = 0;
	double maxValue = 0;
	int indexResult = 0;
//	char[] cipherText = new char []{'E','R','E','T','T','P','I','E','H','E','C',
//			'O','I','I','T','W','X','L','I','H','S','G','X','S','V','E','A','E','C'};
	String str = "ERETTPIEHECOIITWXLIHSGXSVEAEC";
	char[] cipherText = str.toCharArray();
	char[] plainText = new char[cipherText.length];
	double[] thisFrequency = new double[26];
	double[] englishFrequency = new double[]{0.08167,0.01492,0.02782,0.04253,0.12702,
			0.02228,0.02015,0.06094,0.06966,0.00153,0.00772,0.04025,0.02406,0.06749,
			0.07507,0.01929,0.00095,0.05987,0.06327,0.09056,0.02758,0.00978,0.02360,
			0.00150,0.01974,0.00074};
	for(int i = 0; i < cipherText.length; i++){
		thisFrequency[(int)cipherText[i] - 65]++;
	}
	for(int i = 0; i < 26; i++){
		thisFrequency[i]/=cipherText.length; 
	}
	for(int i = 1; i < 26; i ++){
		double[] tmpArray= new double[26];
		double tmp = englishFrequency[25];
		tmpArray[0] = tmp;
		for (int p = 24;p >= 0; p--){
			tmpArray[p + 1] = englishFrequency[p];
		}
		englishFrequency = tmpArray;
		for(int j = 0; j < 26; j++){
			sum += thisFrequency[j] * englishFrequency[j];
		}
		if(sum > maxValue){
			maxValue = sum;
			indexResult = i;
		}
		sum = 0;
	}
	System.out.print("The max value of thisFrequency * englishFrequency is :" +
			maxValue + ",and the moving is:" + indexResult + "\n");
	System.out.print("The plainText is:");
	for(int i = 0; i < cipherText.length; i++){
		if((int)cipherText[i] >= 69) plainText[i] = (char)((int)cipherText[i] - indexResult);
		else plainText[i] = (char)((int)cipherText[i] - 68 + 90);
		System.out.print(plainText[i]);
	}
}

@Test
public void test2(){
	/*2.Encrypt the following plaintext using the affifine cipher with 
	key (a, b) = (5, 8) and obtain the ciphertext:  Knowledge is power
	*/
//	char[] plainText = new char[]{'K','N','O','W','L','E','D','G','E','I','S','P','O','W','E','R'};

	String str = "HXVPZSRHZKPFQKFHQXT";
	char[] plainText = str.toCharArray();
	int [] plainNum = new int[plainText.length];
	char[] cipherText = new char[plainText.length];
	for(int i = 0; i < plainText.length; i++){
		plainNum[i] = (int)plainText[i] - 65;
		plainNum[i] = (15 * plainNum[i] + 23)%26;
		cipherText[i] = (char)(plainNum[i] + 65);
		System.out.print(cipherText[i]);
	}
}
@Test
public void test3(){
	char[] Encryption = new char[]{'C','O','D','E','A','B','F','G','H','I','J','K','L','M',
			'N','P','Q','R','S','T','U','V','W','X','Y','Z'};
	char[] plainText = new char[]{'K','N','O','W','L','E','D','G','E','I','S','P','O','W','E','R'};
	int[] plainNum = new int[plainText.length];
	char[] cipherText = new char[plainText.length];
	for(int i = 0; i < plainText.length; i++){
		plainNum[i] = (int)plainText[i] - 65;
		cipherText[i] = Encryption[plainNum[i]];
		System.out.print(cipherText[i]);
	}
}
@Test
public void test4(){
	char[] plainText = new char[]{'K','N','O','W','L','E','D','G','E','I','S','P','O','W','E','R'};
	char[] key = new char[]{'C','O','D','E','C','O','D','E','C','O','D','E','C','O','D','E'};
	char[] cipherText = new char[plainText.length];
	for(int i = 0; i < plainText.length; i++){
		cipherText[i] = (int)plainText[i] + (int)key[i] - 65 <= 90 ? 
				    (char)((int)plainText[i] + (int)key[i] - 65) : 
					(char)((int)plainText[i] + (int)key[i] - 65 - 26);
		System.out.print(cipherText[i]);
	}
}

@Test
public void test11(){
for(int i = 1; i < 10000; i+= 17){
	System.out.print(i + " ");}
}
}













