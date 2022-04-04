package encryptiontest;
import org.junit.Test;
public class project1 {
public int findKeyLength(String cipherText){
    char[] cipherArray = cipherText.toCharArray();
    int count = 0;
    int max = 0;
    int displaceNum = 0;
    int[] displaceArray = new int[cipherArray.length - 1];
    char[] tempArray = new char[cipherArray.length];
    for(int i = 0; i < cipherArray.length; i++){
    	tempArray[i] = cipherArray[i];
    }
    for(int i = 1; i < cipherArray.length; i++){
    	char temp = tempArray[cipherArray.length - 1];
    	for(int p = cipherArray.length - 2; p >= 0; p--){
        	tempArray[p + 1] = tempArray[p];   		
    	}
    	tempArray[0] = temp; 
    	for(int j = 0; j < cipherArray.length; j++){
    		if(cipherArray[j] == tempArray[j]) count++;
    	}
    	if(count > max){
    		max = count;
    		displaceNum = i;
    	}
    	displaceArray[i - 1] = count;
    	count = 0;
    }
    System.out.println("Number of left-moving" + "\t\t\t" + "Coincidence");
    for(int i = 0; i < displaceArray.length; i++){
    	System.out.println(i+1 + "\t\t\t\t\t\t\t\t\t\t\t\t" + displaceArray[i] );
    }
    return displaceNum;
}

public static int shiftCipherDecryption(char[] cipherText){
	double sum = 0;
	double maxValue = 0;
	int indexResult = 0;
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
	for(int i = 0; i < 26; i++){
		for(int j = 0; j < 26; j++){
			sum += (thisFrequency[j] * englishFrequency[j]);
		}
		if(sum > maxValue){
			maxValue = sum;
			indexResult = i;
		}
		sum = 0;
//		double[] tmpArray= new double[26];
//		double tmp = englishFrequency[0];
//		tmpArray[25] = tmp;
//		for (int p = 0;p < 25; p++){
//			tmpArray[p] = englishFrequency[p+1];
//		}
//		englishFrequency = tmpArray;
		double tmp = englishFrequency[25];
		for(int p = 24; p >= 0; p--){
			englishFrequency[p + 1] = englishFrequency[p];
		}
		englishFrequency[0] = tmp;
	}
	return indexResult;
}
@Test
public void findKey(int displaceNum,String cipherText){
	int arrNum = 2000/displaceNum;
    char[] cipherArray = cipherText.toCharArray();
	char[] array0 = new char[arrNum];
	char[] array1 = new char[arrNum];
	char[] array2 = new char[arrNum];
	char[] array3 = new char[arrNum];
	char[] array4 = new char[arrNum];
	char[] array5 = new char[arrNum];
	char[] array6 = new char[arrNum];
	
	for(int i = 0; i < arrNum * displaceNum; i++){
		switch (i % 7){
		case 0: 
			array0[i/7] =  cipherArray[i];
		case 1: 
			array1[i/7] =  cipherArray[i];
		case 2: 
			array2[i/7] =  cipherArray[i];
		case 3: 
			array3[i/7] =  cipherArray[i];
		case 4: 
			array4[i/7] =  cipherArray[i];
		case 5: 
			array5[i/7] =  cipherArray[i];
		case 6: 
			array6[i/7] =  cipherArray[i];
	}
	}
//	for(int i = 0; i < array0.length; i++){
//		System.out.print(array0[i]);
//	}
//	return (char)(26 - shiftCipherDecryption(array0) + 65) + "\t"
//	+ (char)(26 - shiftCipherDecryption(array1) + 65) + "\t" + (char)(26 - shiftCipherDecryption(array2) + 65) + "\t"
//	+ (char)(26 - shiftCipherDecryption(array3) + 65) + "\t" + (char)(26 - shiftCipherDecryption(array4) + 65) + "\t"
//	+ (char)(26 - shiftCipherDecryption(array5) + 65) + "\t" + (char)(26 - shiftCipherDecryption(array6) + 65) + "\t";
System.out.println((char)(shiftCipherDecryption(array0) + 65) + "\t"
		+ (char)(shiftCipherDecryption(array1) + 65) + "\t" + (char)(shiftCipherDecryption(array2) + 65) + "\t"
		+ (char)(shiftCipherDecryption(array3) + 65) + "\t" + (char)(shiftCipherDecryption(array4) + 65) + "\t"
		+ (char)(shiftCipherDecryption(array5) + 65) + "\t" + (char)(shiftCipherDecryption(array6) + 65) + "\t");


for(int i = 0; i < array0.length; i++){
	array0[i] = (int)array0[i] - shiftCipherDecryption(array0) - 65 < 0 ? (char)((int)array0[i] - shiftCipherDecryption(array0) + 26) : (char)((int)array0[i] - shiftCipherDecryption(array0));	
	array1[i] = (int)array1[i] - shiftCipherDecryption(array1) - 65 < 0 ? (char)((int)array1[i] - shiftCipherDecryption(array1) + 26) : (char)((int)array1[i] - shiftCipherDecryption(array1));	
	array2[i] = (int)array2[i] - shiftCipherDecryption(array2) - 65 < 0 ? (char)((int)array2[i] - shiftCipherDecryption(array2) + 26) : (char)((int)array2[i] - shiftCipherDecryption(array2));	
	array3[i] = (int)array3[i] - shiftCipherDecryption(array3) - 65 < 0 ? (char)((int)array3[i] - shiftCipherDecryption(array3) + 26) : (char)((int)array3[i] - shiftCipherDecryption(array3));	
	array4[i] = (int)array4[i] - shiftCipherDecryption(array4) - 65 < 0 ? (char)((int)array4[i] - shiftCipherDecryption(array4) + 26) : (char)((int)array4[i] - shiftCipherDecryption(array4));	
	array5[i] = (int)array5[i] - shiftCipherDecryption(array5) - 65 < 0 ? (char)((int)array5[i] - shiftCipherDecryption(array5) + 26) : (char)((int)array5[i] - shiftCipherDecryption(array5));	
	array6[i] = (int)array6[i] - shiftCipherDecryption(array6) - 65 < 0 ? (char)((int)array6[i] - shiftCipherDecryption(array6) + 26) : (char)((int)array6[i] - shiftCipherDecryption(array6));	
}
char[] plainArray = new char[arrNum * displaceNum];
int index = 0;
for(int i = 0; i < arrNum;i++){
	plainArray[index++] = array0[i];
	plainArray[index++] = array1[i];
	plainArray[index++] = array2[i];
	plainArray[index++] = array3[i];
	plainArray[index++] = array4[i];
	plainArray[index++] = array5[i];
	plainArray[index++] = array6[i];
}
for(int i = 0; i < plainArray.length; i++){
	System.out.print(plainArray[i]);
}
} 


public static void main(String[] args){
	project1 test = new project1();
	String cipherText = "VCBAHYDMUHVPIRMDNWTSQGYHPZCYSPGBXUIFTGKQHAHDYKAODGTMPMNUQPKMIBQHWXZXUIFTGKQBMHTLUQIDBDMAFCXZXMADUFVTKPALDWSPPQHZCDGMXIHSHRWGCEBIBBNOFHWXGPIOMCMPUUPSPKQEUURTTZZYEHARQYMGFTRWGUDSBBAFUWSCEWAEFVTKMUMVCWGIZXYWHLPAQMFSVGZNTWPGWPXQRGTBTYDUAHWYCXMNXAVITBABSQMYSXMPUHWOCWWRWAIGLMQPUSUHZMFXVTKODORTLTGEQAIAWVFVQICDQZXFCPYTKVGHATEDYZQTGMHYDGEXIWMFCBXQRBQQPGPQFBWITVPGMFNVIZBMFSEGNLUBVAMDMQZUMWNYOWKBTFIYSHAMIUZHHXDUYFCHMIKIZWHUMSAUBVAMDNAPJMATYPCTLVFQMBIFMMHPOCWQPIZHZGWIQTOIMWPIEISWMZFKHWXXAIDQWBTPVGFHMWGNOFNBVSCPCCMSZIIKWTBBIEGTLAQXYSWXZNYMIIRXQLTOELIEMTSHTBFBQFTPQFBFVTLCZFUUWMOXCZHXGOPIIBDGPQLTSPWXQLTOELBTYESCLMAZDSABMRUFSCVWGHFSGBVSMAATHVQQTCHHWNPUCJLTKWAIAWPMPQBDVWZHQQIBWZQUHWMPQNDOVXLKJQFWTXEBABTLBBCFMUHZTYDMDNBTUZRAHVQFUBTLAMHKKPRQXYMBIYWDQMFSTVPNMYXGOTYDZXMBXYTOCWQEUURPPSIUDRARUMLDMBXKKHFVXTCZQUHIBVSFKWWTLTCFIEHVMMAJTKMUAZFTFMPSRCGAMDNQOGLATYEOINXMNABRXLDYIVTKPMHPOLTGMHPGPBLICFVHHUQUEDTKQFSPCCMJQMUZARQIUEOABBFFQOCGWKYPWBGWFVQWCZAUFXMXTUMMWWCZGAOFCSHUQNTSWHVAODCUUMOIYWCZUKQUTTMWYSUBIXVEYEIGIZUMQQNGBTCMPJKAFIGHATCSBUBVTVPWMZAXLYYMTJGVKXQOGBBEJQFUXKFFKGLXMFIRMDNATYEOXWJGNKCJDVAQKCJWWZNIOCMBASQGXWWUPQUDMVQPQFBBVPQTOIRWGPQUDMGAOPCCMZQUXZNPIZNFCPGLUXABIXQFBQFLXTXIRQDNZEYFVPMAQNFZTLQFCEOXWAFCRTARJGNURDGBEYQOCRBTCZUIHTMOSVPMBTYDSHGWFBUBVYCZHKOQHCFUBFDIWEUXBDBVPYQRHTQPWKBIAQMMAATUWPSYWVABMWOSEMGAOZSMMBUGQUDHLNSQMDNDQWTSTKMPGQIEOMDSYIRAIZXIWIAIRCZOANVOIZHGHTXUNZTUCDMFCUFMDLUATGBEBQJPGQEBQRIAZAOSVIAMFLQSHMPUHWWCZWHYDHWXQZNQFKBMICFGIKCOEYSPLJQCZUEKWRIGBSEGGHEOIBARUOHDKGUNAQRNZDYPHDFMEOPRTGTKNTOIBEAOXRVHLAQZHDMPQPUZATOQUZRAHWWOBPPNMDMFSXGAAGQPDWGAOSVIMWNYWSTIQZAMBTRMAHFVTYMXFAKPMBTYEOBXBUGQWIPWGFPPTPQEYFCPETMSMBNLCEJUQXHVEBQAXZPFBMJTTAFITWHUMUHSGJLXQWFSSBZQGQAQXZQXTCLIWULAHWTLDYXWTWWZGKRXITAGMQNTKOIDRXGOXSUKTGBFIFVTEQFNXSWHCEYIWIABTYMDPKBYYZHHVIDXUBHXZFYPWCMPQQUBSHEIBQFTBSZYIVTEWPAQRPGLFUBDTWWZNTSSHWDUZCAWEAGMBRTUQUZRDIMZYPWIZWAXMTIXZZIABXLIUXBZTTAMHFZNBAPLNOJXZENQWCBVEBQGITZQXMHBXPMPQBIRWGBQOGWPQUDRLAIFUNCJMPUGIVPMINIGHWBUTYEHDHSFIAYSXIPHAHDHSNSFVTIMDFUQTUGFBQDDEQOYUUPLXQXPCNHCYYMBIAMK";
	int keyLength = test.findKeyLength(cipherText);
	System.out.println();
	System.out.println("The length of key is " + keyLength);
	test.findKey(keyLength, cipherText);
//	System.out.println("The key is "+ key);
}
}
