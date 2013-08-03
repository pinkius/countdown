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

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class WordCounterTest {
    private WordCounter wc;

    public void checkMatches(String anagram, String matchWord, int minimumMatches) {
        List<WordBean> matches = wc.getMatches(anagram);
        assertTrue(matches.size() >= minimumMatches);

        boolean assertion = false;
        for (WordBean match : matches) {
            if (match.getTheWord().equals(matchWord)) {
                assertion = true;
                break;
            }
        }
        assertTrue(assertion);
    }

    @Test
    public void testWordCounter() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        wc = (WordCounter) ac.getBean("wordCounter");

        checkMatches("LEAWH", "WHALE", 1);
        checkMatches("SAILS", "SAIL", 2);
        checkMatches("GREYHOUND", "GREYHOUND", 3);
    }

}
