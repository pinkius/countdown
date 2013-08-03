/*
 * Copyright 2013 Webster Smalley
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webstersmalley.countdown.words;

import com.webstersmalley.countdown.db.CountdownDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("wordCounter")
public class WordCounter {
    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private CountdownDao countdownDao;

    private boolean populated = false;

    private final static int LENGTH_THRESHOLD = 4;
    private final static int COUNT_THRESHOLD = 1;

    private Map<String, Integer> wordMap = new HashMap<String, Integer>();

    public void parseResource(String location) {
        long startTime = System.currentTimeMillis();
        InputStream is = null;
        BufferedReader br = null;
        try {
            is = getClass().getResourceAsStream(location);
            br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine();

            while (line != null) {
                parseLine(line);
                line = br.readLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Error getting count: ", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {

                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                }
            }


        }
        long endTime = System.currentTimeMillis();

        logger.info("Parse of " + location + " complete. Time taken: " + (endTime - startTime) + "ms.");
    }

    private void parseLine(String line) {
        String[] words = line.split(" ");
        for (String word : words) {
            addWord(word);
        }
    }

    private void addWord(String word) {
        String sanitisedWord = sanitiseWord(word);
        if (sanitisedWord != null && sanitisedWord.length() >= LENGTH_THRESHOLD) {
            Integer count = wordMap.get(sanitisedWord);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            wordMap.put(sanitisedWord, count);
        }
    }

    private String sanitiseWord(String input) {
        if (input == null) {
            return null;
        }
        return input.toUpperCase().replaceAll("[^A-Z]", "");
    }

    public Map<String, Integer> getWords() {
        return wordMap;
    }

    public void printStatistics() {
        logger.info("Current number of words: " + wordMap.keySet().size());
    }

    public void saveToDatabase() {
        long startTime = System.currentTimeMillis();
        for (String word : wordMap.keySet()) {
            if (wordMap.get(word) >= COUNT_THRESHOLD) {
                WordBean bean = new WordBean(word);
                countdownDao.addWord(bean);
            }
        }
        long endTime = System.currentTimeMillis();

        logger.info("Saving to db complete. Time taken: " + (endTime - startTime) + "ms.");
    }

    public synchronized void check() {
        if (!populated) {
            parseResource("/2+2lemma.txt");
            printStatistics();
            saveToDatabase();
            populated = true;
        }
    }

    public List<WordBean> getMatches(String input) {
        check();
        logger.info("Looking for matches to : " + input);
        long startTime = System.currentTimeMillis();
        List<WordBean> matches = countdownDao.getMatches(input);
        long endTime = System.currentTimeMillis();
        logger.info("Lookup time taken: " + (endTime - startTime) + "ms. Matches found: " + matches.size());

        Collections.sort(matches);
        return matches;
    }

    public void listMatches(String input) {
        List<WordBean> matches = getMatches(input);
        for (WordBean match : matches) {
            logger.info(" -> " + match);
        }

    }
}
