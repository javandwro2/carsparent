package pl.jwrabel.javandwro2.cars.java8;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by jakubwrabel on 20.03.2017.
 */
public class MorseStreams {
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

	public static BiMap<String, String> biMap = HashBiMap.create();

	static {
		for (int i = 0; i < alpha.length; i++) {
			biMap.put(alpha[i], dottie[i]);
		}
	}

	public static String translateToMorse(String text) {
		return Arrays.stream(text.split(""))
				.map(letter -> biMap.get(letter.toLowerCase()))
				.collect(Collectors.joining(" "));
	}
}
