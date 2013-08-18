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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute {

    public List<List<Integer>> getPermutations(List<Integer> input) {
        List<List<Integer>> resultsList = new ArrayList<List<Integer>>();

        if (input == null) {
            return null;
        } else if (input.size() == 0) {
            return resultsList;
        }

        List<Integer> seed = new ArrayList<Integer>();
        seed.addAll(input);

        Collections.sort(seed);

        List<Integer> next = new ArrayList<Integer>();
        next.addAll(seed);
        resultsList.add(next);

        next = new ArrayList<Integer>();

        while (getNextPermutation(seed, next)) {
            resultsList.add(next);
            next = new ArrayList<Integer>();
        }

        return resultsList;
    }

    private boolean getNextPermutation(List<Integer> deck, List<Integer> next) {
        /*
        Algorithm cribbed from Wikipedia - http://en.wikipedia.org/wiki/Permutation
   1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
   2. Find the largest index l such that a[k] < a[l]. Since k + 1 is such an index, l is well defined and satisfies k < l.
   3. Swap a[k] with a[l].
   4. Reverse the sequence from a[k + 1] up to and including the final element a[n].

         */
        int k = -1;
        int l = -1;
        for (int i = 0; i < deck.size() - 1; i++) {
            if (deck.get(i) < deck.get(i + 1)) {
                k = i;
            }
        }
        if (k == -1) {
            return false;
        }


        for (int i = k; i < deck.size(); i++) {
            if (deck.get(k) < deck.get(i)) {
                l = i;
            }
        }

        Collections.swap(deck, k, l);
        Collections.reverse(deck.subList(k + 1, deck.size()));

        next.addAll(deck);
        return true;

    }
}
