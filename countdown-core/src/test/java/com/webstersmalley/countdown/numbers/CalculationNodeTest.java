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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CalculationNodeTest {
    public boolean isCommutative(Node n1, Node n2, Operator o) {
        CalculationNode c1 = new CalculationNode(n1, n2, o);
        CalculationNode c2 = new CalculationNode(n2, n1, o);
        return (c1.equals(c2));
    }

    @Test
    public void testCalculationNodeEquality() {
        Node n1 = new IntegerNode(1);
        Node n2 = new IntegerNode(2);
        for (Operator o : Operator.values()) {
            switch (o) {
                case PLUS:
                    assertTrue(isCommutative(n1, n2, o));
                    break;
                case MINUS:
                    assertFalse(isCommutative(n1, n2, o));
                    break;
                case TIMES:
                    assertTrue(isCommutative(n1, n2, o));
                    break;
                case DIVIDE:
                    assertFalse(isCommutative(n1, n2, o));
                    break;
                case IGNORE_LEFT:
                    assertFalse(isCommutative(n1, n2, o));
                    break;
                case IGNORE_RIGHT:
                    assertFalse(isCommutative(n1, n2, o));
                    break;
            }
        }
    }
}
