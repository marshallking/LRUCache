package LRUCache;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
 
 
public class LRUJavaCache {

	public LRUJavaCache() {

	}
	
	public static void main(String[] args) {

		LRUQueue.QueueNode retNode = null;
		LRUQueue lruQueue = null;
		LRUCache lruCache = null;
		int nRet = 0;

		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			String question = scanner.nextLine().toUpperCase();
			if (question.contains("SIZE")) {
				String[] inParms = question.split(" ");
				if (inParms[0].equals("SIZE")) {
					String desiredPattern = "^[1-9]([0-9])*$";
					Pattern pattern = Pattern.compile(desiredPattern);
					Matcher m = pattern.matcher(inParms[1]);

					if (m.matches()) { // must be number
						lruQueue = new LRUQueue(Integer.parseInt(inParms[1]));
						lruCache = new LRUCache(lruQueue);
						lruCache.createHash(Integer.parseInt(inParms[1]));
						System.out.println("SIZE OK\n");
					}

				} else {
					System.out.println("ERROR");
				}
			} else if (question.contains("EXIT")) {
				break;
			} else if (question.contains("GET")) {
				try {
					String[] inParms = question.split(" ");
					if (inParms[0].equals("GET")) {
						retNode = lruCache.get(inParms[1]);
						if (retNode != null) {
							System.out.println("GOT " + retNode.Value);
						} else {
							System.out.println("NOTFOUND");
						}
					}
				} catch (Exception e) {
					System.out.println("ERROR");
				}

			} else if (question.contains("SET")) {
				String[] inParms = question.split(" ");

				try {
					if (inParms[0].equals("SET")) {
						nRet = lruCache.set(inParms[1], inParms[2]);
						if (nRet == LRUCache.OK) {
							System.out.println("SET OK");
						} else {
							System.out.println("ERROR");
						}
					}
				} catch (Exception e) {
					System.out.println("ERROR");
				}
			}
		}
		scanner.close();
		// -------------------- program test input -------------------------
		/*
		 * INPUT ------------- OUTPUT ------------- GET foo NOTFOUND SET foo 1
		 * SET OK GET foo GOT 1 SET foo 1.1 SET OK GET foo GOT 1.1 SET spam 2
		 * SET OK GET spam GOT 2 SET ham third SET OK SET parrot four SET OK GET
		 * foo NOTFOUND GET spam GOT 2 GET ham GOT third GET ham parrot ERROR
		 * GET parrot GOT four
		 */
		// -------------------------------------------------------------------
	}
}
