/**
 * 
 */
package com.sem.thread.forkJoin;

import java.util.Random;

/**
 * @Title: Document.java
 * @Package com.sem.thread.forkJoin
 * @Description:
 * @author brook.xu
 * @date 2017年2月7日 下午4:56:49
 * @version V1.0
 */
public class Document {
	private String words[] = { "the", "hello", "goodbye", "packt", "java", "thread", "pool", "random", "class",
			"main" };

	/**
	 * 参数：行数、每行的单词数。这个例子返回一个字符串二维数组，来表示将要查找的单词。
	 * @param numLines
	 * @param numWords
	 * @param word
	 * @return
	 */
	public String[][] generateDocument(int numLines, int numWords, String word) {
		int counter = 0;
		String document[][] = new String[numLines][numWords];
		Random random = new Random();
		for (int i = 0; i < numLines; i++) {
			for (int j = 0; j < numWords; j++) {
				int index = random.nextInt(words.length);
				document[i][j] = words[index];
				if (document[i][j].equals(word)) {
					counter++;
				}
			}
		}
		System.out.println("DocumentMock: The word appears "+counter+" times in the document");
		return document;
	}
}