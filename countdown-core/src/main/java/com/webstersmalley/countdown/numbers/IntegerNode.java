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

public class IntegerNode implements Node {
    private int value;

    public IntegerNode(int value) {
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object oNode) {
        if (this == oNode) {
            return true;
        }
        if (oNode instanceof IntegerNode) {
            return this.value == ((IntegerNode) oNode).getValue();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return value;
    }

    public int getComplexity() {
        return 1;
    }
}
