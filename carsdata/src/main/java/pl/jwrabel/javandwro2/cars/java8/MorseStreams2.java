package pl.jwrabel.javandwro2.cars.java8;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by jakubwrabel on 20.03.2017.
 */
public class MorseStreams2 {
	public static void main(String[] args) {
		System.out.println(translateToMorse("Ratunku"));
	}

	public static String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "0", " "};
	public static String[] dottie = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
			"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
			"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
			"-.--", "--..", ".----", "..---", "...--", "....-", ".....",
			"-....", "--...", "---..", "----.", "-----", "|"};


	public static String translateToMorse(String text) {
//		return Arrays.stream(text.split("")).
		IntStream.range(1, 100).filter(x -> x == 0).findFirst().getAsInt();
		return "NONE";
	}

}
