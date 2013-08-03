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
import java.util.List;

public class NumbersBean {
    private List<Integer> numbers;
    private int target;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public NumbersBean(String input) {
        numbers = new ArrayList<Integer>();
        String[] bits = input.split(",");
        if (bits.length < 2) {
            throw new RuntimeException("Error parsing numbers: " + input);
        }
        for (int i = 0; i < bits.length - 1; i++) {
            numbers.add(new Integer(bits[i]));
        }
        target = new Integer(bits[bits.length - 1]);
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int number : numbers) {
            sb.append(number);
            sb.append(" ");
        }
        sb.append("= ");
        sb.append(target);
        return sb.toString();
    }
}
