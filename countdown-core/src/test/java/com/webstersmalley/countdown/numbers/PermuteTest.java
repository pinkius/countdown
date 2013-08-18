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

package com.webstersmalley.countdown.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PermuteTest {

    @Test
    public void testPermute1() {
        Permute p = new Permute();
        List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        List<List<Integer>> results = p.getPermutations(input);

        assertEquals(results.size(), 1);
        List<Integer> singleResult = results.get(0);
        assertEquals(singleResult.size(), 1);
        assertEquals(singleResult.get(0), new Integer(1));
    }

    @Test
    public void testPermute2() {
        Permute p = new Permute();
        List<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        List<List<Integer>> results = p.getPermutations(input);

        assertEquals(results.size(), 2);
        List<Integer> singleResult = results.get(0);
        assertEquals(singleResult.size(), 2);
        assertEquals(singleResult.get(0), new Integer(1));
    }

    @Test
    public void testPermute0() {
        Permute p = new Permute();
        List<Integer> input = new ArrayList<Integer>();
        List<List<Integer>> results = p.getPermutations(input);
        assertEquals(results.size(), 0);
    }

    @Test
    public void testPermuteNull() {
        Permute p = new Permute();
        List<Integer> input = null;
        List<List<Integer>> results = p.getPermutations(input);
        assertNull(results);
    }


}
