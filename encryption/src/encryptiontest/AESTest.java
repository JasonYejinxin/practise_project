package encryptiontest;
import java.util.Arrays;

import org.junit.Test;
public class AESTest {
		//Example: Original Key
//	public static int[][] originalKey = {{0x00,0x01,0x02,0x03},{0x04,0x05,0x06,0x07},
//	{0x08,0x09,0x0a,0x0b},{0x0c,0x0d,0x0e,0x0f}};
public static int[][] originalKey = {{0x1a,0x0c,0x24,0xf2},{0x87,0x54,0x95,0xbc},
	{0xb7,0x08,0x0e,0x43},{0x92,0x0f,0x56,0x72}};
//public static int[][] plainText = {{0x00,0x44,0x88,0xcc},{0x11,0x55,0x99,0xdd},
//	{0x22,0x66,0xaa,0xee},{0x33,0x77,0xbb,0xff}};
public static int[][] plainText = {{0x00,0x00,0x00,0x00},{0x00,0x00,0x00,0x00},
	{0x00,0x00,0x00,0xab},{0x00,0x00,0x00,0xc2}};
		public static int[][] M = {{2,3,1,1},{1,2,3,1},{1,1,2,3},{3,1,1,2}};
		public static String SBox = "63 7c 77 7b f2 6b 6f c5 30 01 67 2b fe d7 ab 76 ca 82 c9 7d fa 59 47 f0 ad d4 a2 af 9c a4 72 c0 b7 fd 93 26 36 3f f7 cc 34 a5 e5 f1 71 d8 31 15 04 c7 23 c3 18 96 05 9a 07 12 80 e2 eb 27 b2 75 09 83 2c 1a 1b 6e 5a a0 52 3b d6 b3 29 e3 2f 84 53 d1 00 ed 20 fc b1 5b 6a cb be 39 4a 4c 58 cf d0 ef aa fb 43 4d 33 85 45 f9 02 7f 50 3c 9f a8 51 a3 40 8f 92 9d 38 f5 bc b6 da 21 10 ff f3 d2 cd 0c 13 ec 5f 97 44 17 c4 a7 7e 3d 64 5d 19 73 60 81 4f dc 22 2a 90 88 46 ee b8 14 de 5e 0b db e0 32 3a 0a 49 06 24 5c c2 d3 ac 62 91 95 e4 79 e7 c8 37 6d 8d d5 4e a9 6c 56 f4 ea 65 7a ae 08 ba 78 25 2e 1c a6 b4 c6 e8 dd 74 1f 4b bd 8b 8a 70 3e b5 66 48 03 f6 0e 61 35 57 b9 86 c1 1d 9e e1 f8 98 11 69 d9 8e 94 9b 1e 87 e9 ce 55 28 df 8c a1 89 0d bf e6 42 68 41 99 2d 0f b0 54 bb 16";
		
		public static int[][] getSBox(){
			String [] str = SBox.split(" ");
			int[] SBox_int = new int[str.length];
			for(int i = 0; i < str.length; i++){
				SBox_int[i] = Integer.decode("0x".concat(str[i]));
			}
			int[][] SBox = new int[16][16];
			for(int i = 0; i < SBox_int.length; i++){
				SBox[i/16][i%16] = SBox_int[i];
			}
			//modify SBox
//			int[] tmp = new int[16];
//			for(int i = 0; i < 16; i++){
//					tmp[i] = SBox[0][i];			
//			}
//			for(int i = 0; i < 16; i++){
//				SBox[0][i] = SBox[6][i];
//				SBox[6][i] = tmp[i];
//		}
			return SBox;
		}
		
		@Test
		public void teste(){
			for(int i = 0; i < 16; i++){
				for(int j = 0; j < 16; j++){
					if(getSBox()[i][j] == 13){
						System.out.print(i + " " + j + " " + "asdasd");
					}
					break;
				}
			}
		}
		
		
		//Update keys for each round
		public static int[][] getKey(int i){
			if (i == 0) return originalKey;
			int[][] key = null;
			int[][] keyBef = originalKey;
			for(int r = 1; r <= i; r++){
				key = new int[4][4];
				for(int j = 0; j < 4; j ++){
				key[0][j] = keyBef[0][j]^T(keyBef,r,j);
				key[1][j] = keyBef[1][j]^key[0][j];
				key[2][j] = keyBef[2][j]^key[1][j];
				key[3][j] = keyBef[3][j]^key[2][j];
			}
				keyBef = key;
			}
			
			return key;
		}
		
		//T method for T[(4i - 1)]
		public static int T(int[][] W, int r, int j){
			// 1
			int tmpMatrix[] = new int[4];
			for(int i = 0; i < 4; i++){
				tmpMatrix[i] = W[3][i];
			}
			// 2
			int tmp = tmpMatrix[0];
			for(int i = 0; i < 3; i++){
				tmpMatrix[i] = tmpMatrix[i+1];
			}
			tmpMatrix[3] = tmp;
			// 3
			for(int i = 0; i < tmpMatrix.length; i++){
				tmpMatrix[i] = getSBox(tmpMatrix[i]/16,tmpMatrix[i]%16);
			}
			// 4
			int Ri = 0;
			if(r <= 8) Ri = 1 <<(r - 1); 
			else if (r == 9) Ri = 0b00011011;
			else if (r == 10) Ri = 0b00110110;
			// 5 and 6
			tmpMatrix[0] = tmpMatrix[0]^Ri;
			// choose one integer to output
			switch(j){
			case 0: return tmpMatrix[0];
			case 1: return tmpMatrix[1];
			case 2: return tmpMatrix[2];
			case 3: return tmpMatrix[3];
			}
			return 0;
		}
		//The method of matrix multiplication
		public static int[][] matrixMult(int[][] a, int[][]b){
			if(a.length != b[0].length) return null;
			int[][][]resultMatrix = new int[a.length][b[0].length][9];
			for(int i = 0; i < a.length; i++){
				for(int j = 0,m = 0; m < a.length; m += (j+1)/a.length, j++, j = j%a.length){
					for(int n = 0; n < 9; n++){
						resultMatrix[i][m][n] += decimalToBinary(a[i][j],b[j][m],n);
					}
				}
			}
			return GF(resultMatrix);
			//return resultMatrix;
		}
		// matrix multiplication for decimal elements
		public static int[][] matrixMult_EX(int[][] a, int[][]b){
			if(a.length != b[0].length) return null;
			int[][]resultMatrix = new int[a.length][b[0].length];
			for(int i = 0; i < a.length; i++){
				for(int j = 0,m = 0; m < a.length; m += (j+1)/a.length, j++, j = j%a.length){
						resultMatrix[i][m] += a[i][j]*b[j][m];
				}
			}
			return resultMatrix;
		}
		// decimal To Binary
		public static int decimalToBinary(int a,int b,int n){
			int [] decimalToBinaryArr = new int[9];
			int [] result = new int[9];
			String str = Integer.toBinaryString(b);
			char [] strToInteger = str.toCharArray();
			
			for(int i = 0; i < strToInteger.length; i++){
				decimalToBinaryArr[i] += Integer.parseInt(String.valueOf(strToInteger[strToInteger.length - i - 1]));
			}
			
			switch(a){
			case 1:
				for(int i = 0; i < 9; i++){
					result[i] += decimalToBinaryArr[i];
				}
				break;
			case 2:
				for(int i = 0; i < 8; i++){
					result[i + 1] += decimalToBinaryArr[i];
				}
				break;
			case 3:
				for(int i = 0; i < 8; i++){
					result[i + 1] += decimalToBinaryArr[i];
					result[i] += decimalToBinaryArr[i];
				}
				break;
			}
			
			return result[n];
		}
		//GF
		public static int[][] GF(int[][][] w){
			int [][]resultArr = new int[w.length][w[0].length];
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < 4; j++){
					if(w[i][j][8] != 0){
						w[i][j][0] += w[i][j][8];
						w[i][j][1] += w[i][j][8];
						w[i][j][3] += w[i][j][8];
						w[i][j][4] += w[i][j][8];
						w[i][j][8] = 0;
					}
					for(int m = 0; m < w[0][0].length; m++){
						w[i][j][m] = w[i][j][m] % 2;
						resultArr[i][j] +=  w[i][j][m] * Math.pow(2, m);
					}
				}
			}
			return resultArr;
		}
		//The method of BS
		public static int[][] BS(int[][] w){
			int[][] BS = new int[w.length][w[0].length];
			for(int i = 0; i < w.length; i++){
				for(int j = 0; j < w[0].length; j++){
					BS[i][j] = getSBox(w[i][j]/16,w[i][j]%16);
				}
			}
			return BS;
		}
		//The method of SR
		public static int[][] SR(int[][] w){
			int [][]SR = new int[w.length][w[0].length];
			for(int i = 0; i < w.length; i++){
				SR[0][i] = w[0][i];
			}
			for(int i = 0; i < w.length - 1; i++){
				SR[1][i] = w[1][i + 1];
			}
			SR[1][3] = w[1][0];
			for(int i = 0; i < w.length - 2; i++){
				SR[2][i] = w[2][i + 2];
			}
			SR[2][2] = w[2][0];
			SR[2][3] = w[2][1];
			for(int i = w.length - 2; i >= 0 ; i--){
				SR[3][i + 1] = w[3][i];
			}
			SR[3][0] = w[3][3];
			return SR;
		}
		//The method of MC
		public static int[][] MC(int[][] w){
			return matrixMult(M,w);
		}
		//The method of ARK
		public static int[][] ARK(int[][] w, int r){
			int [][]ARK = new int[w.length][w[0].length];
			for(int i = 0; i < w.length; i++){
				for(int j = 0; j < w[0].length; j++){
					ARK[i][j] = w[i][j]^shift(getKey(r))[i][j];
				}
			}
			return ARK;
		}
		//shift row to column,column to row
		public static int[][] shift(int[][] w){
			int [][]a = new int[4][4];
			for(int i = 0; i < 4; i++){
				for(int j = 0; j < 4; j ++){
					a[j][i] = w[i][j];
				}
			}
			return a;
		}
		
//		@Test
//		public void test1(){
//			int[][] a = {{0,1,2,3},{1,2,3,4},{2,3,4,5},{2,3,4,5}};
//			int[][] b = {{0,1,2,3},{1,2,3,4},{2,3,4,5},{2,3,4,5}};
//			int[][]c = matrixMult_EX(a,b);
//			for(int i = 0; i < c.length; i++){
//				for(int j = 0; j < c[i].length; j++){
//					System.out.print(c[i][j] + " ");
//				}
//			}
//		}
//		@Test
//		public void test2(){
//			String [] str = SBox.split(" ");
//			int[] SBox_int = new int[str.length];
//			for(int i = 0; i < str.length; i++){
//				SBox_int[i] = Integer.decode("0x".concat(str[i]));
//			}
//			int[][] SBox = new int[16][16];
//			for(int i = 0; i < SBox_int.length; i++){
//				SBox[i/16][i%16] = SBox_int[i];
//			}
//			for(int i = 0; i < 16; i++){
//				for(int j = 0; j < 16; j++){
//					System.out.print(SBox[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			int [] arr = new int[256];
//			for(int i = 0; i < 16; i++){
//				for(int j = 0; j < 16; j++){
//					arr[SBox[i][j]] += 1;
//				}
//			}
//			boolean flag = true;
//			for(int i = 0; i < 256; i++){
//				if (arr[i] != 1) flag = false; 
//			}
//			System.out.print(flag);
//		}
//		
//		@Test
//		public void test3(){
//			int [][]keyTest = getKey(2);
//			for(int i = 0; i < keyTest.length; i++){
//				for(int j = 0; j < keyTest[0].length; j++){
//					System.out.print(Integer.toHexString(keyTest[j][i]) + " ");
//				}
//			}
//		}
//		@Test
//		public void test4(){
//			String str = Integer.toBinaryString(0xd8^0xaa);
//			char [] strToInteger = str.toCharArray();
//			int [] a = new int[strToInteger.length];
//			for(int i = 0; i < strToInteger.length; i++){
//				a[i] += Integer.parseInt(String.valueOf(strToInteger[i]));
//				System.out.print(a[i] + " ");
//			}
//			
//			System.out.println();
//			System.out.println(Math.pow(2, 4));
//			
//		}
//		@Test
//		public void test5(){
//			for(int i = 0; i < plainText.length; i++){
//				for(int j = 0; j < plainText[0].length; j++){
//					System.out.print(Integer.toHexString(plainText[j][i]) + " ");
//				}
//			}
//			System.out.println();
//			int [][]output0 = ARK(plainText,0); 
//			for(int i = 0; i < output0.length; i++){
//				for(int j = 0; j < output0[0].length; j++){
//					System.out.print(Integer.toHexString(output0[j][i]) + " ");
//				}
//			}
//			System.out.println();
//			
//			int [][]output1 = ARK(MC(SR(BS(output0))),1);
//			for(int i = 0; i < output1.length; i++){
//				for(int j = 0; j < output1[0].length; j++){
//					System.out.print(Integer.toHexString(output1[j][i]) + " ");
//				}
//			}
//			System.out.println();
//			
//			int [][]output2 = ARK(MC(SR(BS(output1))),2);
//			for(int i = 0; i < output1.length; i++){
//				for(int j = 0; j < output1[0].length; j++){
//					System.out.print(Integer.toHexString(output2[j][i]) + " ");
//				}
//			}
//			System.out.println();
//		}
		
		public static void main(String[]args){
			System.out.println("-----------------------------------------------------------");
			System.out.println("Original Plaintext and Key:");
			System.out.print("Input:    ");
			for(int i = 0; i < plainText.length; i++){
				for(int j = 0; j < plainText[0].length; j++){
					System.out.print((plainText[j][i] >= 16) ? (Integer.toHexString(plainText[j][i]) + " "): ("0".concat(Integer.toHexString(plainText[j][i]) + " ")));
				}
			}
			System.out.println();
			System.out.print("Key:      ");
			for(int i = 0; i < originalKey.length; i++){
				for(int j = 0; j < originalKey[0].length; j++){
					System.out.print((originalKey[i][j] >= 16) ? (Integer.toHexString(originalKey[i][j]) + " "): ("0".concat(Integer.toHexString(originalKey[i][j]) + " ")));
				}
			}
			System.out.println();
			System.out.println("-----------------------------------------------------------");
			System.out.println("Key Schedule Results for Each Round:");
			System.out.println("-----------------------------------------------------------");
			for(int r = 1; r <= 10; r++){
			System.out.println("Round " + r +": ");
			System.out.print("        " + "Key" +": ");
			int [][]keyTest = getKey(r);
			for(int i = 0; i < keyTest.length; i++){
				for(int j = 0; j < keyTest[0].length; j++){
					System.out.print((keyTest[i][j] >= 16) ? (Integer.toHexString(keyTest[i][j]) + " "): ("0".concat(Integer.toHexString(keyTest[i][j]) + " ")));
				}
			}
			System.out.println();
		}
			System.out.println("-----------------------------------------------------------");
			
			
			System.out.println("Data Results for Each Round:");
			System.out.println("-----------------------------------------------------------");
			System.out.println("Round 0:");
			System.out.print("-----Start: ");
			for(int i = 0; i < plainText.length; i++){
				for(int j = 0; j < plainText[0].length; j++){
					System.out.print((plainText[j][i] >= 16) ? (Integer.toHexString(plainText[j][i]) + " "): ("0".concat(Integer.toHexString(plainText[j][i]) + " ")));
				}
			}
			System.out.println();
			int [][]output0 = ARK(plainText,0); 
			System.out.print("----Output: ");
			for(int i = 0; i < output0.length; i++){
				for(int j = 0; j < output0[0].length; j++){
					System.out.print((output0[j][i] >= 16) ? (Integer.toHexString(output0[j][i]) + " "): ("0".concat(Integer.toHexString(output0[j][i]) + " ")));

				}
			}
			System.out.println();
			for(int r = 1; r <= 9; r++){
				System.out.println("Round " + r + ":");
				System.out.print("----Output: ");
				for(int i = 0; i < ARK(MC(SR(BS(output0))),r).length; i++){
					for(int j = 0; j < ARK(MC(SR(BS(output0))),r)[0].length; j++){
						System.out.print((ARK(MC(SR(BS(output0))),r)[j][i] >= 16) ? (Integer.toHexString(ARK(MC(SR(BS(output0))),r)[j][i]) + " "): ("0".concat(Integer.toHexString(ARK(MC(SR(BS(output0))),r)[j][i]) + " ")));
					}
				}
				output0 = ARK(MC(SR(BS(output0))),r);
				System.out.println();
			}
				
			int [][]output10 = ARK(SR(BS(output0)),10);
			System.out.println("Round 10:");
			System.out.print("----Output: ");
			for(int i = 0; i < output0.length; i++){
				for(int j = 0; j < output0[0].length; j++){
					System.out.print((output10[j][i] >= 16) ? (Integer.toHexString(output10[j][i]) + " "): ("0".concat(Integer.toHexString(output10[j][i]) + " ")));
				}
			}
			System.out.println();
			System.out.println("-----------------------------------------------------------");
		}
	}



