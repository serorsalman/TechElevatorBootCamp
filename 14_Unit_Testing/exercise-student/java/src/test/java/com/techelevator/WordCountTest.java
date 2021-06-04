package com.techelevator;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {
    @Test
    public void getCountMapTest_send_in_babaBlackSheep_returns_numbers() {
        WordCount wordCount = new WordCount();
        Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("ba", 2);
        expectedWordCount.put("sheep", 1);
        expectedWordCount.put("black", 1);


        String[] words = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> actualWordCount = wordCount.getCount(words);
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }

    @Test
    public void getCountMapTest_send_in_null_returns_numbers() {
        WordCount wordCount = new WordCount();
        Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();


        String[] words = {};
        Map<String, Integer> actualWordCount = wordCount.getCount(words);
        assertEquals(expectedWordCount, actualWordCount);
    }
    @Test
    public void getCountMapTest_send_in_abAbC_returns_numbers() {
        WordCount wordCount = new WordCount();
        Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("a", 2);
        expectedWordCount.put("b", 2);
        expectedWordCount.put("c", 1);


        String[] words = {"a", "b", "a", "c", "b"};
        Map<String, Integer> actualWordCount = wordCount.getCount(words);
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }
    @Test
    public void getCountMapTest_send_in_cBa_returns_numbers() {
        WordCount wordCount = new WordCount();
        Map<String, Integer> expectedWordCount = new HashMap<String, Integer>();
        expectedWordCount.put("a", 1);
        expectedWordCount.put("b", 1);
        expectedWordCount.put("c", 1);


        String[] words = {"c", "b", "a"};
        Map<String, Integer> actualWordCount = wordCount.getCount(words);
        assertEquals(
                expectedWordCount, actualWordCount
        );
    }
}